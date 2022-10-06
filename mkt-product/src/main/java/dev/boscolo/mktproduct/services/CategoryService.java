package dev.boscolo.mktproduct.services;

import dev.boscolo.mktproduct.model.dto.CategoryInsertDTO;
import dev.boscolo.mktproduct.model.entities.Category;
import dev.boscolo.mktproduct.repositories.CategoryRepository;
import dev.boscolo.mktproduct.services.exceptions.DatabaseException;
import dev.boscolo.mktproduct.services.exceptions.ResourceNotFoundException;
import dev.boscolo.mktproduct.utils.MapperUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryService {

    private final CategoryRepository repository;


    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public Page<Category> findAll(final Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Category findById(final Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Entity not Found"));
    }

    @Transactional
    public CategoryInsertDTO insert(final CategoryInsertDTO dto) {
        if(repository.existsByName(dto.getName())){
            throw new DatabaseException("Product already exists!");
        }
        return repository.save(dto.toEntity()).toInsertDTO();
    }

    @Transactional
    public CategoryInsertDTO update(final Long id, final CategoryInsertDTO dto){
        if(repository.existsByName(dto.getName())){
            throw new DatabaseException("Product already exists!");
        }

        var entityDb = findById(id);
        dto.setId(id);
        MapperUtil.copyEntity(dto, entityDb);
        return repository.save(entityDb).toInsertDTO();
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
