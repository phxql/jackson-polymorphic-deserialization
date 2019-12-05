package de.mkammerer.jpd;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

// Tell Jackson to include a property called 'type', which determines what concrete class is represented by the JSON
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
// You have to list all sub-types of this class here
@JsonSubTypes({
        // Maps "type": "dog" to the Dog class
        @JsonSubTypes.Type(value = Dog.class, name = "dog"),
        // Maps "type": "cat" to the Dog class
        @JsonSubTypes.Type(value = Cat.class, name = "cat")
})
public abstract class Animal {
    private String name;

    protected Animal() {
    }

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
