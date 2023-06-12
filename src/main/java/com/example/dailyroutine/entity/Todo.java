package com.example.dailyroutine.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @DateTimeFormat(pattern = "HH:mm")
    private String description;
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime startTime;
    private LocalTime endTime;

}
