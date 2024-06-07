package com.reto.tecnico.service.impl;

import com.reto.tecnico.model.StarWarsCharacter;
import com.reto.tecnico.model.SwapiCharacter;
import com.reto.tecnico.service.interfaces.SwapiService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SwapiServiceImpl  implements SwapiService {

    private static final String SWAPI_URL = "https://swapi.dev/api/people/?search=";

    @Override
    public StarWarsCharacter fetchCharacterFromApi(String characterName) {
        RestTemplate restTemplate = new RestTemplate();
        SwapiResponse response = restTemplate.getForObject(SWAPI_URL + characterName, SwapiResponse.class);

        if (response != null && response.getResults() != null && !response.getResults().isEmpty()) {
            SwapiResponse.SwapiCharacter swapiCharacter = response.getResults().get(0);
            StarWarsCharacter character = new StarWarsCharacter();
            character.setName(swapiCharacter.getName());
            character.setHeight(Integer.parseInt(swapiCharacter.getHeight()));
            character.setMass(Integer.parseInt(swapiCharacter.getMass()));
            character.setHairColor(swapiCharacter.getHairColor());
            character.setSkinColor(swapiCharacter.getSkinColor());
            character.setEyeColor(swapiCharacter.getEyeColor());
            character.setBirthYear(swapiCharacter.getBirthYear());
            character.setGender(swapiCharacter.getGender());
            return character;
        }
        return null;
    }
}
