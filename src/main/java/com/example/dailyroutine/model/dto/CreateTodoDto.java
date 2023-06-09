package com.example.dailyroutine.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateTodoDto {
    private String title;
    private String description;
    private String startTime;
    private String endTime;
}
