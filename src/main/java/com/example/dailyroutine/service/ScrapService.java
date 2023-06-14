package com.example.dailyroutine.service;

import com.example.dailyroutine.entity.Routine;
import com.example.dailyroutine.entity.User;

import java.util.List;

public interface ScrapService {
    void scrapRoutine(User user, Long routineId);

    List<Routine> getScrapRoutine(User user);

    void deleteScrap(User user, Long routineId);


}
