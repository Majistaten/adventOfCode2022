package se.aoc2022.day1;

import java.util.Random;

public class Elf {
    private final String name;
    private final int id;
    private final int calories;

    String[] names = {"Sven", "Albert", "Donny", "Tom", "Thomas", "Frank", "Anton", "Ruben", "Alexander",
            "Rolf", "Doris"};

    public Elf(int id, int calories) {
        Random random = new Random();
        this.name = names[random.nextInt(names.length)];
        this.id = id;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getCalories() {
        return calories;
    }
}
