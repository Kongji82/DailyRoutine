package com.example.dailyroutine.service;

import com.example.dailyroutine.common.exception.EntityNotFoundException;
import com.example.dailyroutine.dto.CreateRoutineDto;
import com.example.dailyroutine.entity.Routine;
import com.example.dailyroutine.entity.Scrap;
import com.example.dailyroutine.entity.Todo;
import com.example.dailyroutine.entity.User;
import com.example.dailyroutine.repository.RoutineRepository;
import com.example.dailyroutine.repository.ScrapRepository;
import com.example.dailyroutine.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoutineServiceImpl implements RoutineService{
    private final RoutineRepository routineRepository;
    private final TodoRepository todoRepository;
    private final ScrapRepository scrapRepository;

    @Override
    public Routine createRoutine(User user,  CreateRoutineDto createRoutineRequest) {
        System.out.println(user);
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


    public List<Routine> getRoutineByUser(User user) {
        return routineRepository.findAllByUser(user);
    }

    public void deleteRoutine(User user, Long id) {
        Routine routine = routineRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("루틴을 찾을 수 없습니다."));



        if (routine.getUser().getId().equals(user.getId())) {
            routineRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("루틴을 찾을 수 없습니다.");
        }
    }

    public void scrapRoutine(User user, Long id) {
        Routine routine = routineRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("루틴을 찾을 수 없습니다."));

        Scrap scrap = Scrap.builder()
                .routine(routine)
                .user(user)
                .build();
        scrapRepository.save(scrap);
    }

    public List<Routine> getScrapRoutine(User user) {
        return scrapRepository.findAllByUser(user).stream()
                .map(Scrap::getRoutine)
                .collect(Collectors.toList());
    }
}
