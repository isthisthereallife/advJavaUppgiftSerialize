package com.company;

import java.io.Serializable;

public class Pet implements Serializable {
    private String name;
    private String species;

    Pet(String name) {
        this.name = name;
        this.species = ((int) (Math.random() * 4) + 1) % 2 == 0 ? "Cat" : "Dog";
    }

    public String getName() {
        return this.name;
    }

    public String getSpecies() {
        return this.species;
    }

}
