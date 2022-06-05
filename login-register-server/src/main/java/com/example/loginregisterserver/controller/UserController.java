package com.example.loginregisterserver.controller;

import com.example.loginregisterserver.service.UserService;
import com.example.loginregisterserver.message.request.LoginForm;
import com.example.loginregisterserver.message.request.SignUpForm;
import com.example.loginregisterserver.message.response.JwtResponse;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Vagharhak Grigoryan
 */

@CrossOrigin( origins = "http://localhost:4200" )
@RestController
@RequestMapping( "/user" )
public class UserController {

    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping( "/signin" )
    public JwtResponse authenticateUser(@Valid @RequestBody LoginForm loginRequest) {
        return userService.authenticateUser(loginRequest);
    }

    @PostMapping( "/signup" )
    public Object registerUser(@Valid @RequestBody SignUpForm signUpRequest) {
        return userService.registerUser(signUpRequest);
    }
}
