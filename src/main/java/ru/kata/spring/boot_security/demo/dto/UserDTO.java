package ru.kata.spring.boot_security.demo.dto;

import org.hibernate.annotations.Cascade;
import ru.kata.spring.boot_security.demo.model.Role;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

public class UserDTO {
    @NotBlank(message = "Поле username не может быть пустым")
    @Size(min = 5, max = 50, message = "Поле должно содержать от 5 до 50 символов")
    private String username;
    @NotBlank(message = "Поле First Name не может быть пустым")
    @Size(min = 1, max = 50, message = "Поле должно содержать от 1 до 50 символов")
    private String firstName;
    @NotBlank(message = "Поле Last name не может быть пустым")
    @Size(min = 1, max = 50, message = "Поле должно содержать от 1 до 50 символов")
    private String lastName;

    private int age;
    @NotBlank(message = "Поле password не может быть пустым")
    private String password;
    private Set<Role> roleList;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(Set<Role> roleList) {
        this.roleList = roleList;
    }
    //    public UserDTO(String username, String firstName, String lastName, int age, String password, Set<Role> roleList) {
//        this.username = username;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.age = age;
//        this.password = password;
//        this.roleList = roleList;
//    }
}
