package com.example.dailyroutine.repository;

import com.example.dailyroutine.model.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
