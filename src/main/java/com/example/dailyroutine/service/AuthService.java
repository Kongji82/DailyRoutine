package com.example.dailyroutine.service;

import com.example.dailyroutine.auth.AuthenticationRequest;
import com.example.dailyroutine.auth.AuthenticationResponse;
import com.example.dailyroutine.auth.RegisterRequest;

public interface AuthService {
    AuthenticationResponse register(RegisterRequest registerRequest);
    AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest);
}
