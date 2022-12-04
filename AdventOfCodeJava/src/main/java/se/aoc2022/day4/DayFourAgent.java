package se.aoc2022.day4;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class DayFourAgent {

    List<GroupSectionAssignment> groupSectionAssignments;
    public DayFourAgent(List<String> assignments) {
        groupSectionAssignments = assignments.stream().map(GroupSectionAssignment::new).toList();
    }

    /**
     * Count the number of assignments where one member section is fully contained within the other member section.
     *
     * @return number of assignments where one member section is fully contained within the other member section
     */
    public int countOverlappingGroups() {
        final AtomicInteger count = new AtomicInteger();
        groupSectionAssignments.forEach(group -> {
            if (group.memberSectionsIsContained()) count.getAndIncrement();
        });
        return count.get();
    }

    /**
     * Count the number of assignments where one member section overlaps with the other member section.
     *
     * @return number of assignments where one member section overlaps with the other member section
     */
    public int countOverlappingGroupSections() {
        final AtomicInteger count = new AtomicInteger();
        groupSectionAssignments.forEach(group -> {
            if (group.memberSectionOverlap()) count.getAndIncrement();
        });
        return count.get();
    }
}
