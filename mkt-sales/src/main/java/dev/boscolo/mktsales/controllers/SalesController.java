package dev.boscolo.mktsales.controllers;

import dev.boscolo.mktsales.model.dto.SaleGetDTO;
import dev.boscolo.mktsales.model.dto.SaleInsertDTO;
import dev.boscolo.mktsales.services.SalesService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/sales")
public class SalesController {

    private final SalesService service;

    public SalesController(SalesService service) {
        this.service = service;
    }

    @PostMapping("/postSale")
    public SaleGetDTO postSale(@RequestBody SaleInsertDTO dto){
        return service.postSale(dto);
    }




}
