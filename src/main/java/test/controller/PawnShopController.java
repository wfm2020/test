package test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import test.entity.DeliveryData;
import test.entity.PawnData;
import test.service.PawnShopService;

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
    public PawnData create(@RequestBody PawnData data) {
        return pawnShopService.create(data);
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
