package se.aoc2022.day5;

import java.util.*;

public class DayFiveAgent {
    private final CraneOperator craneOperator;
    private final CraneOperator newCraneOperator;

    public DayFiveAgent(List<String> fileContent) {
        CargoCrane crane = new CargoCrane(extractCrateStacks(fileContent));
        CargoCrane newCrane = new NewCargoCrane(extractCrateStacks(fileContent));
        this.craneOperator = new CraneOperator(crane, extractMoveCommands(fileContent));
        this.newCraneOperator = new CraneOperator(newCrane, extractMoveCommands(fileContent));
    }

    private List<Deque<Character>> extractCrateStacks(List<String> fileContent) {

        List<Deque<Character>> stacks = new ArrayList<>();

        for (int i = 0; i <= fileContent.get(0).length() / 4 ; i++) {
            stacks.add(new ArrayDeque<>());
        }
        for (String line : fileContent) {
            if (line.charAt(0) != '[') {
                break;
            }
            for (int i = 0; i <= line.length() / 4 ; i++) {
                char crate = line.charAt(i * 4 + 1);
                if (crate == ' ') {
                    continue;
                }
                stacks.get(i).addFirst(crate);
            }
        }
        return stacks;
    }

    private List<Command> extractMoveCommands(List<String> fileContent) {

        List<Command> commands = new ArrayList<>();

        for (String line : fileContent) {
            if (!line.contains("move")) {
                continue;
            }
            String[] parts = line.split(" ");
            int moveCrates = Integer.parseInt(parts[1]);
            int fromStack = Integer.parseInt(parts[3]);
            int toStack = Integer.parseInt(parts[5]);
            commands.add(new Command(moveCrates, fromStack, toStack));
        }

        return commands;
    }

    public String getTopCrates() {
        craneOperator.moveCrates();
        return craneOperator.getTopCrates();
    }

    public String getTopCratesNew() {
        newCraneOperator.moveCrates();
        return newCraneOperator.getTopCrates();
    }
}
