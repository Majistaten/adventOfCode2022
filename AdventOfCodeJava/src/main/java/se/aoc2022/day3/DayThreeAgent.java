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
    public int sumPriorities() {
        int sum = 0;
        List<String> commonItems = findCommonCompartmentItems(this.rucksacks);
        for (String item : commonItems) {
            sum += getPriority(item);
        }
        return sum;
    }

    public int sumGroupPriorities() {
        int sum = 0;
        List<String> commonItems = findCommonGroupItems(this.rucksacks);
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
    private List<String> findCommonCompartmentItems(List<Rucksack> rucksacks) {
        List<String> commonItems = new ArrayList<>();
        for (Rucksack rucksack : rucksacks) {
            commonItems.add(findCommonItemInCompartments(rucksack));
        }
        return commonItems;
    }

    /**
     * Find the common item between the two compartments of a rucksack.
     *
     * @param rucksack rucksack to find common item in
     * @return common item
     */
    private String findCommonItemInCompartments(Rucksack rucksack) {
        for (String item : rucksack.openFirstCompartment().getItems()) {
            if (rucksack.openSecondCompartment().hasItem(item)) {
                return item;
            }
        }
        return null;
    }

    /**
     * Find all group badges.
     *
     * @param rucksacks list of rucksacks
     * @return list of group badges
     */
    private List<String> findCommonGroupItems(List<Rucksack> rucksacks) {
        List<String> groupBadges = new ArrayList<>();
        List<Rucksack> groupRucksacks = new ArrayList<>();
        for (Rucksack rucksack : rucksacks) {
            groupRucksacks.add(rucksack);
            if (groupRucksacks.size() == 3) {
                groupBadges.add(findCommonGroupItem(groupRucksacks));
                groupRucksacks.clear();
            }
        }
        return groupBadges;
    }

    /**
     * Find the common item between the three rucksacks. (group badge)
     *
     * @param rucksacks list of rucksacks
     * @return group badge
     */
    private String findCommonGroupItem(List<Rucksack> rucksacks) {
        for (String letter : rucksacks.get(0).getItems().split("")) {
            if (rucksacks.get(1).hasItem(letter) && rucksacks.get(2).hasItem(letter)) {
                return letter;
            }
        }
        return null;
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

}
