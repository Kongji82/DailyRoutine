package com.example.dailyroutine.service;

import com.example.dailyroutine.dto.CreateRoutineDto;
import com.example.dailyroutine.entity.Routine;
import com.example.dailyroutine.entity.User;

import java.util.List;

public interface RoutineService {
    Routine createRoutine(User user, CreateRoutineDto createRoutineRequest);
    List<Routine> getAllRoutine();
    Routine getRoutineById(Long id);

}
