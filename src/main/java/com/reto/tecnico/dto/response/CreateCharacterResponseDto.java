package com.reto.tecnico.dto.response;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCharacterResponseDto {

    private Long id;
    private String name;
    private Integer height;
    private Integer mass;
    private String hairColor;
    private String skinColor;
    private String eyeColor;
    private String birthYear;
    private String gender;
    private String message;


    public CreateCharacterResponseDto(String message) {
        this.message = message;
    }

}
