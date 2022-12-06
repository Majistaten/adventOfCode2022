package se.aoc2022.day5;

public class Command {
    enum CommandName {
        MOVE, FROM, TO
    }
    private final int moveCrates;
    private final int fromStack;
    private final int toStack;

    public Command(int moveCrates, int fromStack, int toStack) {
        this.moveCrates = moveCrates;
        this.fromStack = fromStack;
        this.toStack = toStack;
    }

    public int getCommand(CommandName commandName) {
        return switch (commandName) {
            case MOVE -> moveCrates;
            case FROM -> fromStack;
            case TO -> toStack;
        };
    }
}
