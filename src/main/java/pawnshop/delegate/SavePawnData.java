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
        // camunda somehow does not support float or double types, cast from string instead
        pawnDataDTO.setWeight(Float.parseFloat((String) execution.getVariable("weight")));
        pawnDataDTO.setPrice(Float.valueOf((Long) execution.getVariable("price")));

        pawnDataDTO.setFirstName((String) execution.getVariable("firstName"));
        pawnDataDTO.setLastName((String) execution.getVariable("lastName"));
        pawnDataDTO.setEmail((String) execution.getVariable("email"));
        pawnDataDTO.setPhoneNumber((String) execution.getVariable("phoneNumber"));
        pawnDataDTO.setBirthDate(((Date) execution.getVariable("birthDate")).toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate());

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<PawnDataDTO> request = new HttpEntity<>(pawnDataDTO);

        ResponseEntity<GeneralResponse> response = restTemplate
                .exchange("http://localhost:8080/pawnshop/addPawnData", HttpMethod.POST, request, GeneralResponse.class);

        execution.setVariable("response", response);
    }
}
