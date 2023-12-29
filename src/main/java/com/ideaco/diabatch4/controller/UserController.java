package com.ideaco.diabatch4.controller;
import com.ideaco.diabatch4.model.UserModel;
import com.ideaco.diabatch4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user")

public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/data")
    public String getData() {
        return "Hello World";
    }

    @GetMapping("/dataAll")
    public List<UserModel> getDataList() {
        return userService.getDataList();
    }

    @GetMapping("/dataJPQL")
    public Optional<UserModel> getDataJPQL(@RequestParam("userId") int userId) {
        return userService.getDataOptional(userId);
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestParam String userEmail, @RequestParam String userPassword) {
        String result = userService.registerUser(userEmail, userPassword);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestParam String userEmail, @RequestParam String userPassword) {
        String result = userService.loginUser(userEmail, userPassword);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/multipleUsers")
    public List<UserModel> createMultipleUserBody(@RequestBody List<UserModel> userModels) {
        return userService.createMultipleUser(userModels);
    }

    @PutMapping("/updateUserWithBody")
    public UserModel updateUserWithBody(@RequestBody UserModel userModel) {
        return userService.updateUserWithBody(userModel);
    }
}
