package com.qa.controllers;

import com.qa.models.Pokemon;
import com.qa.repository.PokeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PokeControllerTest {

    @InjectMocks
    private PokeController pokeController;

    @Mock
    private PokeRepository repository;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testListAllPokemon(){
        List<Pokemon> pokelist = new ArrayList<>();
        Pokemon poke = new Pokemon();
        poke.setName("Bulbasaur");
        poke.setPid(1);
        poke.setM1("Razor Leaf");
        poke.setM2("Sleep Powder");
        poke.setM3("Leech Seed");
        poke.setM4("Slam");
        pokelist.add(poke);

        when(repository.findAll()).thenReturn(pokelist);

        assertEquals(pokeController.listAllPokemon().get(0).getName(), "Bulbasaur");

    }

    @Test
    public void testGetPokemon(){

        Pokemon poke = new Pokemon();
        poke.setId(1l);
        poke.setName("Bulbasaur");
        poke.setPid(1);
        poke.setM1("Razor Leaf");
        poke.setM2("Sleep Powder");
        poke.setM3("Leech Seed");
        poke.setM4("Slam");

        when(repository.findOne(1L)).thenReturn(poke);

        assertEquals(pokeController.getPokemon(1L).getName(), "Bulbasaur");
    }

    @Test
    public void testAddPokemon(){

        Pokemon poke = new Pokemon();
        poke.setId(1L);
        poke.setName("Bulbasaur");
        poke.setPid(1);
        poke.setM1("Razor Leaf");
        poke.setM2("Sleep Powder");
        poke.setM3("Leech Seed");
        poke.setM4("Slam");

        when(repository.saveAndFlush(poke)).thenReturn(poke);

        assertEquals(pokeController.addPokemon(poke).getName(), "Bulbasaur");
    }

    @Test
    public void testDeletePokemon(){

        Pokemon poke = new Pokemon();
        poke.setId(1L);
        poke.setName("Bulbasaur");
        poke.setPid(1);
        poke.setM1("Razor Leaf");
        poke.setM2("Sleep Powder");
        poke.setM3("Leech Seed");
        poke.setM4("Slam");

        when(repository.findOne(1L)).thenReturn(poke);
        repository.delete(1L);
        assertEquals(pokeController.delPokemon(1L).getName(), "Bulbasaur");

    }

    @Test
    public void testUpdatePokemon(){

        Pokemon poke = new Pokemon();
        poke.setId(1L);
        poke.setName("Bulbasaur");
        poke.setPid(1);
        poke.setM1("Razor Leaf");
        poke.setM2("Sleep Powder");
        poke.setM3("Leech Seed");
        poke.setM4("Slam");

        when(repository.findOne(1L)).thenReturn(poke);

        assertEquals(pokeController.updatePokemon(1L, poke).getName(), "Bulbasaur");
    }

}
