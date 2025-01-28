package com.estudos.gamelist.repositories;

import com.estudos.gamelist.entities.Game;
import com.estudos.gamelist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

//extende o JPArepository para acessar o banco, é passada o nome da entidade e o tipo do id
public interface GameListRepository extends JpaRepository<GameList, Long> {

}
