package dev.boscolo.mktproduct.controllers;

import dev.boscolo.mktproduct.model.dto.ProductGetDTO;
import dev.boscolo.mktproduct.model.dto.ProductInsertDTO;
import dev.boscolo.mktproduct.model.entities.Product;
import dev.boscolo.mktproduct.services.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public Page<ProductGetDTO> findAll(Pageable pageable){
        return service
                .findAll(pageable)
                .map(Product::toDTO);
    }

    @GetMapping("{id}")
    public ProductGetDTO findById(@PathVariable Long id){
        return service
                .findById(id)
                .toDTO();
    }

    @PostMapping
    public ProductInsertDTO insert(@RequestBody ProductInsertDTO dto){
        dto = service.insert(dto);
        return dto;
    }

    @PutMapping("{id}")
    public ProductInsertDTO update(@PathVariable Long id, @RequestBody ProductInsertDTO dto){
        dto = service.update(id, dto);
        return dto;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
