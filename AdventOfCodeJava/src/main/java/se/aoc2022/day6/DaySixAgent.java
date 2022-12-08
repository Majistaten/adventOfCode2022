package se.aoc2022.day6;

import java.util.List;

public class DaySixAgent {
//    Regex lookahead: https://stackoverflow.com/questions/2973436/regex-lookahead-lookbehind-and-atomic-groups
//    Regex https://regex101.com/r/gxVwL0/1 - (.)(?!\1)(.)(?!\1|\2)(.)(?!\1|\2|\3)(.) should work

    private final Device device;
    private final char[] dataStream;

    public DaySixAgent(List<String> input) {
        device = new Device();
        dataStream = input.get(0).toCharArray();

    }

    public int lockOnToSignal() {
        device.initScan();
        for (char letter : dataStream) {
            int result = device.findSignal(letter);
            if (result != -1) {
                return result;
            }
        }
        return -1;
    }

    public int findStartOfMessage() {
        device.initScan();
        for (char letter : dataStream) {
            int result = device.findStartOfMessage(letter);
            if (result != -1) {
                return result;
            }
        }
        return -1;
    }
}
