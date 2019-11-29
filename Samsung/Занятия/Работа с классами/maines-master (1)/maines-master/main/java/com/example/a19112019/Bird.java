package com.example.a19112019;

public class Bird extends Animal {
    private int flyHeight = 1;

    public Bird(String name, int age, Boolean live, int flyHeight) {
        super(name, age, live);
        this.flyHeight = flyHeight;
        countId++;

    }

    public int getFlyHeight() {
        return flyHeight;
    }

    public void setFlyHeight(int flyHeight) {
        this.flyHeight = flyHeight;
    }

    @Override
    public String toString() {
        return countId + " Bird " + getName() +
                ", age=" + getAge() +
                ", live=" + getLive();
    }

    @Override
    public String PrintAnimal() {
        return getName() + " " + getAge();
    }

    @Override
    public String Move() {
        return super.Move() + " Flying";
    }
}
