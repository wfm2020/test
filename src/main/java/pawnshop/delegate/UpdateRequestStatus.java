package pawnshop.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import pawnshop.dto.PawnDataDTO;
import pawnshop.dto.PawnedItemDTO;
import pawnshop.entity.PawnedItem;
import pawnshop.enums.Material;

import java.time.ZoneId;
import java.util.Date;

public class UpdateRequestStatus implements JavaDelegate {
    public void execute(DelegateExecution execution) throws Exception {

        Long pawnedItemId = (Long) execution.getVariable("pawnedItemId");
        boolean accepted = (boolean) execution.getVariable("isAcceptable");

        RestTemplate restTemplate = new RestTemplate();

        PawnedItemDTO pawnedItemDTO = restTemplate
                .getForObject("http://localhost:8080/pawnshop/pawnedItem/" + pawnedItemId,
                        PawnedItemDTO.class);

        if(pawnedItemDTO != null){
            pawnedItemDTO.setAccepted(accepted);
            pawnedItemDTO.setId(pawnedItemId);
            HttpEntity<PawnedItemDTO> updateRequest = new HttpEntity<>(pawnedItemDTO);

            ResponseEntity<Long> responsePost = restTemplate
                    .exchange("http://localhost:8080/pawnshop/updateAccepted", HttpMethod.PUT,
                            updateRequest,
                            Long.class);
        }


    }
}
