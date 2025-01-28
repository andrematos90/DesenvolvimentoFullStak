package com.estudos.gamelist.services;

import com.estudos.gamelist.dtos.GameListDTO;
import com.estudos.gamelist.entities.GameList;
import com.estudos.gamelist.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    //injeção de instancia do gameRepository no service
    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {

        List<GameList> result = gameListRepository.findAll();
        List<GameListDTO> dto = result.stream().map(list -> new GameListDTO(list)).toList();
        return dto;
    }


    
}
