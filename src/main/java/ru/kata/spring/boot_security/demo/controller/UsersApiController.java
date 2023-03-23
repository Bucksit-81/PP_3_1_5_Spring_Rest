//package ru.kata.spring.boot_security.demo.controller;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import ru.kata.spring.boot_security.demo.model.User;
//import ru.kata.spring.boot_security.demo.service.UserService;
//
//import java.security.Principal;
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/user")
//public class UsersApiController {
//
//    private final UserService userService;
//
//    public UsersApiController(UserService userService) {
//        this.userService = userService;
//    }
//
//    @GetMapping("/viewUser")
//    public ResponseEntity<User> showUser(Principal principal){
//        return new ResponseEntity<>(userService.findByUsername(principal.getName()), HttpStatus.OK); //Jacson конвертирует эти объекты в JSON
//    }
//
//}
