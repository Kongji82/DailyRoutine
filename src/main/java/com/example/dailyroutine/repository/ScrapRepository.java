package com.example.dailyroutine.repository;

import com.example.dailyroutine.entity.Routine;
import com.example.dailyroutine.entity.Scrap;
import com.example.dailyroutine.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface ScrapRepository extends JpaRepository<Scrap, Long>{
    List<Scrap> findAllByUser(User user);

    List<Scrap> findAllByRoutine(Routine routine);
}
