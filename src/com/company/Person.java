package com.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class Person implements Serializable {
    private String name;
    private int age;
    private ArrayList<Pet> pets;

    Person(String name) {
        this.name = name;
        this.age = (int) (Math.random() * 70) + 15;
        this.pets = new ArrayList<>();
    }

    public void addPet(Pet pet) {
        this.pets.add(pet);
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        if (pets.size() < 1) {
            return String.format("%s (%d) got no animal at all", this.name, this.age);
        } else if (this.pets.size() == 1) {
            return String.format("%s (%d) got a %s called %s", this.name, this.age, this.pets.get(0).getSpecies(), this.pets.get(0).getName());
        } else {
            return String.format("%s (%d) got these %d animals: [%s]", this.name, this.age, pets.size(), pets.stream()
                    .collect(groupingBy(Pet::getSpecies))
                    .entrySet()
                    .stream()
                    .map(x -> x.getKey() + "s: " + x.getValue().stream().map(Pet::getName).collect(Collectors.joining(", "))).collect(Collectors.joining(" | ")));
        }
    }
}
