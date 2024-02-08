package com.gamelist.projeto.services;

import com.gamelist.projeto.entities.GameEntity;
import com.gamelist.projeto.repositories.GameRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    public GameRepository gameRepository;

    public GameService(GameRepository gameRepository){
        this.gameRepository = gameRepository;
    }

    @Transactional(readOnly = true)
    public List<GameEntity> findAll(){
        List<GameEntity> result = gameRepository.findAll();
        return result;
    }
}
