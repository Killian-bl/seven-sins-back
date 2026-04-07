package com.killian.seven_sins_game.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class DailyGame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate gameDate;

    @ManyToOne
    @JoinColumn(name = "character_id")
    private Character character;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public LocalDate getGameDate() { return gameDate; }
    public void setGameDate(LocalDate gameDate) { this.gameDate = gameDate; }

    public Character getCharacter() { return character; }
    public void setCharacter(Character character) { this.character = character; }
}