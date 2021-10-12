package com.mastek.pizzania.service;

import com.mastek.pizzania.dto.ApiResponse;
import com.mastek.pizzania.dto.LoginDto;
import com.mastek.pizzania.dto.SignUpDto;

public interface UserService {

    ApiResponse signUp(SignUpDto signUpDto);

    ApiResponse login(LoginDto loginDto);
}
