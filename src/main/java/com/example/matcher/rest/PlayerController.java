package com.example.matcher.rest;

import com.example.matcher.dto.PlayerDTO;
import com.example.matcher.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/player")
public class PlayerController {

    private final PlayerService playerService;
    @GetMapping("/get_client_config/{playerId}")
    public PlayerDTO getClientConfig(@PathVariable String playerId) {
        return playerService.getClientConfig(playerId);
    }

    @GetMapping("/{playerId}")
    public PlayerDTO getPlayer(@PathVariable String playerId) {
        return playerService.getPlayerById(playerId);
    }
}
