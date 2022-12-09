package se.aoc2022.day7;


import java.util.ArrayList;
import java.util.List;

public class DeviceSeven {

    private final Directory root;
    private Directory currentDir;

    public DeviceSeven(List<String> input) {
        root = new Directory("root", null);
        currentDir = root;
        if (!initializeFileSystem(input)) {
            System.out.println("Error initializing file system");
        }
    }

    private boolean initializeFileSystem(List<String> commands) {
        for (String line : commands) {
            String[] command = line.split(" ");
            if (command[0].equals("$")) {
                // USER COMMAND
                if (command[1].equals("cd")) {
                    changeDirectory(command[2]);
                }
            } else {
                // LS RESPONSE
                if (command[0].equals("dir")) {
                    if (!createDirectory(command[1])) {
                        return false;
                    }
                } else {
                    if (!createFile(command[1], Long.parseLong(command[0]))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public Directory getRoot() {
        return root;
    }

    public Directory getCurrentDir() {
        return currentDir;
    }

    public boolean createDirectory(String name) {
        if (!currentDir.addDirectory(name)) {
            System.out.println("Directory already exists");
            return false;
        }
        return true;
    }

    public boolean removeDirectory(String name) {
        if (!currentDir.removeDirectory(name)) {
            System.out.println("Directory not found");
            return false;
        }
        return true;
    }

    public boolean createFile(String name, long size) {
        if (!currentDir.addFile(name, size)) {
            System.out.println("Could not create file");
            return false;
        }
        return true;
    }

    public boolean removeFile(String name) {
        if (!currentDir.removeFile(name)) {
            System.out.println("File " + name + " not found");
            return false;
        }
        return true;
    }

    public void changeDirectory(String name) {
        switch (name) {
            case ".." -> currentDir = currentDir.getParent();
            case "." -> {}
            case "/" -> currentDir = root;
            default -> this.currentDir = currentDir.getDirectory(name);
        }
    }

    public long getDirectorySize() {
        return currentDir.getSize();
    }

    public void printFileSystem() {
        System.out.println(root.toString(0));
    }

    // Get all nested directories and check if their size is smaller than or equal to the given size
    private List<Directory> findDirectoriesOfSizeSTE(long size, Directory target) {
        List<Directory> dirs = new ArrayList<>();
        for (File dir : target.getDirectories()) {
            Directory directory = (Directory) dir;
            if (directory.getSize() <= size) {
                dirs.add(directory);
            }
            dirs.addAll(findDirectoriesOfSizeSTE(size, directory));
        }
        return dirs;
    }

    public long semSizeOfDirsSmallerOrEqualTo(long size) {
        long totalSize = 0;
        for (Directory dir : findDirectoriesOfSizeSTE(size, getRoot())) {
            totalSize += dir.getSize();
        }
        return totalSize;
    }

    public long getSizeOfSmallestDirectoryToRemove(long size, Directory target) {
        long closestSize = Long.MAX_VALUE;
        for (File file : target.getDirectories()) {
            Directory directory = (Directory) file;
            if (directory.getSize() >= size && directory.getSize() < closestSize) {
                closestSize = directory.getSize();
            }
            long subDirSize = getSizeOfSmallestDirectoryToRemove(size, directory);
            closestSize = Math.min(subDirSize, closestSize);
        }
        return closestSize;
    }


}
