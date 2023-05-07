package com.intuit.service.players.config;

import com.intuit.service.players.dto.CsvPlayer;
import com.intuit.service.players.model.Player;
import com.intuit.service.players.repository.PlayerRepository;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CsvDataLoader implements ApplicationRunner {

    @Autowired
    private PlayerRepository playerRepository;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        ClassPathResource resource = new ClassPathResource("player.csv");
        try (Reader reader = new InputStreamReader(resource.getInputStream())) {
            CsvToBean<CsvPlayer> csvToBean = new CsvToBeanBuilder<CsvPlayer>(reader)
                    .withType(CsvPlayer.class)
                    .withSeparator(',')
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            List<CsvPlayer> csvPlayers = csvToBean.parse();

            List<Player> players = csvPlayers.stream()
                    .map(CsvPlayerMapper::map)
                    .collect(Collectors.toList());

            playerRepository.saveAll(players);
        }

    }
}
