package com.example.dailyroutine.controller;

import com.example.dailyroutine.dto.CreateRoutineDto;
import com.example.dailyroutine.entity.Routine;
import com.example.dailyroutine.entity.Scrap;
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
    public ResponseEntity<Routine> createRoutine(@AuthenticationPrincipal User user, @RequestBody CreateRoutineDto createRoutineDto){
        Routine routine = routineService.createRoutine(user, createRoutineDto);
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

    @GetMapping("/getbyuser")
    public ResponseEntity<List<Routine>> getRoutineByUser(@AuthenticationPrincipal User user){
        List<Routine> routineList = routineService.getRoutineByUser(user);
        return ResponseEntity.ok().body(routineList);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteRoutine(@AuthenticationPrincipal User user, @PathVariable Long id){
        routineService.deleteRoutine(user, id);
        return ResponseEntity.ok().body("Routine deleted");
    }

    @GetMapping("/scrap/{id}")
    public ResponseEntity<String> scrapRoutine(@AuthenticationPrincipal User user, @PathVariable Long id){
        routineService.scrapRoutine(user, id);
        return ResponseEntity.ok().body("Routine scrapped");
    }

    @GetMapping("/scrap/get")
    public ResponseEntity<List<Routine>> getScrapRoutine(@AuthenticationPrincipal User user){
        List<Routine> scrapList = routineService.getScrapRoutine(user);
        return ResponseEntity.ok().body(scrapList);
    }
    @DeleteMapping("/scrap/delete")
    public ResponseEntity<String> deleteScrap(@AuthenticationPrincipal User user, @RequestParam("id") Long id){
        routineService.deleteScrap(user, id);
        return ResponseEntity.ok("Delete Success");

    }
 }
