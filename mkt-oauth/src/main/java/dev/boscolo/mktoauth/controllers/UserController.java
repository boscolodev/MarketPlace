package dev.boscolo.mktoauth.controllers;

import dev.boscolo.mktoauth.model.dto.UserGetDTO;
import dev.boscolo.mktoauth.services.UserService;
import dev.boscolo.mktoauth.services.exceptions.IllegalArguments;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/email")
    public UserGetDTO findByEmail(@RequestParam String email) {
        try {
            return userService.findByEmail(email);
        } catch (IllegalArgumentException e) {
            throw new IllegalArguments("Illegal Argument");
        }
    }

}
