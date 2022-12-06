package se.aoc2022.day5;

import java.util.Deque;
import java.util.List;

public class CargoCrane {
    List<Deque<Character>> crateStacks;

    public CargoCrane(List<Deque<Character>> crateStacks) {
        this.crateStacks = crateStacks;
    }

    public void moveCrates(Command command) {
        int moveCrates = command.getCommand(Command.CommandName.MOVE);
        int fromStack = command.getCommand(Command.CommandName.FROM);
        int toStack = command.getCommand(Command.CommandName.TO);
        for (int i = 0; i < moveCrates; i++) {
            crateStacks.get(toStack-1).addLast(crateStacks.get(fromStack-1).removeLast());
        }
    }
}
