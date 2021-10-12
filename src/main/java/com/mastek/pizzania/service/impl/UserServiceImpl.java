package com.mastek.pizzania.service.impl;

import com.mastek.pizzania.dao.UserDao;
import com.mastek.pizzania.dto.ApiResponse;
import com.mastek.pizzania.dto.LoginDto;
import com.mastek.pizzania.dto.SignUpDto;
import com.mastek.pizzania.model.User;
import com.mastek.pizzania.service.UserService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public ApiResponse signUp(SignUpDto signUpDto) {
        validateSignUp(signUpDto);
        User user = new User();
        BeanUtils.copyProperties(signUpDto, user);
        userDao.save(user);
        return new ApiResponse(200, "success", user);
    }

    @Override
    public ApiResponse login(LoginDto loginDto) {
        User user = userDao.findByUsername(loginDto.getUsername());
        if(user == null) {
            throw new RuntimeException("User already exist.");
        }
        if(!user.getPassword().equals(loginDto.getPassword())){
            throw new RuntimeException("Password mismatch.");
        }
        return new ApiResponse(200, "Login success", user) ;

    }

    private void validateSignUp(SignUpDto signUpDto) {
    }
}
