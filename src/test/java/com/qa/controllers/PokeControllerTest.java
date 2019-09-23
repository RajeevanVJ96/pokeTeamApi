package com.qa.controllers;

import com.qa.models.Pokemon;
import com.qa.repository.PokeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

/*
This controller test and the team controller test are both similar in that they both runs mockito tests which are fake as doing
these tests on the actual api database would lead to the data being messed up. Each method is essentially emulating a api call
and asserting Equals what should be returned.
 */
public class PokeControllerTest {

    @InjectMocks
    private PokeController pokeController;

    @Mock
    private PokeRepository repository;

    @Test
    public void testListAllPokemon(){
        List<Pokemon> pokelist = new ArrayList<>();
        Pokemon poke = new Pokemon();
        Pokemon poke2 = new Pokemon("Charizard",6,"Fire Blast", "Dragon Pulse", "Superpower", "Earth Power");
        poke.setName("Bulbasaur");
        poke.setPid(1);
        poke.setM1("Razor Leaf");
        poke.setM2("Sleep Powder");
        poke.setM3("Leech Seed");
        poke.setM4("Slam");
        poke.getPid();
        poke.getM1();
        poke.getM2();
        poke.getM3();
        poke.getM4();
        pokelist.add(poke);
        pokelist.add(poke2);


        when(repository.findAll()).thenReturn(pokelist);

        assertEquals(pokeController.listAllPokemon().get(0).getName(), "Bulbasaur");
        assertEquals(pokeController.listAllPokemon().get(0).getPid(), 1);
        assertEquals(pokeController.listAllPokemon().get(0).getM1(), "Razor Leaf");
        assertEquals(pokeController.listAllPokemon().get(0).getM2(), "Sleep Powder");
        assertEquals(pokeController.listAllPokemon().get(0).getM3(), "Leech Seed");
        assertEquals(pokeController.listAllPokemon().get(0).getM4(), "Slam");


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
