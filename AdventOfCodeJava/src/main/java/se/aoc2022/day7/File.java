package se.aoc2022.day7;

public class File {
    protected String name;
    protected long size;

    public File(String name, long size) {
        this.name = name;
        this.size = size;
    }

    public long getSize() {
        return size;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("* %s (file, size=%s)%n", name, getSize());
    }

    public String toString(int depth) {
        return String.format("| ".repeat(depth) + this);
    }
}
