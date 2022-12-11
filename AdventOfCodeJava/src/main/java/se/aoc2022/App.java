package se.aoc2022;

import se.aoc2022.day1.DayOneAgent;
import se.aoc2022.day10.DayTenAgent;
import se.aoc2022.day2.DayTwoAgent;
import se.aoc2022.day3.DayThreeAgent;
import se.aoc2022.day4.DayFourAgent;
import se.aoc2022.day5.DayFiveAgent;
import se.aoc2022.day6.DaySixAgent;
import se.aoc2022.day7.DaySevenAgent;
import se.aoc2022.day8.DayEightAgent;
import se.aoc2022.day9.DayNineAgent;

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
        daySix();
        daySeven();
        dayEight();
        dayNine();
        dayTen();
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
        System.out.printf("The crates in the top of each stack set by the new crane is %s%n", agent.getTopCratesNew());
    }

    private static void daySix() {
        Util.printHeader("DAY SIX");
        List<String> fileContent = Util.getContentFromFile("day6.txt").toList();
        DaySixAgent agent = new DaySixAgent(fileContent);
        System.out.printf("The first signal is found at index %s%n", agent.lockOnToSignal());
        System.out.printf("The first start of message is found at index %s%n", agent.findStartOfMessage());
    }

    private static void daySeven() {
        Util.printHeader("DAY SEVEN");
        List<String> fileContent = Util.getContentFromFile("day7.txt").toList();
        DaySevenAgent agent = new DaySevenAgent(fileContent);
        System.out.printf("The sum of the total sizes for directories smaller than 100000 is: %s%n", agent.solvePartOne());
        System.out.printf("Size of the directory to remove is: %s%n", agent.solvePartTwo());

    }

    private static void dayEight() {
        Util.printHeader("DAY EIGHT");
        List<String> fileContent = Util.getContentFromFile("day8.txt").toList();
        DayEightAgent agent = new DayEightAgent(fileContent);
        System.out.printf("There are a total of %s visible trees in the forest.%n", agent.countVisibleTrees());
        System.out.printf("The tree with the highest score have: %s %n", agent.maxScore());

    }

    private static void dayNine() {
        Util.printHeader("DAY NINE");
        List<String> fileContent = Util.getContentFromFile("day9.txt").toList();
        DayNineAgent agent = new DayNineAgent(fileContent);
        System.out.printf("Not yet implemented %n");

    }

    private static void dayTen() {
        Util.printHeader("DAY TEN");
//        List<String> fileContent = Util.getContentFromFile("day10.txt").toList();
//        DayTenAgent agent = new DayTenAgent(fileContent);
        System.out.printf("Not yet implemented %n");

    }

}
