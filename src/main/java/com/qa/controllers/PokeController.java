package com.qa.controllers;

import com.qa.models.Pokemon;
import com.qa.repository.PokeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin()
public class PokeController {

    @Autowired
    private PokeRepository repository;

    @RequestMapping(value = "pokemon", method = RequestMethod.GET)
    public List<Pokemon> listAllPokemon(){
        return repository.findAll();
    }

    @RequestMapping(value = "pokemon", method = RequestMethod.POST)
    public Pokemon addPokemon(@RequestBody Pokemon poke){
        return repository.saveAndFlush(poke);
    }

    @RequestMapping(value = "pokemon/{id}", method = RequestMethod.GET)
    public Pokemon getPokemon(@PathVariable Long id){
        return repository.findOne(id);
    }

    @Transactional
    @RequestMapping(value = "pokemon/{id}", method = RequestMethod.PUT)
    public Pokemon updatePokemon(@PathVariable Long id, @RequestBody Pokemon poke){
        Pokemon p = repository.findOne(id);
        p.setPokemon(poke);
        return p;
    }

    @RequestMapping(value = "pokemon/{id}", method = RequestMethod.DELETE)
    public Pokemon delPokemon(@PathVariable Long id){
        Pokemon existing = repository.findOne(id);
        repository.delete(id);
        return existing;
    }


}
