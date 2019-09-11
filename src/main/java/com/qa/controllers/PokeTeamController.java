package com.qa.controllers;

import com.qa.models.PokeTeam;
import com.qa.models.Pokemon;
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
    public PokeTeam addPokemontoTeam(@RequestBody PokeTeam pteam){
        return  repository.saveAndFlush(pteam);

    }

    @RequestMapping(value = "pokemonteam/{id}", method = RequestMethod.DELETE)
    public void delPokemon(@PathVariable Long id){
        repository.delete(id);
    }



}
