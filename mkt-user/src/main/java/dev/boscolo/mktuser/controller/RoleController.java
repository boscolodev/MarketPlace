package dev.boscolo.mktuser.controller;

import dev.boscolo.mktuser.model.dto.RoleDTO;
import dev.boscolo.mktuser.model.entities.Role;
import dev.boscolo.mktuser.services.RoleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/roles")
public class RoleController {

    private final RoleService service;

    public RoleController(RoleService service) {
        this.service = service;
    }

    @GetMapping("/All")
    public List<RoleDTO> findlAll() {
        List<Role> roleList = service.findAll();
        Role role = new Role();
        return role.toDtoList(roleList);
    }

    @GetMapping
    public Page<RoleDTO> findAllPaged(Pageable pageable) {
        return service
                .findAllPaged(pageable)
                .map(Role::toDTO);
    }

    @GetMapping("{id}")
    public RoleDTO findById(@PathVariable Long id) {
        return service
                .findById(id)
                .toDTO();
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RoleDTO insert(@RequestBody RoleDTO dto) {
        dto = service.insert(dto);
        return dto;
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public RoleDTO update(@PathVariable long id, @RequestBody RoleDTO dto) {
        dto = service.update(id, dto);
        return dto;
    }

}
