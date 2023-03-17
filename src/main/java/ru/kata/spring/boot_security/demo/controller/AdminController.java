package ru.kata.spring.boot_security.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;

@Controller
@RequestMapping("/admin")
public class AdminController {
	private final UserService userService;
	private final RoleService roleService;

	public AdminController(UserService userService, RoleService roleService) {
	    this.userService = userService;
		this.roleService = roleService;
	}

    @GetMapping()
    public String show(Principal principal, Model model) {
        User admin = userService.findByUsername(principal.getName());
        model.addAttribute("admin", admin);

		model.addAttribute("users", userService.allUsers());
		model.addAttribute("userRoles", roleService.getAllRoles());

		model.addAttribute("userNew", new User());
		model.addAttribute("rolesNew", roleService.getAllRoles());

		return "admin";
    }

	//Добавление юзера
	@PostMapping("")
	public String addUser(@ModelAttribute("user") User user) {
		userService.saveUser(user);
		return "redirect:/admin";
	}

	//Редактирование юзера
	@PatchMapping("/{id}")
	public String update(@ModelAttribute("user") User user, @PathVariable("id") long id) {
		userService.update(user, id);
		return "redirect:/admin";
	}

	// удаление юзера
	@GetMapping( "/{id}/delete")
	public String deleteUser (@PathVariable("id") Long id) {
		userService.deleteUser(id);
		return "redirect:/admin";
	}
}