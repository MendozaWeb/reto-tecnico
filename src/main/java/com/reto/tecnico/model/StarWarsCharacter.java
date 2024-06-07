package com.reto.tecnico.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "StarWarsCharacter")
@Getter
@Setter
public class StarWarsCharacter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "height")
    private Integer height;

    @Column(name = "mass")
    private Integer mass;

    @Column(name = "hair_color")
    private String hairColor;

    @Column(name = "skin_color")
    private String skinColor;

    @Column(name = "eye_color")
    private String eyeColor;

    @Column(name = "birth_year")
    private String birthYear;

    @Column(name = "gender")
    private String gender;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
