package se.aoc2022;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public final class Util {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    private final static String sep = String.format("%s*%s~%s",
            Util.ANSI_RED, Util.ANSI_GREEN, Util.ANSI_RESET);

    public static void printHeader(String headerText) {
        int len = 60;
        int textLen = headerText.length();
        int left = (len - textLen / 2) / 2;
        int right = len - textLen / 2 - left;
        String leftSep = sep.repeat(left);
        String rightSep = sep.repeat(right);
        System.out.printf("%s %s %s%n", leftSep, headerText, rightSep);
    }

    /**
     * Returns the path to the file with the given name in the common-resources folder.
     *
     * @param fileName the name of the file.
     *
     * @return the path to the file.
     */
    public static Path getComResFilePath(final String fileName) {
        try {
            return Paths.get("../", "common-resources", fileName).toRealPath();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Returns a stream of the lines in the file with the given path.
     *
     * @param path the path to the file.
     * @return a stream of the lines in the file.
     */
    public static Stream<String> getContentFromPath(final Path path) {
        try {
            return Files.lines(path);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Returns a stream of the lines in the file with the given name in the common-resources folder.
     *
     * @param fileName the name of the file.
     * @return a stream of the lines in the file.
     */
    public static Stream<String> getContentFromFile(final String fileName) {
        return getContentFromPath(getComResFilePath(fileName));
    }
}
