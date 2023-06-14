package com.example.dailyroutine.controller;

import com.example.dailyroutine.auth.AuthenticationRequest;
import com.example.dailyroutine.auth.AuthenticationResponse;
import com.example.dailyroutine.auth.JwtService;
import com.example.dailyroutine.auth.RegisterRequest;
import com.example.dailyroutine.entity.User;
import com.example.dailyroutine.service.AuthServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthServiceImpl authService;
    private final JwtService jwtService;
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest registerRequest){
        System.out.println(registerRequest);
        return ResponseEntity.ok(authService.register(registerRequest));
    }
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest request){
        System.out.println(request);
        return ResponseEntity.ok(authService.authenticate(request));
    }

    @PostMapping("/verify")
    public ResponseEntity<Boolean> authenticate(@RequestBody HashMap<String, String> map){
        String token = map.get("token");
        Boolean tokenExpired = jwtService.isTokenExpired(token);
        return ResponseEntity.ok(tokenExpired);
    }


}
