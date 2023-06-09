package com.intuit.service.players.controller;

import com.intuit.service.players.model.Player;
import com.intuit.service.players.service.PlayerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/players")
public class PlayerController {
    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    //Pagination is considered a best practice for the getAllPlayers() method
    // when dealing with a large dataset.
    @GetMapping
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping("{playerId}")
    public Player getPlayerById(@PathVariable String playerId) {
        return playerService.getPlayerById(playerId);
    }
}
