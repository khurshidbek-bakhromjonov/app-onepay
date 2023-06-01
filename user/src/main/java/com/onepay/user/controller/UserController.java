package com.onepay.user.controller;

import com.onepay.user.dto.UserDTO;
import com.onepay.user.entity.User;
import com.onepay.user.service.UserService;
import com.onepay.user.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Integer id) {
        User user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addNewUser(@RequestBody UserDTO userDTO) {
        userService.addUser(userDTO);
        return new ResponseEntity<>("Add new user.", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Integer id) {
        userService.deleteById(id);
        return ResponseEntity.ok("Delete user.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable("id") Integer id,
                                             @RequestBody UserDTO user) {
        userService.updateById(id, user);
        return ResponseEntity.ok("Update user.");
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> changeBalance(@PathVariable("id") Integer id,
                                                @RequestParam("newBalance") BigDecimal balance) {
        userService.updateBalanceById(id, balance);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
