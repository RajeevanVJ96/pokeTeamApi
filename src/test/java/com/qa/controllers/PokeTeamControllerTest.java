package com.qa.controllers;

import com.qa.models.PokeTeam;
import com.qa.models.Pokemon;
import com.qa.repository.PokeRepository;
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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PokeTeamControllerTest {

    @InjectMocks
    private PokeTeamController pokeTeamController;

    @Mock
    private PokeTeamRepository repository;

    @Mock
    private PokeRepository pokeRepository;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testListAllPokemon(){
        List<PokeTeam> poketeamlist = new ArrayList<>();
        PokeTeam pteam = new PokeTeam();
        poketeamlist.add(pteam);
        pteam.getId();
        pteam.setId(1L);

        when(repository.findAll()).thenReturn(poketeamlist);

        assertEquals(pokeTeamController.listAllPokemon(), poketeamlist );

    }

    @Test
    public void testAddPokemontoTeam(){
        PokeTeam pokeTeam = new PokeTeam();
        Set<Pokemon> testpoke = new HashSet<Pokemon>();
        pokeTeam.setPokemon(testpoke);

        when(repository.saveAndFlush(pokeTeam)).thenReturn(pokeTeam);

        assertEquals(pokeTeamController.addPokemontoTeam(pokeTeam), pokeTeam );

    }


    @Test
    public void testUpdatePokeTeam(){
        PokeTeam pokeTeam = new PokeTeam();
        Pokemon oldpoke = new Pokemon();
        oldpoke.setId(1L);
        Pokemon newpoke = new Pokemon();
        newpoke.setId(2L);
        Set<Pokemon> team = pokeTeam.getPokemon();
        team.remove(oldpoke);
        team.add(newpoke);
        pokeTeam.setPokemon(team);

        when(repository.findOne(1L)).thenReturn(pokeTeam);

        assertEquals(pokeTeamController.updatePokemonTeam(1L, oldpoke.getId(), newpoke.getId()) ,pokeTeam);

    }

}
