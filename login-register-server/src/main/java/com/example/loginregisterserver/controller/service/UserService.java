package com.example.loginregisterserver.controller.service;

import com.example.loginregisterserver.message.request.LoginForm;
import com.example.loginregisterserver.message.request.SignUpForm;
import com.example.loginregisterserver.message.response.JwtResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Service
public interface UserService {
    JwtResponse authenticateUser(@Valid @RequestBody LoginForm loginRequest);

    Object registerUser(SignUpForm signUpRequest);
}
