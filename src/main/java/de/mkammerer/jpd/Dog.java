package de.mkammerer.jpd;

import java.util.StringJoiner;

public class Dog extends Animal {
    private boolean canBark;

    protected Dog() {
    }

    public Dog(String name, boolean canBark) {
        super(name);
        this.canBark = canBark;
    }

    public boolean isCanBark() {
        return canBark;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Dog.class.getSimpleName() + "[", "]")
                .add("canBark=" + canBark)
                .toString();
    }
}
