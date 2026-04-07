package com.killian.seven_sins_game.service;

import com.killian.seven_sins_game.model.Character;
import com.killian.seven_sins_game.model.DailyGame;
import com.killian.seven_sins_game.repository.CharacterRepository;
import com.killian.seven_sins_game.repository.DailyGameRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@Service
public class GameService {

    private final DailyGameRepository dailyGameRepository;
    private final CharacterRepository characterRepository;

    public GameService(DailyGameRepository dailyGameRepository, CharacterRepository characterRepository) {
        this.dailyGameRepository = dailyGameRepository;
        this.characterRepository = characterRepository;
    }

    public DailyGame getTodayGame() {
        LocalDate today = LocalDate.now();

        // Vérifier si un DailyGame existe déjà
        DailyGame todayGame = dailyGameRepository.findByGameDate(today);
        if (todayGame != null) {
            return todayGame;
        }

        // Tirer un personnage aléatoire
        List<Character> allCharacters = characterRepository.findAll();
        if (allCharacters.isEmpty()) {
            throw new RuntimeException("No characters available in the database!");
        }
        Character randomCharacter = allCharacters.get(new Random().nextInt(allCharacters.size()));

        // Créer et sauvegarder le DailyGame
        DailyGame newGame = new DailyGame();
        newGame.setGameDate(today);
        newGame.setCharacter(randomCharacter);
        dailyGameRepository.save(newGame);

        return newGame;
    }
}