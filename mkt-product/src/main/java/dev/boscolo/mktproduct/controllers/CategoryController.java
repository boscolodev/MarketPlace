package dev.boscolo.mktproduct.controllers;

import dev.boscolo.mktproduct.model.dto.CategoryGetDTO;
import dev.boscolo.mktproduct.model.dto.CategoryInsertDTO;
import dev.boscolo.mktproduct.model.entities.Category;
import dev.boscolo.mktproduct.services.CategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping
    public Page<CategoryGetDTO> findAll(Pageable pageable){
        return service
                .findAll(pageable)
                .map(Category::toDTO);
    }

    @GetMapping("{id}")
    public CategoryGetDTO findById(@PathVariable Long id){
        return service
                .findById(id)
                .toDTO();
    }

    @PostMapping
    public CategoryInsertDTO insert(@RequestBody CategoryInsertDTO dto){
        dto = service.insert(dto);
        return dto;
    }

    @PutMapping("{id}")
    public CategoryInsertDTO update(@PathVariable Long id, @RequestBody CategoryInsertDTO dto){
        dto = service.update(id, dto);
        return dto;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
