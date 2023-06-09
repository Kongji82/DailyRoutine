package com.example.dailyroutine.controller;

import com.example.dailyroutine.model.dto.CreateRoutineDto;
import com.example.dailyroutine.model.entity.Routine;
import com.example.dailyroutine.service.RoutineServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/routine")
@RequiredArgsConstructor
public class RoutineController {
    private final RoutineServiceImpl routineService;
    @PostMapping("/create")
    public ResponseEntity<Routine> createRoutine(HttpServletRequest request, @RequestBody CreateRoutineDto createRoutineDto){
        Routine routine = routineService.createRoutine(request, createRoutineDto);
        return ResponseEntity.ok().body(routine);
    }

}
