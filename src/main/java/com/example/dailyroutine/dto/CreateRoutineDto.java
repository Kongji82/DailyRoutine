package com.example.dailyroutine.dto;

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
    private String title;
    private String description;
    private List<CreateTodoDto> todos;
}
