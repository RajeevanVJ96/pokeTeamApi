package com.qa.controllers;

import com.qa.models.Pokemon;
import com.qa.repository.PokeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin()

/*
This controller class is used to serve the external calls to the api based on the URL mapping as shown in the RequestMapping().
Each method has its own method based on the type of request ie POST, GET, DELETE.
The methods applied to the PokeRepository object are all built in methods of the JPA repository which is extended by the PokeRepo interface.
So to make calls to the API, one should use http://{ip address the api is being hosted on or localhost}:{port number}/RequestMappingvalue
These api calls were tested on Postman as well prior to website calls.
 */
public class PokeController {

    @Autowired
    private PokeRepository repository;

    /*
    The entire pokemon table is returned.
     */

    @RequestMapping(value = "pokemon", method = RequestMethod.GET)
    public List<Pokemon> listAllPokemon(){
        return repository.findAll();
    }

    /*
    The pokemon received with the requestBody is added to the pokemon table
     */

    @RequestMapping(value = "pokemon", method = RequestMethod.POST)
    public Pokemon addPokemon(@RequestBody Pokemon poke){
        return repository.saveAndFlush(poke);
    }

    /*
    The id attached is sent back as the response
     */

    @RequestMapping(value = "pokemon/{id}", method = RequestMethod.GET)
    public Pokemon getPokemon(@PathVariable Long id){
        return repository.findOne(id);
    }

    /*
    The id attached is updated with new pokeobject received with the body of the request.
     */

    @Transactional
    @RequestMapping(value = "pokemon/{id}", method = RequestMethod.PUT)
    public Pokemon updatePokemon(@PathVariable Long id, @RequestBody Pokemon poke){
        Pokemon p = repository.findOne(id);
        p.setPokemon(poke);
        return p;
    }

    /*
    The id attached is deleted
     */

    @RequestMapping(value = "pokemon/{id}", method = RequestMethod.DELETE)
    public Pokemon delPokemon(@PathVariable Long id){
        Pokemon existing = repository.findOne(id);
        repository.delete(id);
        return existing;
    }


}
