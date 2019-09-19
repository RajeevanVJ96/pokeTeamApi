package com.qa.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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
