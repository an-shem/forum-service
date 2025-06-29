package ait.cohort5860.accounting.controller;

import ait.cohort5860.accounting.dto.RoleDto;
import ait.cohort5860.accounting.dto.UserDto;
import ait.cohort5860.accounting.dto.UserRegisterDto;
import ait.cohort5860.accounting.dto.UserUpdateDto;
import ait.cohort5860.accounting.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class UserController {
    private final UserService userService;


    @PostMapping("/register")
    public UserDto addUser(@RequestBody UserRegisterDto userRegisterDto) {
        return userService.addUser(userRegisterDto);
    }

    @GetMapping("/user/{userName}")
    public UserDto findUserByName(@PathVariable String userName) {
        return userService.findUserByName(userName);
    }

    @PostMapping("/login")
    public UserDto loginUser() {
        return null;
    }

    @DeleteMapping("/user/{userName}")
    public UserDto deleteUser(@PathVariable String userName) {
        return userService.deleteUser(userName);
    }

    @PatchMapping("/user/{userName}")
    public UserDto updateUser(@PathVariable String userName, @RequestBody UserUpdateDto userUpdateDto) {
        return userService.updateUser(userName, userUpdateDto);
    }

    @PatchMapping("/user/{userName}/role/{role}")
    public RoleDto addRole(@PathVariable String userName, @PathVariable String role) {
        return userService.addRole(userName, role);
    }

    @DeleteMapping("/user/{userName}/role/{role}")
    public RoleDto deleteRole(@PathVariable String userName, @PathVariable String role) {
        return userService.deleteRole(userName, role);
    }

    @PatchMapping("/password")
    public void changePassword() {
    }
}
