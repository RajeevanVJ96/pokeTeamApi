package com.qa.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/*
Pokemonteam model for the pokemonteam table where each attribute of the class will correspond to the field in the SQL table.
The ID for each pokemonteam that will be added is autogenerated so it is not needed inside the constructor.
The model allows for multiple pokemon teams but for the current purposes, only one team will be used.
Each pokemonteam object will have a single field which will be a set of pokemon objects. Hence the one to Many relationship
between this object/table and the pokemon object/table.
 */

@Entity
public class PokeTeam {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long id;

    @OneToMany(fetch = FetchType.EAGER)
    Set<Pokemon> pokemon = new HashSet<Pokemon>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Pokemon> getPokemon() {
        return pokemon;
    }

    public void setPokemon(Set<Pokemon> pokemon) {
        this.pokemon = pokemon;
    }
}
