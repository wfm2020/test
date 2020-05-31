package pawnshop.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import pawnshop.Application;
import pawnshop.dto.PawnDataDTO;
import pawnshop.enums.Material;
import pawnshop.response.GeneralResponse;
import pawnshop.service.PawnShopService;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class PawnShopControllerTest {

    @InjectMocks
    PawnShopController pawnShopController;

    @Mock
    PawnShopService pawnShopService;

    @Test
    public void givenPawnData_whenCreate_returnCreated(){
        PawnDataDTO dto = new PawnDataDTO("SilverRing", Material.SILVER, (float) 2, (float) 100, "Max",
                "Mustermann", "max.mustermann@mail.com", LocalDate.of(1994,10,10), "123456789");

        doNothing().when(pawnShopService).create(any(PawnDataDTO.class));
        ResponseEntity<GeneralResponse> responseEntity = pawnShopController.create(dto);

        assert responseEntity.getStatusCode().equals(HttpStatus.CREATED);
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNullPawnData_whenCreate_returnException(){
        pawnShopController.create(null);
    }

}
