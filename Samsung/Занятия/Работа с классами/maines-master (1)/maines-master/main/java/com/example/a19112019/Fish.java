package com.example.a19112019;

public class Fish extends Animal {
    int swimDepth = -1;
    //static int countId = 0;

    public Fish(String name, int age, Boolean live, int swimDepth) {
        super(name, age, live);
        this.swimDepth = swimDepth;
        countId++;
    }


    @Override
    public String Move() {
        return super.Move() + " Swimming";
    }

    @Override
    public String toString() {
        return countId+" Fish " + getName() +
                ", age=" + getAge() +
                ", live=" + getLive();
    }

    @Override
    public String PrintAnimal() {
        return getName() + " " + getAge();
    }
}
