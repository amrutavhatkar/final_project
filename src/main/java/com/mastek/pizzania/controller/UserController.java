package com.mastek.pizzania.controller;

import com.mastek.pizzania.dto.ApiResponse;
import com.mastek.pizzania.dto.LoginDto;
import com.mastek.pizzania.dto.SignUpDto;
import com.mastek.pizzania.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    @CrossOrigin(origins = "http://localhost:4200")
    public ApiResponse signUp(@RequestBody SignUpDto signUpDto){
        return userService.signUp(signUpDto);
    }

    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:4200")
    public ApiResponse login(@RequestBody LoginDto loginDto){
        return userService.login(loginDto);
    }
}
