package de.mkammerer.jpd;

import java.util.List;

public class Animals {
    private List<Animal> animals;

    protected Animals() {
    }

    public Animals(List<Animal> animals) {
        this.animals = animals;
    }

    public List<Animal> getAnimals() {
        return animals;
    }
}
