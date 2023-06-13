package com.example.dailyroutine.service;

import com.example.dailyroutine.entity.Routine;
import com.example.dailyroutine.entity.Todo;
import com.example.dailyroutine.repository.RoutineRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@ExtendWith(MockitoExtension.class)
class RoutineServiceImplTest {

    @Mock
    RoutineRepository routineRepository;

    @InjectMocks
    RoutineServiceImpl routineService;

    public List<Todo> todos;
    public Optional<Routine> routine;

    @BeforeEach
    public void setup(){
        todos = List.of(
                Todo.builder()
                        .id(1L)
                        .title("test title")
                        .description("test description")
                        .build(),
                Todo.builder()
                        .id(2L)
                        .title("test title")
                        .description("test description")
                        .build()
        );
        routine = Optional.ofNullable(Routine.builder()
                .id(1L)
                .title("test title")
                .description("test description")
                .todos(todos)
                .build());
    }


    @Test
    void getRoutineById() {
        when(routineRepository.findById(anyLong())).thenReturn(routine);
        Routine getRoutine =  routineService.getRoutineById(1L);

    }
}