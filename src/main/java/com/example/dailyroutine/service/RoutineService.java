package com.example.dailyroutine.service;

import com.example.dailyroutine.model.dto.CreateRoutineDto;
import com.example.dailyroutine.model.entity.Routine;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public interface RoutineService {
    Routine createRoutine(HttpServletRequest request, CreateRoutineDto createRoutineRequest);
    List<Routine> getAllRoutine();
    Routine getRoutineById(Long id);
}
