package com.example.loginregisterserver.service;

import com.example.loginregisterserver.message.request.LoginForm;
import com.example.loginregisterserver.message.request.SignUpForm;
import com.example.loginregisterserver.message.response.JwtResponse;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    JwtResponse authenticateUser(LoginForm loginRequest);

    Object registerUser(SignUpForm signUpRequest);
}
