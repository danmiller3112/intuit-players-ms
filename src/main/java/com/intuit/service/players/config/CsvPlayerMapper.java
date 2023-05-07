package com.intuit.service.players.config;

import com.intuit.service.players.dto.CsvPlayer;
import com.intuit.service.players.model.Player;
import org.springframework.beans.BeanUtils;

public class CsvPlayerMapper {
    public static Player map(CsvPlayer csvPlayer) {
        Player player = new Player();
        BeanUtils.copyProperties(csvPlayer, player);
        return player;
    }
}
