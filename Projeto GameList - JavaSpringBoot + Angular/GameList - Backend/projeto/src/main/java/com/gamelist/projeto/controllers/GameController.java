package com.gamelist.projeto.controllers;

import com.gamelist.projeto.dtos.GameMinDto;
import com.gamelist.projeto.entities.Game;
import com.gamelist.projeto.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {
    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameMinDto> findAll(){
        List<GameMinDto> result = gameService.findAll();
        return result;
    }

@GetMapping(value = "/{id}")
    public GameMinDto findById(@PathVariable Long id){
        GameMinDto result = gameService.findById(id);
        return result;
    }
}
