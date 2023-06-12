package com.example.dailyroutine.controller;

import com.example.dailyroutine.dto.CreateRoutineDto;
import com.example.dailyroutine.entity.Routine;
import com.example.dailyroutine.entity.User;
import com.example.dailyroutine.service.RoutineServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/get")
    public ResponseEntity<List<Routine>> getAllRoutine(){
        List<Routine> routineList = routineService.getAllRoutine();
        return ResponseEntity.ok().body(routineList);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Routine> getRoutine(@PathVariable Long id){
        Routine routine = routineService.getRoutineById(id);
        return ResponseEntity.ok().body(routine);
    }


 }
