package com.intuit.service.players.service;

import com.intuit.service.players.model.Player;

import java.util.List;

public interface PlayerService {
    List<Player> getAllPlayers();

    Player getPlayerById(String playerId);
}
