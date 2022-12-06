package se.aoc2022.day5;

public class Command {

    /**
     * The commands that can be executed
     */
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

    /**
     * Returns the value of the command.
     *
     * @param commandName command to get the value of
     * @return value of the command
     */
    public int getCommand(CommandName commandName) {
        return switch (commandName) {
            case MOVE -> moveCrates;
            case FROM -> fromStack;
            case TO -> toStack;
        };
    }
}
