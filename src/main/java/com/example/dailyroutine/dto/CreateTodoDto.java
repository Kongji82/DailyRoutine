package com.example.dailyroutine.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


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
