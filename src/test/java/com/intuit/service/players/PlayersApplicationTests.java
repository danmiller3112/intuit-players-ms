package com.intuit.service.players;

import com.intuit.service.players.repository.PlayerRepository;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.hasSize;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class PlayersApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PlayerRepository playerRepository;

    @Test
    public void testGetAllPlayers() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/players"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(4)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].playerID", Matchers.is("aaaaaa")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].birthYear", Matchers.is("1977")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id", Matchers.is(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].playerID", Matchers.is("bbbbbb")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].birthYear", Matchers.is("1883")));
    }

    @Test
    public void testGetPlayerById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/players/{playerId}", "aaaaaa"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.playerID", Matchers.is("aaaaaa")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.birthYear", Matchers.is("1977")));
    }

    @Test
    public void testGetPlayerById_NotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/players/{playerId}", "3"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

//    @Test
//    public void testGetPlayerById_InvalidId() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/players/{playerId}", "invalid"))
//                .andExpect(MockMvcResultMatchers.status().isBadRequest());
//    }

}
