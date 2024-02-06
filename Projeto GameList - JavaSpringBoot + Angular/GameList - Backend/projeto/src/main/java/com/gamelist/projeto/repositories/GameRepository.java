package com.gamelist.projeto.repositories;

import com.gamelist.projeto.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
