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
        for(Person person : ppl){
            Serializer.write(Paths.get(person.getName()),person);
            System.out.println("Serializing: " + person.toString());
        }

        for (Person person : ppl){
            ppl2.add((Person) Serializer.read(Paths.get(person.getName())));
            System.out.println("DeSerializing: " + person.toString());
        }
    }

    void addPplToList(List<Person> ppl){
        Person p = new Person("Jason");
        p.addPet(new Pet("Buddy"));
        p.addPet(new Pet("Spot"));
        ppl.add(p);
        Person p2 = new Person("Perry");
        p2.addPet(new Pet("Pea"));
        p2.addPet(new Pet("Peat"));
        ppl.add(p2);
    }

    public static App getInstance() {
        return instance;
    }
}
