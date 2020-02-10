package com.company;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class App {
    private static App instance = new App();

    private App() {
        List<Person> ppl = new ArrayList<>();
        List<Person> ppl2 = new ArrayList<>();
        addPplToList(ppl);
        ppl.stream().forEach(p -> Serializer.write(Paths.get(p.getName()), p));
        ppl.stream().forEach(p-> ppl2.add((Person) Serializer.read(Paths.get(p.getName()))));
        ppl2.stream().forEach(p-> System.out.println("Deserialized: " + p.toString()));
    }

    void addPplToList(List<Person> ppl) {
        Person p = new Person("Jason");
        p.addPet(new Pet("Buddy"));
        p.addPet(new Pet("Spot"));
        ppl.add(p);
        Person p2 = new Person("Perry");
        p2.addPet(new Pet("Pea"));
        p2.addPet(new Pet("Peat"));
        ppl.add(p2);
        ppl.add(new Person("Steffe"));
    }

    public static App getInstance() {
        return instance;
    }
}
