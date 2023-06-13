package com.example.dailyroutine.controller;

import com.example.dailyroutine.dto.UpdateUserDto;
import com.example.dailyroutine.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
//    @PostMapping("/update")
//    public ResponseEntity<User> updateUser(@AuthenticationPrincipal User user, UpdateUserDto updateUserDto)){
//    }

}