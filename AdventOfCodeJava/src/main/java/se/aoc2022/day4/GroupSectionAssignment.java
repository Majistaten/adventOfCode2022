package se.aoc2022.day4;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class GroupSectionAssignment {
    private final Set<Integer> memberOneSections;
    private final Set<Integer> memberTwoSections;
    public GroupSectionAssignment(String assignment) {
        String[] groupSections = assignment.split(",");
        memberOneSections = getSectionRange(groupSections[0]);
        memberTwoSections = getSectionRange(groupSections[1]);
    }

    /**
     * Convert a string to a range of sections.
     *
     * @param section string with sections in range format (1-3) which is converted to a set of sections (1,2,3)
     * @return set of sections
     */
    private Set<Integer> getSectionRange(String section) {
        String[] split = section.split("-");
        return IntStream.rangeClosed(Integer.parseInt(split[0]), Integer.parseInt(split[1])).collect(HashSet::new, Set::add, Set::addAll);
    }

    /**
     * Check to see if one member section is fully contained within the other member section.
     *
     * @return true if one member section is fully contained within the other member section
     */
    public boolean memberSectionsIsContained() {
        return memberOneSections.containsAll(memberTwoSections) || memberTwoSections.containsAll(memberOneSections);
    }

    /**
     * Check to see if one member section overlaps with the other member section.
     *
     * @return true if one member section overlaps with the other member section
     */
    public boolean memberSectionOverlap() {
        return memberOneSections.stream().anyMatch(memberTwoSections::contains);
    }
}
