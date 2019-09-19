package com.qa.controllers;

import com.qa.models.PokeTeam;
import com.qa.models.Pokemon;
import com.qa.repository.PokeRepository;
import com.qa.repository.PokeTeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin()
public class PokeTeamController {

    @Autowired
    private PokeRepository pokeRepository;

    @Autowired
    private PokeTeamRepository pokeTeamRepository;

    @RequestMapping(value = "pokemonteam", method = RequestMethod.GET)
    public List<PokeTeam> listAllPokemon(){
        return pokeTeamRepository.findAll();
    }

    @RequestMapping(value = "pokemonteam", method = RequestMethod.POST)
    public PokeTeam addPokemontoTeam(@RequestBody PokeTeam pteam){
        return  pokeTeamRepository.saveAndFlush(pteam);
    }

    @RequestMapping(value = "pokemonteam/{pokemonTeamId}/{oldPokemonId}/{newPokemonId}", method = RequestMethod.PUT)
    public PokeTeam updatePokemonTeam(@PathVariable Long pokemonTeamId, @PathVariable Long oldPokemonId, @PathVariable Long newPokemonId) {
        PokeTeam returned = pokeTeamRepository.findOne(pokemonTeamId);

        Pokemon oldPokemon = pokeRepository.findOne(oldPokemonId);
        Pokemon newPokemon = pokeRepository.findOne(newPokemonId);

        Set<Pokemon> team = returned.getPokemon();
        team.remove(oldPokemon);
        team.add(newPokemon);
        returned.setPokemon(team);
        pokeTeamRepository.flush();
        return returned;
    }

}
