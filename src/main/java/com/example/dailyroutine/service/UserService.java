package com.example.dailyroutine.service;

import com.example.dailyroutine.dto.UpdateUserDto;
import com.example.dailyroutine.entity.User;


public interface UserService {
    User updateUser(User user, UpdateUserDto updateUserDto);
}
