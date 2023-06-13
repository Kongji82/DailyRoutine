package com.example.dailyroutine.service;

import com.example.dailyroutine.dto.UpdateUserDto;
import com.example.dailyroutine.entity.User;
import com.example.dailyroutine.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    @Override
    public User updateUser(User user, UpdateUserDto updateUserDto) {
        System.out.println(user.toString());
        user.setUsername(updateUserDto.getUsername());
        userRepository.save(user);
        return user;
    }
}
