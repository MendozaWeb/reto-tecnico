package com.reto.tecnico.repository;

import com.reto.tecnico.model.StarWarsCharacter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepository extends JpaRepository<StarWarsCharacter, Long> {
}
