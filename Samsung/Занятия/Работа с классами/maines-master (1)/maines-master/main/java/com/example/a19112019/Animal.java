package com.example.a19112019;

public abstract class Animal {
    private String name;
    private int age;
    static int countId = 0;

    private Boolean live = true;

    public Animal(String name, int age, Boolean live) {
        this.name = name;

        if (age > 0 && age < 100)
            this.age = age;

        this.live = live;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", live=" + live +
                '}';
    }

    public abstract String PrintAnimal();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0 && age < 100)
            this.age = age;

    }

    public Boolean getLive() {
        return live;
    }

    public void setLive(Boolean live) {
        this.live = live;
    }

    public String Move() {
        return "*Moving*";
    }

}
