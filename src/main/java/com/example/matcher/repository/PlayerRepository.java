package com.example.matcher.repository;

import com.example.matcher.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, String> {

    Player findByPlayerId(String playerId);
}
