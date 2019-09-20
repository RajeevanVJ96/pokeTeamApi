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

/*
This controller class is used to serve the external calls to the api based on the URL mapping as shown in the RequestMapping().
Each method has its own method based on the type of request ie POST, GET, DELETE.
The methods applied to the PokeTeamRepository object are all built in methods of the JPA repository which is extended by the PokeRepo interface.
There is also a pokeRepository as it is required in the update method to get the old and new pokemon.
So to make calls to the API, one should use http://{ip address the api is being hosted on or localhost}:{port number}/RequestMappingvalue
These api calls were tested on Postman as well prior to website calls.
 */
public class PokeTeamController {

    @Autowired
    private PokeRepository pokeRepository;

    @Autowired
    private PokeTeamRepository pokeTeamRepository;

    /*
    The entire list of pokemon teams is returned albeit only one.
     */

    @RequestMapping(value = "pokemonteam", method = RequestMethod.GET)
    public List<PokeTeam> listAllPokemon(){
        return pokeTeamRepository.findAll();
    }

    /*
    The pokemonteam object received is added to the table.
     */

    @RequestMapping(value = "pokemonteam", method = RequestMethod.POST)
    public PokeTeam addPokemontoTeam(@RequestBody PokeTeam pteam){
        return  pokeTeamRepository.saveAndFlush(pteam);
    }

    /*
    The pokemonteam object that is requested is edited whereby the old pokemon object inside is replace with the new pokemon object both referenced by their ids.
     */

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
