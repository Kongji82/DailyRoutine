package com.example.dailyroutine.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateRoutineDto {
    private String name;
    private String description;
    private String startTime;
    private String endTime;
    private List<CreateTodoDto> todos;
}
