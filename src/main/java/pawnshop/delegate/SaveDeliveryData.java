package pawnshop.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import pawnshop.dto.DeliveryDataDTO;

import java.time.ZoneId;
import java.util.Date;

public class SaveDeliveryData implements JavaDelegate {
    public void execute(DelegateExecution execution) throws Exception {
        DeliveryDataDTO deliveryDataDTO = new DeliveryDataDTO();

        deliveryDataDTO.setDateTime(((Date) execution.getVariable("dateTime")).toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime());

        deliveryDataDTO.setPawnedItemId((Long) execution.getVariable("pawnedItemId"));

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<DeliveryDataDTO> request = new HttpEntity<>(deliveryDataDTO);

        ResponseEntity<Long> response = restTemplate
                .exchange("http://localhost:8080/pawnshop/addDeliveryData", HttpMethod.POST, request,
                        Long.class);

        execution.setVariable("pawnedItemId", response.getBody());
    }
}
