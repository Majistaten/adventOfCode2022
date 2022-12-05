package se.aoc2022;

import se.aoc2022.day1.DayOneAgent;
import se.aoc2022.day2.DayTwoAgent;
import se.aoc2022.day3.DayThreeAgent;
import se.aoc2022.day4.DayFourAgent;
import se.aoc2022.day5.DayFiveAgent;

import java.util.List;

/**
 * Hello world!
 */
public class App {


    public static void main(String[] args) {
        dayOne();
        dayTwo();
        dayThree();
        dayFour();
        dayFive();
    }



    private static void dayOne() {
        Util.printHeader("DAY ONE");
        List<String> fileContent = Util.getContentFromFile("day1.txt").toList();
        System.out.println(new DayOneAgent().mostCalories(fileContent));
        System.out.println(new DayOneAgent().topThreeCalories(fileContent));
    }

    private static void dayTwo() {
        Util.printHeader("DAY TWO");
        List<String> fileContent = Util.getContentFromFile("day2.txt").toList();
        DayTwoAgent.Game game = new DayTwoAgent.Game(fileContent);
        int result = game.play();
        System.out.printf("The result is %d%n", result);
        int secondResult = game.playWithStrategy();
        System.out.printf("The second result is %d%n", secondResult);
    }

    private static void dayThree() {
        Util.printHeader("DAY THREE");
        List<String> fileContent = Util.getContentFromFile("day3.txt").toList();
        DayThreeAgent agent = new DayThreeAgent(fileContent);
        System.out.printf("The sum of all priorities is %d%n", agent.sumPriorities());
        System.out.printf("The sum of all group priorities is %d%n", agent.sumGroupPriorities());
    }

    private static void dayFour() {
        Util.printHeader("DAY FOUR");
        List<String> fileContent = Util.getContentFromFile("day4.txt").toList();
        DayFourAgent agent = new DayFourAgent(fileContent);
        System.out.printf("There are %d groups where one member's sections is fully contained%n", agent.countOverlappingGroups());
        System.out.printf("Within all groups, there are a total of %d sections overlapping%n", agent.countOverlappingGroupSections());
    }

    private static void dayFive() {
        Util.printHeader("DAY FIVE");
        List<String> fileContent = Util.getContentFromFile("day5.txt").toList();
        DayFiveAgent agent = new DayFiveAgent(fileContent);
        System.out.printf("The crates in the top of each stack is %s%n", agent.getTopCrates());
    }

}
