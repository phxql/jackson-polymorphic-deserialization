package de.mkammerer.jpd;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.List;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

        Cat cat = new Cat("Ms. Cat", true);
        Dog dog = new Dog("Mr. Dog", true);

        // Serialize and print JSON
        String catJson = mapper.writeValueAsString(cat);
        String dogJson = mapper.writeValueAsString(dog);

        System.out.println("Cat:");
        System.out.println(catJson);
        System.out.println();

        System.out.println("Dog:");
        System.out.println(dogJson);
        System.out.println();

        // Deserialize and print class name / content
        Animal cat2 = mapper.readValue(catJson, Animal.class);
        Animal dog2 = mapper.readValue(dogJson, Animal.class);

        System.out.println("Cat:");
        System.out.println(cat2.getClass() + " | " + cat2.toString());
        System.out.println();

        System.out.println("Dog class:");
        System.out.println(dog2.getClass() + " | " + dog2.toString());
        System.out.println();

        // Try with a collection
        Animals animals = new Animals(List.of(cat, dog));

        // Serialize and print JSON
        String animalsJson = mapper.writeValueAsString(animals);
        System.out.println("Animals:");
        System.out.println(animalsJson);
        System.out.println();

        // Deserialize and print class name / content
        Animals animals2 = mapper.readValue(animalsJson, Animals.class);

        System.out.println("Animals class:");
        for (Animal animal2 : animals2.getAnimals()) {
            System.out.println(animal2.getClass() + " | " + animal2.toString());
        }
    }
}
