package com.qa.controllers;

import com.qa.models.Pokemon;
import com.qa.repository.PokeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin()
public class PokeController {

    @Autowired
    private PokeRepository repository;

    @RequestMapping(value = "pokemons", method = RequestMethod.GET)
    public List<Pokemon> listAllPokemon(){
        return repository.findAll();
    }

    @RequestMapping(value = "pokemons", method = RequestMethod.POST)
    public Pokemon addPokemon(@RequestBody Pokemon poke){
        return repository.saveAndFlush(poke);
    }

    @RequestMapping(value = "pokemons/{id}", method = RequestMethod.GET)
    public Pokemon getPokemon(@PathVariable Long id){
        return repository.findOne(id);

    }

    @RequestMapping(value = "pokemons/{id}", method = RequestMethod.DELETE)
    public void delPokemon(@PathVariable Long id){
        repository.delete(id);
    }


}
