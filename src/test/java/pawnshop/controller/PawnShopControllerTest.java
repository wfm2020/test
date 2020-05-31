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

    @Test(expected = IllegalArgumentException.class)
    public void givenNullPawnData_whenCreate_returnException(){
        pawnShopController.create(null);
    }

}
