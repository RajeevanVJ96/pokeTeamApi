package com.qa.repository;

import com.qa.models.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokeRepository extends JpaRepository<Pokemon, Long> {

}
