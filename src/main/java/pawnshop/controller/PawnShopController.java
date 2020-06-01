package pawnshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import pawnshop.dto.DeliveryDataDTO;
import pawnshop.dto.PawnDataDTO;
import pawnshop.dto.PawnedItemDTO;
import pawnshop.entity.DeliveryData;
import pawnshop.entity.PawnedItem;
import pawnshop.response.GeneralResponse;
import pawnshop.service.PawnShopService;

@RestController
@RequestMapping("/pawnshop")
class PawnShopController {

    @Autowired
    private PawnShopService pawnShopService;

    // creates customer and pawn data
    @PostMapping(value = "/addPawnData")
    public Long create(@RequestBody PawnDataDTO data) {
        if (data == null) {
            throw new IllegalArgumentException("No data inserted!");
        }
        if (StringUtils.isEmpty(data.getItemName())) {
            throw new IllegalArgumentException("Insert the item name!");
        }
        if (StringUtils.isEmpty(data.getMaterial())) {
            throw new IllegalArgumentException("Insert the material type!");
        }
        if (StringUtils.isEmpty(data.getWeight())) {
            throw new IllegalArgumentException("Insert the weight!");
        }
        if (StringUtils.isEmpty(data.getEmail())) {
            throw new IllegalArgumentException("Insert email!");
        }

        return pawnShopService.create(data).getId();
    }

    // creates delivery data
    @PostMapping(value = "/addDeliveryData")
    public Long createDelivery(@RequestBody DeliveryDataDTO data) {
        if (data == null) {
            throw new IllegalArgumentException("No data inserted!");
        }
        if (data.getDateTime() == null) {
            throw new IllegalArgumentException("No time inserted");
        }
        if (data.getPawnedItemId() == 0) {
            throw new IllegalArgumentException("No pawn ID inserted");
        }

        return pawnShopService.create(data).getId();
    }

    // get pawn by id
    @GetMapping(value = "/pawnedItem/{id}")
    public PawnedItemDTO getPawn(@PathVariable("id") Long id) {
        PawnedItem pawnedItem = pawnShopService.getPawnItemById(id);
        PawnedItemDTO pawnedItemDTO = new PawnedItemDTO();
        pawnedItemDTO.setItemName(pawnedItem.getItemName());
        pawnedItemDTO.setWeight(pawnedItem.getWeight());
        pawnedItemDTO.setPrice(pawnedItem.getPrice());
        pawnedItemDTO.setAccepted(pawnedItem.isAccepted());
        pawnedItemDTO.setMaterial(pawnedItem.getMaterial());
        pawnedItemDTO.setPayed(pawnedItem.isPayed());
        return pawnedItemDTO;
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

    @PutMapping(value = "/updateAccepted")
    @ResponseStatus(HttpStatus.OK)
    public Long updateAccepted(@RequestBody PawnedItemDTO data) {
        return pawnShopService.updatePawnedItemAccepted(data).getId();
    }

}
