package com.example.dailyroutine.controller;

import com.example.dailyroutine.dto.UpdateUserDto;
import com.example.dailyroutine.entity.User;
import com.example.dailyroutine.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserServiceImpl userService;
    @GetMapping("/userinfo")
    public ResponseEntity<User> getUserInfo(@AuthenticationPrincipal User user){
        return ResponseEntity.ok(user);
    }
    @PostMapping("/update")
    public ResponseEntity<User> updateUser(@AuthenticationPrincipal User user, @RequestBody UpdateUserDto updateUserDto){
        System.out.println(updateUserDto);
        User updatedUser = userService.updateUser(user, updateUserDto);
        return ResponseEntity.ok().body(updatedUser);
    }

}