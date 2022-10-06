package dev.boscolo.mktuser.services;

import dev.boscolo.mktuser.dto.RoleDTO;
import dev.boscolo.mktuser.entities.Role;
import dev.boscolo.mktuser.exceptions.DatabaseException;
import dev.boscolo.mktuser.exceptions.ResourceNotFoundException;
import dev.boscolo.mktuser.repositories.RoleRepository;
import dev.boscolo.mktuser.utils.MapperUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleService {

    private final RoleRepository repository;

    public RoleService(RoleRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<Role> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Page<Role> findAllPaged(final Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Transactional
    public Role findById(final Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Entity not Found"));
    }

    @Transactional
    public void delete(final Long id) {
        repository.deleteById(id);
    }

    @Transactional
    public RoleDTO insert(final RoleDTO dto) {
        if (repository.existsByAuthority(dto.getAuthority()))  {
            throw new DatabaseException("Authority already exists!");
        }
        return repository.save((dto.toEntity())).toDTO();
    }

    @Transactional
    public RoleDTO update(final long id, RoleDTO dto) {

        if (repository.existsByAuthority(dto.getAuthority())) {
            throw new DatabaseException("Authority already exists!");
        }

        var entityDb = findById(id);
        dto.setId(id);
        MapperUtil.copyEntity(dto, entityDb);
        return repository.save(entityDb).toDTO();
    }
}
