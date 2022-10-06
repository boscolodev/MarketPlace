package dev.boscolo.mktuser.services;

import dev.boscolo.mktuser.dto.UserInsertDTO;
import dev.boscolo.mktuser.entities.User;
import dev.boscolo.mktuser.exceptions.DatabaseException;
import dev.boscolo.mktuser.exceptions.ResourceNotFoundException;
import dev.boscolo.mktuser.repositories.UserRepository;
import dev.boscolo.mktuser.utils.MapperUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<User> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Page<User> findAllPaged(final Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Transactional
    public User findById(final Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Entity not Found"));
    }

    @Transactional(readOnly = true)
	public User findByEmail(String email) {
		if(email.isBlank()) {
			throw new ResourceNotFoundException("Insert a valid e-mail.");
		}
    	if(!repository.existsByEmail(email)) {
			throw new DatabaseException("Email not found.");
		}
        return repository.findByEmail(email);
	}

    @Transactional
    public void delete(final Long id) {
        repository.deleteById(id);
    }

    @Transactional
    public UserInsertDTO insert(final UserInsertDTO dto) {
        if (repository.existsByEmail(dto.getEmail()))  {
            throw new DatabaseException("Email already exists!");
        }
        return repository.save((dto.toEntity())).toInsertDTO();
    }

    @Transactional
    public UserInsertDTO update(final long id, UserInsertDTO dto) {

        if (repository.existsByEmail(dto.getEmail())) {
            throw new DatabaseException("Email already exists!");
        }

        var entityDb = findById(id);
        dto.setId(id);
        MapperUtil.copyEntity(dto, entityDb);
        return repository.save(entityDb).toInsertDTO();
    }

}
