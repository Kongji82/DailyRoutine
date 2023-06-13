package com.example.dailyroutine.service;

import com.example.dailyroutine.dto.UpdateUserDto;
import com.example.dailyroutine.entity.User;

import java.util.Optional;

public interface UserService {
    User updateUser(User user, UpdateUserDto updateUserDto);
}
