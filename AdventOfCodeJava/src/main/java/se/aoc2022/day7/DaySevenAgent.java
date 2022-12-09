package se.aoc2022.day7;

import java.util.List;

public class DaySevenAgent {

    List<String> fileContent;

    public DaySevenAgent(List<String> input) {
        this.fileContent = input;
    }

    public long solvePartOne() {
        DeviceSeven device = new DeviceSeven(fileContent);
        return device.semSizeOfDirsSmallerOrEqualTo(100000);
    }

    public long solvePartTwo() {
        long totalSpace = 70000000;
        long targetFreeSpace = 30000000;
        DeviceSeven device = new DeviceSeven(fileContent);

        long unusedSpace = totalSpace - device.getRoot().getSize();
        long removeAmount = targetFreeSpace - unusedSpace;

        return device.getSizeOfSmallestDirectoryToRemove(removeAmount, device.getRoot());
    }
}
