package com.qa.repository;

import com.qa.models.PokeTeam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokeTeamRepository extends JpaRepository<PokeTeam, Long> {
}
