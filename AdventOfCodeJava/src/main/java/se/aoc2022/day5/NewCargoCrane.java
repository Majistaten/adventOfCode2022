package se.aoc2022.day5;

import java.util.Deque;
import java.util.List;
import java.util.Stack;

public class NewCargoCrane extends CargoCrane {
    public NewCargoCrane(final List<Deque<Character>> crateStacks) {
        super(crateStacks);
    }

    @Override
    public void moveCrates(final Command command) {
        int moveCrates = command.getCommand(Command.CommandName.MOVE);
        int fromStack = command.getCommand(Command.CommandName.FROM);
        int toStack = command.getCommand(Command.CommandName.TO);
        // Move moveCrates from fromStack and place them in the same order on toStack
        Stack<Character> crates = new Stack<>();
        for (int i = 0; i < moveCrates; i++) {
            crates.add(super.crateStacks.get(fromStack-1).removeLast());
        }
        for (int i = 0; i < moveCrates; i++) {
            super.crateStacks.get(toStack-1).addLast(crates.pop());
        }
    }
}
