package com.gamelist.projeto.services;

import com.gamelist.projeto.dtos.GameMinDto;
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
    public List<GameMinDto> findAll(){
        List<Game> result = gameRepository.findAll();
        List<GameMinDto>  dto = result.stream().map(x -> new GameMinDto(x)).toList();

        return  dto;
    }

    @Transactional(readOnly = false)
    public GameMinDto findById(Long id){
        Game result = gameRepository.findById(id).get();
        GameMinDto dto = new GameMinDto(result);
        return dto;
    }
}
