package pawnshop.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import pawnshop.dto.PawnDataDTO;
import pawnshop.enums.Material;
import pawnshop.response.GeneralResponse;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class SavePawnData implements JavaDelegate {
    public void execute(DelegateExecution execution) throws Exception {
        PawnDataDTO pawnDataDTO = new PawnDataDTO();

        pawnDataDTO.setItemName((String) execution.getVariable("itemName"));
        pawnDataDTO.setMaterial(Material.valueOf((String) execution.getVariable("material")));
        pawnDataDTO.setWeight(Float.valueOf((Long) execution.getVariable("weight")));
        pawnDataDTO.setPrice(Float.valueOf((Long) execution.getVariable("price")));

        String firstName = (String) execution.getVariable("firstName");
        if(firstName != null){
            pawnDataDTO.setFirstName(firstName);
        }
        String lastName = (String) execution.getVariable("lastName");
        if(lastName != null){
            pawnDataDTO.setLastName(lastName);
        }

        pawnDataDTO.setEmail((String) execution.getVariable("email"));


        String phoneNumber = (String) execution.getVariable("phoneNumber");
        if(phoneNumber != null){
            pawnDataDTO.setPhoneNumber(phoneNumber);
        }
        Date birthDate = (Date) execution.getVariable("birthDate");
        if(birthDate != null){
            pawnDataDTO.setBirthDate(birthDate.toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate());
        }

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<PawnDataDTO> request = new HttpEntity<>(pawnDataDTO);

        ResponseEntity<GeneralResponse> response = restTemplate
                .exchange("http://localhost:8080/pawnshop/addPawnData", HttpMethod.POST, request, GeneralResponse.class);

        execution.setVariable("response", response);
    }
}
