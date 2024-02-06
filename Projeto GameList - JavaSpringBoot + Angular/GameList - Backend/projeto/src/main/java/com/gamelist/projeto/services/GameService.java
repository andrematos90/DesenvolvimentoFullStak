package com.gamelist.projeto.services;

import com.gamelist.projeto.entities.Game;
import com.gamelist.projeto.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<Game> findAll(){
        List<Game> result = gameRepository.findAll();
        return result.stream().map(Game::new).toList();
    }
}
