package com.killian.seven_sins_game.controller;

import com.killian.seven_sins_game.model.Character;
import com.killian.seven_sins_game.repository.CharacterRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/characters")
@CrossOrigin(origins = "https://seven-deadly-sins-dle.netlify.app")
public class CharacterController {

    private final CharacterRepository characterRepository;

    public CharacterController(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    @GetMapping("/search")
    public List<Character> search(@RequestParam String name) {
        return characterRepository.findByNameContainingIgnoreCase(name);
    }
}