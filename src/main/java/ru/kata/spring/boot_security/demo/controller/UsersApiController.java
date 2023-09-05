package ru.kata.spring.boot_security.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;


@RestController
@RequestMapping("/api/user")
public class UsersApiController {

    private final UserService userService;

    public UsersApiController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/viewUser")
    public ResponseEntity<User> showUser(Principal principal) {
        return ResponseEntity.ok(userService.getUserByUsername(principal.getName()));
    }
}
