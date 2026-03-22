package src.WeekOneAssignment;



import java.util.Scanner;

public class StudentGrade{

    static final int    MIN_SCORE          = 0;
    static final int    MAX_SCORE          = 100;
    static final int    PASS_SCORE         = 50;
    static final String EQUALS_DIVIDER     = "===============================================================";
    static final String EXCLAIM_DIVIDER    = "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!";


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("How many students do you have? ");
        int totalStudents = scanner.nextInt();

        System.out.print("How many subjects do they offer? ");
        int totalSubjects = scanner.nextInt();

        int[][] scores = new int[totalStudents][totalSubjects];

        collectScores(scanner, scores, totalStudents, totalSubjects);
        printScoreTable(scores, totalStudents, totalSubjects);
        printSubjectSummary(scores, totalStudents, totalSubjects);
        printClassSummary(scores, totalStudents, totalSubjects);

        scanner.close();
    }


    private static void collectScores(Scanner scanner, int[][] scores,
                                      int totalStudents, int totalSubjects) {
        for (int s = 0; s < totalStudents; s++) {
            for (int sub = 0; sub < totalSubjects; sub++) {
                System.out.println("Entering score for student " + (s + 1));
                System.out.print("Enter score for subject " + (sub + 1) + ": ");
                int score = scanner.nextInt();

                while (score < MIN_SCORE || score > MAX_SCORE) {
                    System.out.print("Invalid! Score must be between 0 and 100. Re-enter: ");
                    score = scanner.nextInt();
                }

                System.out.println("Saving >>>>>>>>>>>>>>>>>>>>>>>>");
                scores[s][sub] = score;
                System.out.println("Saved successfully");
            }
        }
    }


    private static int studentTotal(int[] studentScores) {
        int total = 0;
        for (int score : studentScores) total += score;
        return total;
    }

    private static double studentAverage(int[] studentScores) {
        return (double) studentTotal(studentScores) / studentScores.length;
    }

    private static int[] allStudentTotals(int[][] scores, int totalStudents) {
        int[] totals = new int[totalStudents];
        for (int s = 0; s < totalStudents; s++) {
            totals[s] = studentTotal(scores[s]);
        }
        return totals;
    }

    private static int[] allStudentPositions(int[] totals, int totalStudents) {
        int[] positions = new int[totalStudents];
        for (int s = 0; s < totalStudents; s++) {
            int position = 1;
            for (int other = 0; other < totalStudents; other++) {
                if (totals[other] > totals[s]) position++;
            }
            positions[s] = position;
        }
        return positions;
    }


    private static void printScoreTable(int[][] scores, int totalStudents, int totalSubjects) {
        int[] totals    = allStudentTotals(scores, totalStudents);
        int[] positions = allStudentPositions(totals, totalStudents);

        System.out.println(EQUALS_DIVIDER);
        System.out.print("STUDENT     ");
        for (int sub = 0; sub < totalSubjects; sub++) {
            System.out.print("SUB" + (sub + 1) + "      ");
        }
        System.out.println("TOT      AVE       POS");
        System.out.println(EQUALS_DIVIDER);

        for (int s = 0; s < totalStudents; s++) {
            System.out.printf("%-12s", "Student " + (s + 1));
            for (int sub = 0; sub < totalSubjects; sub++) {
                System.out.printf("  %-7d", scores[s][sub]);
            }
            System.out.printf("%-9d%-12.2f%d%n",
                    totals[s],
                    studentAverage(scores[s]),
                    positions[s]);
        }
        System.out.println(EQUALS_DIVIDER);
    }


    private static void printSubjectSummary(int[][] scores, int totalStudents, int totalSubjects) {
        System.out.println("SUBJECT SUMMARY");

        for (int sub = 0; sub < totalSubjects; sub++) {
            int highest         = scores[0][sub];
            int lowest          = scores[0][sub];
            int highestStudent  = 0;
            int lowestStudent   = 0;
            int subjectTotal    = 0;
            int passes          = 0;
            int failures        = 0;

            for (int s = 0; s < totalStudents; s++) {
                int score = scores[s][sub];
                subjectTotal += score;

                if (score > highest) { highest = score; highestStudent = s; }
                if (score < lowest)  { lowest  = score; lowestStudent  = s; }

                if (score >= PASS_SCORE) passes++;
                else                     failures++;
            }

            double average = (double) subjectTotal / totalStudents;

            System.out.println("Subject " + (sub + 1));
            System.out.println("Highest scoring student is: Student " + (highestStudent + 1) + " scoring " + highest);
            System.out.println("Lowest scoring student is:  Student " + (lowestStudent  + 1) + " scoring " + lowest);
            System.out.println("Total Score is: "   + subjectTotal);
            System.out.printf ("Average score is: %.2f%n", average);
            System.out.println("Number of passes: " + passes);
            System.out.println("Number of fails:  " + failures);
            System.out.println();
        }
    }


    private static void printClassSummary(int[][] scores, int totalStudents, int totalSubjects) {
        int[] totals = allStudentTotals(scores, totalStudents);

        int bestStudent             = 0;
        int worstStudent            = 0;
        int overallHighest          = scores[0][0];
        int overallLowest           = scores[0][0];
        int overallHighestStudent   = 0;
        int overallHighestSubject   = 0;
        int overallLowestStudent    = 0;
        int overallLowestSubject    = 0;
        int classTotal              = 0;

        int[] failuresPerSubject    = new int[totalSubjects];
        int[] passesPerSubject      = new int[totalSubjects];

        for (int s = 0; s < totalStudents; s++) {
            classTotal += totals[s];

            if (totals[s] > totals[bestStudent])  bestStudent  = s;
            if (totals[s] < totals[worstStudent]) worstStudent = s;

            for (int sub = 0; sub < totalSubjects; sub++) {
                int score = scores[s][sub];

                if (score > overallHighest) {
                    overallHighest        = score;
                    overallHighestStudent = s;
                    overallHighestSubject = sub;
                }
                if (score < overallLowest) {
                    overallLowest        = score;
                    overallLowestStudent = s;
                    overallLowestSubject = sub;
                }

                if (score < PASS_SCORE) failuresPerSubject[sub]++;
                else                    passesPerSubject[sub]++;
            }
        }

        int hardestSubject = 0;
        int easiestSubject = 0;
        for (int sub = 0; sub < totalSubjects; sub++) {
            if (failuresPerSubject[sub] > failuresPerSubject[hardestSubject]) hardestSubject = sub;
            if (passesPerSubject[sub]   > passesPerSubject[easiestSubject])   easiestSubject = sub;
        }

        double classAverage = (double) classTotal / totalStudents;

        System.out.println("The hardest subject is Subject " + (hardestSubject + 1)
                + " with " + failuresPerSubject[hardestSubject] + " failures");
        System.out.println("The easiest subject is Subject " + (easiestSubject + 1)
                + " with " + passesPerSubject[easiestSubject] + " passes");
        System.out.println("The overall Highest score is scored by Student " + (overallHighestStudent + 1)
                + " in subject " + (overallHighestSubject + 1) + " scoring " + overallHighest);
        System.out.println("The overall Lowest score is scored by Student "  + (overallLowestStudent  + 1)
                + " in subject " + (overallLowestSubject  + 1) + " scoring " + overallLowest);

        System.out.println(EQUALS_DIVIDER);
        System.out.println("CLASS SUMMARY");
        System.out.println(EQUALS_DIVIDER);
        System.out.println("Best Graduating Student is:  Student " + (bestStudent  + 1) + " scoring " + totals[bestStudent]);
        System.out.println(EQUALS_DIVIDER);
        System.out.println(EXCLAIM_DIVIDER);
        System.out.println("Worst Graduating Student is: Student " + (worstStudent + 1) + " scoring " + totals[worstStudent]);
        System.out.println(EXCLAIM_DIVIDER);
        System.out.println(EQUALS_DIVIDER);
        System.out.println("Class total score is: "  + classTotal);
        System.out.printf ("Class Average score is: %.1f%n", classAverage);
        System.out.println(EQUALS_DIVIDER);
    }
}
