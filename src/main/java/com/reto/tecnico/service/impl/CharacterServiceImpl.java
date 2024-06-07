package com.reto.tecnico.service.impl;

import com.reto.tecnico.dto.request.CreateCharacterRequestDto;
import com.reto.tecnico.dto.response.CreateCharacterResponseDto;
import com.reto.tecnico.model.StarWarsCharacter;
import com.reto.tecnico.repository.CharacterRepository;
import com.reto.tecnico.service.interfaces.CharacterService;
import com.reto.tecnico.service.interfaces.SwapiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CharacterServiceImpl implements CharacterService {

    @Autowired
    private CharacterRepository characterRepository;

    @Autowired
    private  final  SwapiService swapiService;

    @Autowired
    public CharacterServiceImpl(SwapiService swapiService) {
        this.swapiService = swapiService;
    }

    @Override
    public ResponseEntity<CreateCharacterResponseDto> createCharacter(CreateCharacterRequestDto request) {
        try {
            StarWarsCharacter character = swapiService.fetchCharacterFromApi(request.getName());
            if (character == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new CreateCharacterResponseDto("Character not found in external API"));
            }
            characterRepository.save(character);

            CreateCharacterResponseDto responseDto = new CreateCharacterResponseDto(
                    character.getId(),
                    character.getName(),
                    character.getHeight(),
                    character.getMass(),
                    character.getHairColor(),
                    character.getSkinColor(),
                    character.getEyeColor(),
                    character.getBirthYear(),
                    character.getGender(),
                    "Character created successfully!"
            );
            return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new CreateCharacterResponseDto("Bad request: " + e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CreateCharacterResponseDto("Internal server error: " + e.getMessage()));
        }
    }

    @Override
    public ResponseEntity<List<CreateCharacterResponseDto>> listAllCharacters() {
        try {
            List<StarWarsCharacter> characters = characterRepository.findAll();
            List<CreateCharacterResponseDto> responseDtos = characters.stream()
                    .map(character -> new CreateCharacterResponseDto(
                            character.getId(),
                            character.getName(),
                            character.getHeight(),
                            character.getMass(),
                            character.getHairColor(),
                            character.getSkinColor(),
                            character.getEyeColor(),
                            character.getBirthYear(),
                            character.getGender(),
                            "Character retrieved successfully!"
                    ))
                    .collect(Collectors.toList());
            return ResponseEntity.ok(responseDtos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(List.of(new CreateCharacterResponseDto("Internal server error: " + e.getMessage())));
        }
    }
}
