package se.aoc2022;

import se.aoc2022.day1.DayOneAgent;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        dayOne();
    }

    private static void dayOne() {
        List<String> fileContent = Util.getContentFromFile("day1.txt").toList();
        System.out.println(new DayOneAgent().mostCalories(fileContent));
        System.out.println(new DayOneAgent().topThreeCalories(fileContent));
    }
}
