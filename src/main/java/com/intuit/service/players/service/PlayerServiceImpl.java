package com.intuit.service.players.service;

import com.intuit.service.players.errors.PlayerNotFoundException;
import com.intuit.service.players.model.Player;
import com.intuit.service.players.repository.PlayerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    @Override
    public Player getPlayerById(String playerId) {
        Optional<Player> byPlayerId = playerRepository.findByPlayerID(playerId);
        if (byPlayerId.isPresent()) {
            log.debug("Player with playerId= {} is exist!", playerId);
            return byPlayerId.get();
        } else {
            log.info("Player with playerId= {} is not exist!", playerId);
            throw new PlayerNotFoundException("Player with playerId= " + playerId + " is not exist");
        }
    }
}
