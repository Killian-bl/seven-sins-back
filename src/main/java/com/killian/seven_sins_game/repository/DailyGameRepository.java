package com.killian.seven_sins_game.repository;

import com.killian.seven_sins_game.model.DailyGame;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;

public interface DailyGameRepository extends JpaRepository<DailyGame, Integer> {
    DailyGame findByGameDate(LocalDate date);
}