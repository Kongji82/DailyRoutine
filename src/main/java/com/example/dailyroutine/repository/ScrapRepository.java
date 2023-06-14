package com.example.dailyroutine.repository;

import com.example.dailyroutine.entity.Routine;
import com.example.dailyroutine.entity.Scrap;
import com.example.dailyroutine.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ScrapRepository extends JpaRepository<Scrap, Long>{
    List<Scrap> findAllByUser(User user);

    List<Scrap> findAllByRoutine(Routine routine);
    Optional<Scrap> findByRoutine(Routine routine);
    Optional<Scrap> findByRoutineAndUser(Routine routine, User user);
}
