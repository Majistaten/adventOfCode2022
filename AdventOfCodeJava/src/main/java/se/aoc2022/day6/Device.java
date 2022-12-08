package se.aoc2022.day6;

import java.util.ArrayDeque;
import java.util.Deque;

public class Device {
    private Deque<Character> signals;
    private int signalBlockIndex = 0;

    /**
     * Find the first occurrence of the signal - 4 unique characters in a row.
     *
     * @param letter letter to receive
     * @return the index of the first occurrence of the signal, or -1 if not found
     */
    public int findSignal(char letter) {
        signals.addLast(letter);
        signalBlockIndex++;
        if (signals.size() >= 4) {
            if (signals.stream()
                    .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                    .toString()
                    .matches("(.)(?!\\1)(.)(?!\\1|\\2)(.)(?!\\1|\\2|\\3)(.)")) {
                return signalBlockIndex;
            }
            signals.removeFirst();
        }
        return -1;
    }

    public void initScan() {
        signals = new ArrayDeque<>();
        signalBlockIndex = 0;
    }

    /**
     * Find the start of the message, which is the first occurrence of 14 unique characters passed to this method
     * in a row.
     *
     * @param letter letter to receive
     * @return index of the start of message if found, or -1 if not found
     */
    public int findStartOfMessage(char letter) {
        signals.addLast(letter);
        signalBlockIndex++;
        if (signals.size() >= 14) {
            if (signals.stream()
                    .distinct()
                    .count() == 14) {
                return signalBlockIndex;
            }
            signals.removeFirst();
        }

        return -1;
    }

}
