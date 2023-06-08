package com.example.dailyroutine.repository;

import com.example.dailyroutine.model.entity.Routine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoutineRepository extends JpaRepository<Routine, Long> {
}
