package se.aoc2022.day3;

import java.util.Arrays;
import java.util.List;

/**
 * Rucksack with two compartments that can be packed with items.
 * Each item is a letter between a-z and A-Z.
 */
public class Rucksack {
    Compartment firstCompartment = new Compartment();
    Compartment secondCompartment = new Compartment();

    /**
     * Pack the compartments of the rucksack.
     *
     * @param items line from puzzle input
     */
    public void packCompartments(String items) {
        final int mid = items.length() / 2;
        String[] splitStrings = {items.substring(0, mid), items.substring(mid)};
        firstCompartment.pack(Arrays.asList(splitStrings[0].split("")));
        secondCompartment.pack(Arrays.asList(splitStrings[1].split("")));
    }

    /**
     * Open the first compartment of the rucksack.
     *
     * @return first compartment
     */
    public Compartment openFirstCompartment() {
        return firstCompartment;
    }

    /**
     * Open the second compartment of the rucksack.
     *
     * @return second compartment
     */
    public Compartment openSecondCompartment() {
        return secondCompartment;
    }

    /**
     * Get all items stored in the compartments of the rucksack.
     *
     * @return list of items contained in the rucksack
     */
    public String getItems() {
        return firstCompartment.getItems().toString() + secondCompartment.getItems().toString();
    }

    /**
     * See if the rucksack contains a specific item.
     * @param item item to look for
     * @return true if item is in rucksack
     */
    public boolean hasItem(String item) {
        return firstCompartment.hasItem(item) || secondCompartment.hasItem(item);
    }

    /**
     * Compartments of the rucksack.
     */
    public static class Compartment {

        /**
         * List of items in the compartment.
         */
        private List<String> items;

        /**
         * Pack the compartment with items.
         *
         * @param items list of items
         */
        private void pack(List<String> items) {
            this.items = items;
        }

        /**
         * Get the items in the compartment.
         *
         * @return list of items
         */
        public List<String> getItems() {
            return items;
        }

        /**
         * See if the compartment contains an item.
         * @param item item to check for
         * @return true if the compartment contains the item
         */
        public boolean hasItem(String item) {
            return items.contains(item);
        }

    }
}
