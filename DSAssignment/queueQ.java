package PFAssignments.DSAssignment;
/**
 * Implement the university counselling procedure using the queue structure.
    Organize the applicants into a queue depending on their different mark's percentages.  The beginning will have a higher percentage  (In case of same percentage, random will be given chance first).
    Making a list of universities to which applications will be accepted. Consider making at least 5 universities available, giving each candidate the choice of one to five highly ranked institutions.
    In accordance with the established queue, candidates will be contacted for counselling in turn, and they will only be able to choose from the seats that are currently open in the university. Un Assigned will be handled in a subsequent round.
    Keep in mind that there should be more candidates than there are seats available.

    Finally, show the candidates with their assigned universities.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;

public class queueQ{
public static class Student implements Comparable<Student> {
        private final String name;
        private final double percentage;
        private final List<String> preferences;
        private final long tieBreakerId; // Random ID for explicit tie-breaking requirement
        private String assignedUniversity;

        public Student(String name, double percentage, List<String> preferences) {
            this.name = name;
            this.percentage = percentage;
            this.preferences = new ArrayList<>(preferences);
            this.assignedUniversity = "Unassigned";
            this.tieBreakerId = RandomUtil.getRandomKey();
        }

        public String getName() {
            return name;
        }

        public double getPercentage() {
            return percentage;
        }

        public List<String> getPreferences() {
            return Collections.unmodifiableList(preferences);
        }

        public String getAssignedUniversity() {
            return assignedUniversity;
        }

        public void setAssignedUniversity(String assignedUniversity) {
            this.assignedUniversity = assignedUniversity;
        }

        @Override
        public int compareTo(Student other) {
            // Priority 1: Higher percentage comes first
            int percentageCompare = Double.compare(other.percentage, this.percentage);
            if (percentageCompare != 0) {
                return percentageCompare;
            }
            
            // Priority 2: Tie-breaker - random assignment chance
            return Long.compare(this.tieBreakerId, other.tieBreakerId);
        }

        @Override
        public String toString() {
            return String.format("%-10s | %-6.2f%% | %s", name, percentage, assignedUniversity);
        }
    }

    /**
     * Domain model for a University.
     */
    public static class University {
        private final String name;
        private int availableSeats;

        public University(String name, int availableSeats) {
            this.name = name;
            this.availableSeats = availableSeats;
        }

        public String getName() {
            return name;
        }

        public boolean hasSeats() {
            return availableSeats > 0;
        }

        public boolean allocateSeat() {
            if (hasSeats()) {
                availableSeats--;
                return true;
            }
            return false;
        }
    }

    private static class RandomUtil {
        private static final Random RANDOM = new Random();
        public static long getRandomKey() {
            return RANDOM.nextLong();
        }
    }

    /**
     * Service method executing the counseling procedure.
     */
    public static List<Student> processCounselingRound(
            PriorityQueue<Student> queue, 
            Map<String, University> universities) {

        List<Student> processedCandidates = new ArrayList<>();

        while (!queue.isEmpty()) {
            Student candidate = queue.poll();
            processedCandidates.add(candidate);

            for (String pref : candidate.getPreferences()) {
                University target = universities.get(pref);
                if (target != null && target.hasSeats()) {
                    target.allocateSeat();
                    candidate.setAssignedUniversity(target.getName());
                    break; // Stop checking preferences once allocated
                }
            }
        }

        return processedCandidates;
    }

    public static void main(String[] args) {
        // Step 1: Initialize 5 Universities with limited seat counts
        Map<String, University> universities = new HashMap<>();
        universities.put("SKIT", new University("SKIT", 1));
        universities.put("JECRC", new University("JECRC", 1));
        universities.put("VGU", new University("VGU", 1));
        universities.put("GIT", new University("GIT", 1));
        universities.put("PU", new University("PU", 1));

        // Step 2: Populate Priority Queue (More candidates than total seats)
        PriorityQueue<Student> counselingQueue = new PriorityQueue<>();
        counselingQueue.add(new Student("Uddeshya", 92.5, Arrays.asList("SKIT", "GIT", "PU")));
        counselingQueue.add(new Student("Anjali", 95.0, Arrays.asList("PU", "JECRC")));
        counselingQueue.add(new Student("Dipanshu", 88.0, Arrays.asList("VGU", "PU")));
        counselingQueue.add(new Student("Gunwant", 92.5, Arrays.asList("PU", "SKIT")));
        counselingQueue.add(new Student("Yashika", 85.0, Arrays.asList("GIT", "SKIT")));
        counselingQueue.add(new Student("Lakshya", 98.0, Arrays.asList("VGU", "JECRC")));
        counselingQueue.add(new Student("Garvit", 79.0, Arrays.asList("GIT")));

        System.out.println("Starting University Counseling Allocation System...");

        // Step 3: Run allocation engine
        List<Student> results = processCounselingRound(counselingQueue, universities);

        // Step 4: Output assignment status
        System.out.println("\n================ FINAL CANDIDATE ASSIGNMENT ================");
        System.out.printf("%-10s | %-7s | %s%n", "NAME", "MARKS", "STATUS / ASSIGNED VARSITY");
        System.out.println("------------------------------------------------------------");
        for (Student student : results) {
            System.out.println(student);
        }
    }
}