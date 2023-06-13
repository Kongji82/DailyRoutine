package com.example.dailyroutine.repository;

import com.example.dailyroutine.entity.Routine;
import com.example.dailyroutine.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RoutineRepository extends JpaRepository<Routine, Long> {
    Optional<Routine> findById(Long id);

    List<Routine> findAllByUser(User user);
}
