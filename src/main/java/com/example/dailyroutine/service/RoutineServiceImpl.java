package com.example.dailyroutine.service;

import com.example.dailyroutine.auth.JwtService;
import com.example.dailyroutine.common.exception.EntityNotFoundException;
import com.example.dailyroutine.model.dto.CreateRoutineDto;
import com.example.dailyroutine.model.entity.Routine;
import com.example.dailyroutine.model.entity.Todo;
import com.example.dailyroutine.model.entity.User;
import com.example.dailyroutine.repository.RoutineRepository;
import com.example.dailyroutine.repository.TodoRepository;
import com.example.dailyroutine.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoutineServiceImpl implements RoutineService{
    private final RoutineRepository routineRepository;
    private final JwtService jwtService;
    private final TodoRepository todoRepository;

    @Override
    public Routine createRoutine(HttpServletRequest request, CreateRoutineDto createRoutineRequest) {
        String token = request.getHeader("Authorization").substring(7);
        User user = jwtService.extractUser(token);
        List<Todo> todos = createRoutineRequest.getTodos().stream()
                .map(item -> {
                    LocalTime startTime = LocalTime.parse(item.getStartTime());
                    LocalTime endTime = LocalTime.parse(item.getEndTime());

                    Todo todo = Todo.builder()
                            .title(item.getTitle())
                            .description(item.getDescription())
                            .startTime(startTime)
                            .endTime(endTime)
                            .build();

                    todoRepository.save(todo);
                    return todo;
                })
                .collect(Collectors.toList());

        Routine routine = Routine.builder()
                .title(createRoutineRequest.getTitle())
                .description(createRoutineRequest.getDescription())
                .todos(todos)
                .user(user)
                .build();
        return routineRepository.save(routine);
    }

    @Override
    public List<Routine> getAllRoutine() {
        return routineRepository.findAll();
    }

    @Override
    public Routine getRoutineById(Long id) {
        return routineRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("루틴을 찾을 수 없습니다."));
    }

}
