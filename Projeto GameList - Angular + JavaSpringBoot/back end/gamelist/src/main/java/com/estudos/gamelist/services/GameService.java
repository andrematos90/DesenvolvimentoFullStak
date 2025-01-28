package com.estudos.gamelist.services;

import com.estudos.gamelist.dtos.GameMinDTO;
import com.estudos.gamelist.entities.Game;
import com.estudos.gamelist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    //injeção de instancia do gameRepository no service
    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDTO> findAll() {

        List<Game> result = gameRepository.findAll();
        //converte uma lista de Game em GameMinDTO
        //usa a lib stream que possue o metodo map para converter  de game para um novo GameMinDTO passando game como parametro, tolist faz voltar para o tipo lista
        List<GameMinDTO> dto = result.stream().map(game -> new GameMinDTO(game)).toList();
        return dto;
    }

}
