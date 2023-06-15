package com.example.dailyroutine.service;

import com.example.dailyroutine.dto.AuthenticationRequest;
import com.example.dailyroutine.auth.AuthenticationResponse;
import com.example.dailyroutine.dto.RegisterRequest;

public interface AuthService {
    AuthenticationResponse register(RegisterRequest registerRequest);
    AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest);
}
