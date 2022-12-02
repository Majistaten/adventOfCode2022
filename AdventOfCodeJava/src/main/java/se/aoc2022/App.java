package se.aoc2022;

import se.aoc2022.day1.DayOneAgent;
import se.aoc2022.day2.DayTwoAgent;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    private final static String sep = " " + "*~".repeat(10) + " ";

    public static void main( String[] args )
    {
        dayOne();
        dayTwo();
    }
    private static void separate(String text) {
        System.out.println(sep + text + sep);
    }

    private static void dayOne() {
        separate("DAY ONE");
        List<String> fileContent = Util.getContentFromFile("day1.txt").toList();
        System.out.println(new DayOneAgent().mostCalories(fileContent));
        System.out.println(new DayOneAgent().topThreeCalories(fileContent));
    }

    private static void dayTwo() {
        separate("DAY TWO");
        List<String> fileContent = Util.getContentFromFile("day2.txt").toList();
        DayTwoAgent.Game game = new DayTwoAgent.Game(fileContent);
        int result = game.play();
        System.out.printf("The result is %d%n", result);
        int secondResult = game.playWithStrategy();
        System.out.printf("The second result is %d%n", secondResult);
    }


}
