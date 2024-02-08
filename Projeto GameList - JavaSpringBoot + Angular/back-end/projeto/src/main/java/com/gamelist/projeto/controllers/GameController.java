package com.gamelist.projeto.controllers;

import com.gamelist.projeto.entities.GameEntity;
import com.gamelist.projeto.services.GameService;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {
    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameEntity> findAllGames(){
        List<GameEntity> games = gameService.findAll();
        return games;

    }
}
