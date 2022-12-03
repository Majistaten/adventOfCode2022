package se.aoc2022.day3;

import java.util.ArrayList;
import java.util.List;

public class DayThreeAgent {

    List<Rucksack> rucksacks = new ArrayList<>();

    public DayThreeAgent(final List<String> items) {
        gatherRucksacks(items);
    }

    /**
     * Gather all packed rucksacks. (initialize and pack)
     *
     * @param items puzzle input
     */
    private void gatherRucksacks(List<String> items) {
        for (String line : items) {
            Rucksack rucksack = new Rucksack();
            rucksack.packCompartments(line);
            rucksacks.add(rucksack);
        }
    }

    /**
     * Calculate the sum of all priorities in the rucksacks.
     *
     * @return sum of all priorities
     */
    public int sumPrioroties() {
        int sum = 0;
        List<String> commonItems = findCommonItems(this.rucksacks);
        for (String item : commonItems) {
            sum += getPriority(item);
        }
        return sum;
    }

    /**
     * Find all items that are common between the two compartments of each rucksack.
     *
     * @param rucksacks list of rucksacks
     * @return list of common items
     */
    private List<String> findCommonItems(List<Rucksack> rucksacks) {
        List<String> commonItems = new ArrayList<>();
        for (Rucksack rucksack : rucksacks) {
            commonItems.add(findCommonItem(rucksack));
        }
        return commonItems;
    }

    /**
     * Get the priority of an item.
     *
     * @param item item to get priority of
     * @return priority of the item
     */
    private int getPriority(String item) {
        int priority;
        if (item.charAt(0) >= 97 && item.charAt(0) <= 122) {
            priority = item.charAt(0) - 96;
        } else {
            priority = item.charAt(0) - 38;
        }
        return priority;
    }

    /**
     * Find the common item between the two compartments of a rucksack.
     *
     * @param rucksack rucksack to find common item in
     * @return common item
     */
    private String findCommonItem(Rucksack rucksack) {
        for (String item : rucksack.openFirstCompartment().getItems()) {
            if (rucksack.openSecondCompartment().contains(item)) {
                return item;
            }
        }
        return null;
    }

}
