package com.qa.controllers;

import com.qa.models.PokeTeam;
import com.qa.models.Pokemon;
import com.qa.repository.PokeTeamRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PokeTeamControllerTest {

    @InjectMocks
    private PokeTeamController pokeTeamController;

    @Mock
    private PokeTeamRepository repository;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testListAllPokemon(){
        List<PokeTeam> poketeamlist = new ArrayList<>();
        PokeTeam pteam = new PokeTeam();
        pteam.setName("The team");
        poketeamlist.add(pteam);

        when(repository.findAll()).thenReturn(poketeamlist);

        assertEquals(pokeTeamController.listAllPokemon().get(0).getName(), "The team");

    }

    @Test
    public void testAddPokemontoTeam(){

    }



}
