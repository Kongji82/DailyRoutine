package com.example.dailyroutine.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"user"})
public class Routine {
    @Id
    @Column(name = "routine_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Todo> todos;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
