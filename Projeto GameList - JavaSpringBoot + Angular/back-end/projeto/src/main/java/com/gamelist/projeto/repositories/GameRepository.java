package com.gamelist.projeto.repositories;

import com.gamelist.projeto.entities.GameEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<GameEntity, Long> {


}
