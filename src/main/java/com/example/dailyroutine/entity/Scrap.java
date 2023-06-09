package com.example.dailyroutine.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Scrap {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Routine routine;

    @ManyToOne
    private User user;
}
