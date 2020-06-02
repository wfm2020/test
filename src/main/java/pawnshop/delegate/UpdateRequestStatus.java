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
    public void execute(DelegateExecution execution) {

        Long pawnedItemId = (Long) execution.getVariable("pawnedItemId");
        boolean isRequestAcceptable = false;
        boolean isPaymentAccepted = false;

        if(execution.getVariable("isAcceptable") != null){
            isRequestAcceptable = (boolean) execution.getVariable("isAcceptable");
        }

        if(execution.getVariable("isPaymentAccepted") != null){
            isPaymentAccepted = (boolean) execution.getVariable("isPaymentAccepted");
        }

        RestTemplate restTemplate = new RestTemplate();

        PawnedItemDTO pawnedItemDTO = restTemplate
                .getForObject("http://localhost:8080/pawnshop/pawnedItem/" + pawnedItemId,
                        PawnedItemDTO.class);

        if(pawnedItemDTO != null){
            pawnedItemDTO.setId(pawnedItemId);
            HttpEntity<PawnedItemDTO> updateRequest = new HttpEntity<>(pawnedItemDTO);

            if(pawnedItemDTO.isAccepted() != isRequestAcceptable){
                pawnedItemDTO.setAccepted(isRequestAcceptable);
                ResponseEntity<Long> responsePost = restTemplate
                        .exchange("http://localhost:8080/pawnshop/updateAccepted", HttpMethod.PUT,
                                updateRequest,
                                Long.class);
            }
            if(pawnedItemDTO.isPayed() != isPaymentAccepted){
                pawnedItemDTO.setPayed(isPaymentAccepted);
                ResponseEntity<Long> responsePost = restTemplate
                        .exchange("http://localhost:8080/pawnshop/updatePayment", HttpMethod.PUT,
                                updateRequest,
                                Long.class);
            }



        }


    }
}
