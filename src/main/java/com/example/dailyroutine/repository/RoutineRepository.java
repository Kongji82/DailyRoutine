package com.example.dailyroutine.repository;

import com.example.dailyroutine.entity.Routine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoutineRepository extends JpaRepository<Routine, Long> {
    Optional<Routine> findById(Long id);
}
