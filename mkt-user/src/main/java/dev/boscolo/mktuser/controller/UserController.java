package dev.boscolo.mktuser.controller;

import dev.boscolo.mktuser.model.dto.UserGetDTO;
import dev.boscolo.mktuser.model.dto.UserInsertDTO;
import dev.boscolo.mktuser.model.entities.User;
import dev.boscolo.mktuser.services.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/All")
    public List<UserGetDTO> findlAll() {
        List<User> userList = service.findAll();
        User user = new User();
        return user.toDtoList(userList);
    }

    @GetMapping
    public Page<UserGetDTO> findAllPaged(Pageable pageable) {
        return service
                .findAllPaged(pageable)
                .map(User::toDTO);
    }
    
    @GetMapping("/email")
    public UserGetDTO findByEmail(@RequestParam String email) {
    	return service.findByEmail(email).toDTO();
    }

    @GetMapping("{id}")
    public UserGetDTO findById(@PathVariable Long id){
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
    public UserInsertDTO insert(@RequestBody UserInsertDTO dto) {
        dto = service.insert(dto);
        return dto;
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserInsertDTO update(@PathVariable long id, @RequestBody UserInsertDTO dto){
        dto = service.update(id, dto);
        return dto;
    }

}
