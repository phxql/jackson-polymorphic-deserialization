package de.mkammerer.jpd;

import java.util.StringJoiner;

public class Cat extends Animal {
    private boolean canMeow;

    protected Cat() {
    }

    public Cat(String name, boolean canMeow) {
        super(name);
        this.canMeow = canMeow;
    }

    public boolean isCanMeow() {
        return canMeow;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Cat.class.getSimpleName() + "[", "]")
                .add("canMeow=" + canMeow)
                .toString();
    }
}
