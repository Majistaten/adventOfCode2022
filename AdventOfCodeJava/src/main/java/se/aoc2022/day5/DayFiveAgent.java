package se.aoc2022.day5;

import java.util.List;
import java.util.Stack;

public class DayFiveAgent {

    public DayFiveAgent(List<String> fileContent) {

    }

    private List<Stack<String>> extractCrateStacks(List<String> fileContent) {
        // Divide each line in parts of four characters.
        // Each part index is a stack of crates and if the part contains [?] it means that a crate should be put in the
        // stack. The first crate to come by is on top of the stack, so the stacks need to be reversed. A dequeue could
        // be a better data structure for this.
        // Break loop if line contains numbers or something else than [?]
        return null;
    }

    private List<String> extractMoveCommands(List<String> fileContent) {
        // Each line is a set of commands with keywords ["move", "from", "to"].
        // Separate each line by " " and extract command and the next index. Store in a command object.
        return null;
    }

    public String getTopCrates() {
        return null;
    }
}
