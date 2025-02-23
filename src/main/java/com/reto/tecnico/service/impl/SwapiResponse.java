package com.reto.tecnico.service.impl;

import com.reto.tecnico.model.SwapiCharacter;
import lombok.*;

import java.util.List;

@Data
@Setter
@Getter
public class SwapiResponse {

    private List<SwapiCharacter> results;

    // Getters and setters
    public List<SwapiCharacter> getResults() {
        return results;
    }

    public void setResults(List<SwapiCharacter> results) {
        this.results = results;
    }

    public static class SwapiCharacter {
        private String name;
        private String height;
        private String mass;
        private String hairColor;
        private String skinColor;
        private String eyeColor;
        private String birthYear;
        private String gender;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getHeight() {
            return height;
        }

        public void setHeight(String height) {
            this.height = height;
        }

        public String getMass() {
            return mass;
        }

        public void setMass(String mass) {
            this.mass = mass;
        }

        public String getHairColor() {
            return hairColor;
        }

        public void setHairColor(String hairColor) {
            this.hairColor = hairColor;
        }

        public String getSkinColor() {
            return skinColor;
        }

        public void setSkinColor(String skinColor) {
            this.skinColor = skinColor;
        }

        public String getEyeColor() {
            return eyeColor;
        }

        public void setEyeColor(String eyeColor) {
            this.eyeColor = eyeColor;
        }

        public String getBirthYear() {
            return birthYear;
        }

        public void setBirthYear(String birthYear) {
            this.birthYear = birthYear;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }
    }





}
