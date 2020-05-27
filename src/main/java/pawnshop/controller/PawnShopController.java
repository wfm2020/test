package pawnshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import pawnshop.dto.PawnCustomerDTO;
import pawnshop.entity.DeliveryData;
import pawnshop.entity.PawnData;
import pawnshop.service.PawnShopService;

@RestController
@RequestMapping("/pawnshop")
class PawnShopController {

    @Autowired
    private PawnShopService pawnShopService;

    // automatically evaluates the price of a pawn item
    @GetMapping(value = "/pawn/evaluate")
    public PawnData evaluate(@RequestBody PawnData data) {
        // TODO: inline script?
        return null;
    }

    // creates customer and pawn data
    @PostMapping(value = "/pawn")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody PawnCustomerDTO data) {
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
    }

    // creates delivery data
    @PostMapping(value = "/delivery")
    @ResponseStatus(HttpStatus.CREATED)
    public DeliveryData createDelivery(@RequestBody DeliveryData data) {
        return pawnShopService.createDelivery(data);
    }

    // get pawn by id
    @GetMapping(value = "/pawn/{id}")
    public PawnData getPawn(@PathVariable("id") Long id) {
        return pawnShopService.getPawn(id);
    }

    // get delivery data by id
    @GetMapping(value = "/delivery/{id}")
    public DeliveryData getDelivery(@PathVariable("id") Long id) {
        return pawnShopService.getDeliveryData(id);
    }

    @PutMapping(value = "/pawn")
    @ResponseStatus(HttpStatus.OK)
    public PawnData updatePawn(@RequestBody PawnData data) {
        return pawnShopService.update(data);
    }

}
