package com.example.dailyroutine.service;

import com.example.dailyroutine.auth.AuthenticationResponse;
import com.example.dailyroutine.auth.JwtService;
import com.example.dailyroutine.auth.RegisterRequest;
import com.example.dailyroutine.entity.Role;
import com.example.dailyroutine.entity.User;
import com.example.dailyroutine.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AuthServiceImplTest {
    @Mock
    private JwtService jwtService;
    @Mock
    private UserRepository userRepository;
    @Mock
    private PasswordEncoder passwordEncoder;
    @InjectMocks
    private AuthServiceImpl authService;
    private RegisterRequest request;
    private User user;

    @BeforeEach
    public void setUp() {
        request = RegisterRequest.builder()
                .username("john_doe")
                .email("john.doe@example.com")
                .password("password123")
                .build();
        user = User.builder()
                .id(1L)
                .username(request.getUsername())
                .email(request.getEmail())
                .password("encodedPassword")
                .role(Role.USER)
                .build();
    }


    @Test
    void register() {
        when(passwordEncoder.encode(request.getPassword())).thenReturn("encodedPassword");
        when(userRepository.save(any(User.class))).thenReturn(user);
        when(jwtService.generateToken(user)).thenReturn("jwtToken");
        // 실행
        AuthenticationResponse response = authService.register(request);
        // 단언
        assertEquals("jwtToken", response.getToken());
    }

    @Test
    void authenticate() {
    }
}