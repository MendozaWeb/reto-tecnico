package com.reto.tecnico.controller;

import com.reto.tecnico.dto.request.CreateCharacterRequestDto;
import com.reto.tecnico.dto.response.CreateCharacterResponseDto;
import com.reto.tecnico.service.interfaces.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/characters")
public class CharacterController {


    @Autowired
    private CharacterService characterService;

    @PostMapping("/create")
    public ResponseEntity<CreateCharacterResponseDto> createCharacter(@RequestBody CreateCharacterRequestDto request) {
        return characterService.createCharacter(request);
    }

    @GetMapping("/list")
    public ResponseEntity<List<CreateCharacterResponseDto>> listAllCharacters() {
        return characterService.listAllCharacters();
    }

}
