package com.qa.controllers;

import com.qa.models.PokeTeam;
import com.qa.repository.PokeTeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin()
public class PokeTeamController {

    @Autowired
    private PokeTeamRepository repository;

    @RequestMapping(value = "pokemonteam", method = RequestMethod.GET)
    public List<PokeTeam> listAllPokemon(){
        return repository.findAll();
    }

    @RequestMapping(value = "pokemonteam", method = RequestMethod.POST)
    public PokeTeam addPokemon(@RequestBody PokeTeam poke){
        return repository.saveAndFlush(poke);
    }

    @RequestMapping(value = "pokemonteam/{id}", method = RequestMethod.GET)
    public PokeTeam getPokemon(@PathVariable Long id){
        return repository.findOne(id);

    }

    @Transactional
    @RequestMapping(value = "pokemonteam/{id}", method = RequestMethod.PUT)
    public void updatePokemon(@PathVariable Long id, @RequestBody PokeTeam poke){
        PokeTeam p = repository.findOne(id);
        p.setPokeTeam(poke);
    }

    @RequestMapping(value = "pokemonteam/{id}", method = RequestMethod.DELETE)
    public void delPokemon(@PathVariable Long id){
        repository.delete(id);
    }



}
