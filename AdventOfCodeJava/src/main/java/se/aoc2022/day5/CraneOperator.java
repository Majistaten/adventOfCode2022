package se.aoc2022.day5;

import java.util.List;

public class CraneOperator {

    CargoCrane crane;
    List<Command> commands;

    public CraneOperator( CargoCrane crane, List<Command> commands) {
        this.crane = crane;
        this.commands = commands;
    }

    /**
     * Execute all commands in the list.
     */
    public void moveCrates() {
        for (Command command : commands) {
            crane.moveCrates(command);
        }
    }

    /**
     * Get the label of the crates on top of each stack.
     *
     * @return label of the crates on top of each stack
     */
    public String getTopCrates() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < crane.crateStacks.size(); i++) {
            sb.append(crane.crateStacks.get(i).getLast());
        }
        return sb.toString();
    }

}
