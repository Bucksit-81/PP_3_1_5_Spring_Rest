package ru.kata.spring.boot_security.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.dto.UserDTO;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;
import ru.kata.spring.boot_security.demo.util.UserNotFoundException;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;


@RestController
@RequestMapping("/api")
public class AdminApiController {
    private final UserService userService;

    public AdminApiController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/viewUser")
    public ResponseEntity<User> showUser(Principal principal){
        return new ResponseEntity<>(userService.findByUsername(principal.getName()), HttpStatus.OK); //Jacson конвертирует эти объекты в JSON
    }

    @GetMapping("/admin/users")
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<>(userService.allUsers(),HttpStatus.OK); //Jacson конвертирует эти объекты в JSON
    }

    @GetMapping("/admin/users/{id}")
    public ResponseEntity<User> getUser (@PathVariable("id") Long id) {
        final User user = userService.findUserById(id);
        if (user == null) {
          throw new UserNotFoundException("User c ID " + id + " не найден в БД");
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/admin/users")
    public ResponseEntity<?> create(@RequestBody @Valid UserDTO userDTO){
        userService.saveUser(convertToUser(userDTO));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @PutMapping("/admin/users/{id}")
    public ResponseEntity<?> update (@PathVariable("id") Long id,
                                     @RequestBody User user) {
        userService.update(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/admin/users/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        final User user = userService.findUserById(id);
        if (user == null) {
            throw new UserNotFoundException("User c ID " + id + " не найден в БД");
        }
        userService.deleteUser(id);
        return new ResponseEntity<>("User c ID" + id + "был удален", HttpStatus.OK);
    }


    private User convertToUser(UserDTO userDTO) {
        User user = new User();

        user.setUsername(userDTO.getUsername());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setAge(user.getAge());
        user.setPassword(userDTO.getPassword());
        user.setRoleList(userDTO.getRoleList());
        return user;
    }


}
