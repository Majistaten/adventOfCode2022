package se.aoc2022.day1;

import java.util.ArrayList;
import java.util.List;

public class DayOneAgent {
    public String mostCalories(List<String> input) {

        Elf mostCalories = getElves(input).get(0);
        return "Elf: %s with the ID %d has the most calories with %d calories!"
                .formatted(
                        mostCalories.getName(),
                        mostCalories.getId(),
                        mostCalories.getCalories());
    }

    public String topThreeCalories(List<String> input) {
        List<Elf> elves = getElves(input);
        Elf first = elves.get(0);
        Elf second = elves.get(1);
        Elf third = elves.get(2);
        return "The top three elves are: %s, %s and %s with %d, %d and %d calories respectively with a total of %d."
                .formatted(
                        first.getName(),
                        second.getName(),
                        third.getName(),
                        first.getCalories(),
                        second.getCalories(),
                        third.getCalories(),
                        first.getCalories() + second.getCalories() + third.getCalories());
    }

    public List<Elf> getElves(List<String> input) {
        List<Elf> elves = new ArrayList<>();

        int elfNumber = 1;
        int calories = 0;
        for (String line : input) {
            if (line.equals("\n") || line.isBlank()) {
                elves.add(new Elf(elfNumber, calories));
                elfNumber++;
                calories = 0;
            } else {
                calories += Integer.parseInt(line);
            }
        }
        elves.sort((o1, o2) -> o2.getCalories() - o1.getCalories());
        return elves;
    }
}
