package com.example.dailyroutine.controller;

import com.example.dailyroutine.dto.AuthenticationRequest;
import com.example.dailyroutine.auth.AuthenticationResponse;
import com.example.dailyroutine.auth.JwtService;
import com.example.dailyroutine.dto.RegisterRequest;
import com.example.dailyroutine.service.AuthServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
        return ResponseEntity.ok(authService.register(registerRequest));
    }
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest request){
        return ResponseEntity.ok(authService.authenticate(request));
    }

    @PostMapping("/verify")
    public ResponseEntity<Boolean> authenticate(@RequestBody HashMap<String, String> map){
        String token = map.get("token");
        Boolean tokenExpired = jwtService.isTokenExpired(token);
        return ResponseEntity.ok(tokenExpired);
    }


}
