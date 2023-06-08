package com.example.dailyroutine.service;

import com.example.dailyroutine.model.dto.CreateRoutineDto;
import com.example.dailyroutine.model.entity.Routine;

public interface RoutineService {
    Routine createRoutine(CreateRoutineDto createRoutineRequest);
}
