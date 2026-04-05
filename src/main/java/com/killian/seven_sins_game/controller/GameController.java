package com.killian.seven_sins_game.controller;

import com.killian.seven_sins_game.model.DailyGame;
import com.killian.seven_sins_game.repository.DailyGameRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/game")
public class GameController {

    private final DailyGameRepository dailyGameRepository;

    public GameController(DailyGameRepository dailyGameRepository) {
        this.dailyGameRepository = dailyGameRepository;
    }

    @GetMapping("/today")
    public DailyGame getTodayGame() {
        return dailyGameRepository.findByGameDate(LocalDate.now());
    }
}