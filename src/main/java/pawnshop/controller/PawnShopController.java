package pawnshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import pawnshop.dto.DeliveryDataDTO;
import pawnshop.dto.PawnDataDTO;
import pawnshop.entity.DeliveryData;
import pawnshop.entity.PawnedItem;
import pawnshop.response.GeneralResponse;
import pawnshop.service.PawnShopService;

@RestController
@RequestMapping("/pawnshop")
class PawnShopController {

    @Autowired
    private PawnShopService pawnShopService;

    // automatically evaluates the price of a pawn item
    @GetMapping(value = "/pawn/evaluate")
    public PawnedItem evaluate(@RequestBody PawnedItem data) {
        // TODO: inline script?
        return null;
    }

    // creates customer and pawn data
    @PostMapping(value = "/addPawnData")
    public ResponseEntity<GeneralResponse> create(@RequestBody PawnDataDTO data) {
        if (data == null) {
            throw new IllegalArgumentException("No data inserted!");
        }
        if (StringUtils.isEmpty(data.getMaterial())) {
            throw new IllegalArgumentException("Insert the material type!");
        }
        if (StringUtils.isEmpty(data.getWeight())) {
            throw new IllegalArgumentException("Insert the weight!");
        }
        if (StringUtils.isEmpty(data.getFirstName())) {
            throw new IllegalArgumentException("Insert first name!");
        }
        if (StringUtils.isEmpty(data.getLastName())) {
            throw new IllegalArgumentException("Insert last name!");
        }
        if (StringUtils.isEmpty(data.getEmail())) {
            throw new IllegalArgumentException("Insert email!");
        }
        if (StringUtils.isEmpty(data.getPhoneNumber())) {
            throw new IllegalArgumentException("Insert phone number!");
        }

        pawnShopService.create(data);

        return ResponseEntity.status(HttpStatus.CREATED).body(new GeneralResponse(true, "SUCCESS: PawnData saved successfully"));

    }

    // creates delivery data
    @PostMapping(value = "/addDeliveryData")
    public ResponseEntity<GeneralResponse> createDelivery(@RequestBody DeliveryDataDTO data) {
        if(data == null){
            throw new IllegalArgumentException("No data inserted!");
        }
        else if(data.getDateTime() == null){
            throw new IllegalArgumentException("No time inserted");
        }

        pawnShopService.create(data);

        return ResponseEntity.status(HttpStatus.CREATED).body(new GeneralResponse(true, "SUCCESS: DeliveryData saved successfully"));
    }

    // get pawn by id
    @GetMapping(value = "/pawnedItem/{id}")
    public PawnedItem getPawn(@PathVariable("id") Long id) {
        return pawnShopService.getPawnItemById(id);
    }

    // get delivery data by id
    @GetMapping(value = "/deliveryData/{id}")
    public DeliveryData getDelivery(@PathVariable("id") Long id) {
        return pawnShopService.getDeliveryData(id);
    }

    @PutMapping(value = "/updatePrice")
    @ResponseStatus(HttpStatus.OK)
    public PawnedItem updatePawn(@RequestBody PawnedItem data) {
        return pawnShopService.updatePawnedItemPrice(data);
    }

    @PutMapping(value = "/updatePayment")
    @ResponseStatus(HttpStatus.OK)
    public PawnedItem updatePayment(@RequestBody PawnedItem data) {
        return pawnShopService.updatePawnedItemPayment(data);
    }

}
