package se.aoc2022.day7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Directory extends File {

    private Map<String, List<File>> fileSystem;

    private final Directory parent;
    public Directory(String name, Directory parent) {
        super(name, 0);
        this.parent = parent;
        fileSystem = new HashMap<>();
    }

    public boolean addFile(File file) {
        if (!fileSystem.containsKey("files")) {
            fileSystem.put("files", new ArrayList<>());
        }
        List<File> files = getFiles();
        files.add(file);
        fileSystem.put("files", files);
        return fileSystem.get("files").contains(file);
    }

    public boolean addFile(String name, long size) {
        File file = new File(name, size);
        return addFile(file);
    }

    public boolean removeFile(String name) {
        if (!fileSystem.containsKey("files")) {
            fileSystem.put("files", new ArrayList<>());
        }
        return fileSystem.get("files").removeIf(file -> file.getName().equals(name));
    }

    public boolean addDirectory(Directory directory) {
        if (!fileSystem.containsKey("dir")) {
            fileSystem.put("dir", new ArrayList<>());
        }
        List<File> dirs = getDirectories();
        dirs.add(directory);
        fileSystem.put("dir", dirs);
        return getDirectories().contains(directory);
    }

    public boolean addDirectory(String name) {
        Directory directory = new Directory(name, this);
        return addDirectory(directory);
    }

    public boolean removeDirectory(String name) {
        for (File dir : getDirectories()) {
            Directory directory = (Directory) dir;
            if (dir.getName().equals(name)) {
                return fileSystem.get("dir").remove(directory);
            }
        }
        return false;
    }

    public Directory getParent() {
        return parent;
    }

    @Override
    public long getSize() {
        long dirSize = 0;
        if (fileSystem.containsKey("dir")) {
            for (File dir : getDirectories()) {
                Directory directory = (Directory) dir;
                dirSize += directory.getSize();
            }
        }
        if (fileSystem.containsKey("files")) {
            for (File file : getFiles()) {
                dirSize += file.getSize();
            }
        }
        return dirSize;
    }

    public List<File> getFiles() {
        fileSystem.computeIfAbsent("files", k -> new ArrayList<>());
        return fileSystem.get("files");
    }

    public List<File> getDirectories() {
        fileSystem.computeIfAbsent("dir", k -> new ArrayList<>());
        return fileSystem.get("dir");
    }

    public Directory getDirectory(String name) {
        for (File dir : fileSystem.get("dir")) {
            Directory directory = (Directory) dir;
            if (directory.getName().equals(name)) {
                return directory;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return String.format("- %s (dir, size=%s)%n", name, getSize());
    }

    public String toString(int depth) {
        StringBuilder sb = new StringBuilder();
        sb.append("| ".repeat(depth)).append(this);

        if (fileSystem.get("dir") != null) {
            for (File file : fileSystem.get("dir")) {
                Directory dir = (Directory) file;
                sb.append(String.format("%s", dir.toString(depth + 1)));
            }
        }
        if (fileSystem.get("files") != null) {
            for (File file : fileSystem.get("files")) {
                sb.append(String.format("%s", file.toString(depth + 1)));
            }
        }
        return sb.toString();
    }
}
