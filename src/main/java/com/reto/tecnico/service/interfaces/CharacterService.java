package com.reto.tecnico.service.interfaces;

import com.reto.tecnico.dto.request.CreateCharacterRequestDto;
import com.reto.tecnico.dto.response.CreateCharacterResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CharacterService {

    ResponseEntity<CreateCharacterResponseDto> createCharacter(CreateCharacterRequestDto request);
    ResponseEntity<List<CreateCharacterResponseDto>> listAllCharacters();

}
