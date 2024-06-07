package com.reto.tecnico.service.interfaces;

import com.reto.tecnico.model.StarWarsCharacter;
import org.springframework.stereotype.Service;

@Service
public interface SwapiService {
    StarWarsCharacter fetchCharacterFromApi(String characterName);
}
