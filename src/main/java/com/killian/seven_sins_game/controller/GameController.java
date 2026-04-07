package com.killian.seven_sins_game.controller;

import com.killian.seven_sins_game.model.DailyGame;
import com.killian.seven_sins_game.service.GameService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "https://seven-deadly-sins-dle.netlify.app")
@RestController
@RequestMapping("/api/game")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/today")
    public DailyGame getTodayGame() {
        return gameService.getTodayGame();
    }
}