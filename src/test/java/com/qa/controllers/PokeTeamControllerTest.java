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
        poketeamlist.add(pteam);

        when(repository.findAll()).thenReturn(poketeamlist);

        assertEquals(pokeTeamController.listAllPokemon(), pteam );

    }

    @Test
    public void testAddPokemontoTeam(){
        PokeTeam pokeTeam = new PokeTeam();
        Pokemon poke = new Pokemon("Bulbasaur", 1, "Leech Seed",
                "Sleep Powder" , "Razor Leaf" , "Solar Beam" );
        pokeTeam.setPid(poke.getPid());

        when(repository.saveAndFlush(pokeTeam)).thenReturn(pokeTeam);

        assertEquals(pokeTeamController.addPokemontoTeam(2), 1 );

    }


//    @Test
//    public void testUpdatePokeTeam(){
//        PokeTeam pokeTeam = new PokeTeam();
//        pokeTeam.setId(1L);
//        Pokemon poke = new Pokemon("Bulbasaur", 1, "Leech Seed",
//                "Sleep Powder" , "Razor Leaf" , "Solar Beam" );
//        pokeTeam.setPid1(poke.getPid());
//
//        when(repository.findOne(1L)).thenReturn(pokeTeam);
//
//        assertEquals(pokeTeamController.updatePokemon(1L, pokeTeam), pokeTeam);
//
//    }

//    @Test
//    public void testdelPokemonfromTeam(){
//        PokeTeam pokeTeam = new PokeTeam();
//        pokeTeam.setId(1L);
//        Pokemon poke = new Pokemon("Bulbasaur", 1, "Leech Seed",
//                "Sleep Powder" , "Razor Leaf" , "Solar Beam" );
//        pokeTeam.setPid1(poke.getPid());
//
//        when(repository.findOne(1L)).thenReturn(pokeTeam);
//        repository.delete(pokeTeam);
//
//        assertEquals(pokeTeamController.delPokemon(1L), pokeTeam);
//
//    }



}
