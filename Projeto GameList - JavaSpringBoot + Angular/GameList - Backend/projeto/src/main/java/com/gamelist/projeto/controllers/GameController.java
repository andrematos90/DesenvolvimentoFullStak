package com.gamelist.projeto.controllers;

import com.gamelist.projeto.entities.Game;
import com.gamelist.projeto.services.GameService;
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
    public List<Game> fimdAll(){
        List<Game> result = gameService.findAll();
        return result;
    }
}
