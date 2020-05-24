package test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import test.entity.PawnData;
import test.service.PawnShopService;

@RestController
@RequestMapping("/pawnshop")
class PawnShopController {

    @Autowired
    private PawnShopService pawnShopService;

    @PostMapping(value = "/pawn")
    @ResponseStatus(HttpStatus.CREATED)
    public PawnData create(@RequestBody PawnData data) {
        return pawnShopService.create(data);
    }

    @GetMapping(value = "/pawn/{id}")
    public PawnData getPawn(@PathVariable("id") Long id) {
        return pawnShopService.getPawn(id);
    }

    @PutMapping(value = "/pawn/")
    @ResponseStatus(HttpStatus.OK)
    public PawnData updatePawn(@RequestBody PawnData data) {
        return pawnShopService.update(data);
    }

}
