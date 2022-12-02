package se.aoc2022;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public final class Util {

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
