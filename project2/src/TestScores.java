import java.util.*;

public class TestScores {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner scnr = new Scanner(System.in);

        final int SIZE = rand.nextInt(3, 10);

        int[] testScores = new int[SIZE];
        char[] letterGrades = new char[SIZE];

        System.out.println("Enter " + SIZE + " test scores.");
        for (int i = 1; i <= SIZE; i++) {
            System.out.println("Enter test score " + i);
            testScores[i-1] = scnr.nextInt();
        }

        for (int i = 0; i < SIZE; i ++) {
            letterGrades[i] = getLetterGrade(testScores[i]);
        }

        printGrades(testScores, letterGrades);
        printHighestScore(testScores);
        printLowestScore(testScores);
        printAverageScore(testScores);

    }

    public static char getLetterGrade(int score) {
        char letterGrade;
        if (score >= 90) {
            letterGrade = 'A';
        } else if (score >= 80) {
            letterGrade = 'B';
        } else if (score >= 70) {
            letterGrade = 'C';
        } else if (score >= 60) {
            letterGrade = 'D';
        } else {
            letterGrade = 'F';
        }
        return letterGrade;
    }

    public static void printGrades(int[] testScores, char[] letterGrades) {
        System.out.println("Score | Grade");
        for (int i = 0; i < testScores.length; i++) {
            System.out.println(testScores[i] + "    |    " + letterGrades[i]);
        }
    }

    public static void printHighestScore(int[] testScores) {
        int highestScore = 0;
        for (int i = 0; i < testScores.length; i++) {
            if (testScores[i] > highestScore) {
                highestScore = testScores[i];
            }
        }
        System.out.println("The highest score is " + highestScore);
    }

    public static void printLowestScore(int[] testScores) {
        int lowestScore = 100;
        for (int i = 0; i < testScores.length; i++) {
            if (testScores[i] < lowestScore) {
                lowestScore = testScores[i];
            }
        }
        System.out.println("The lowest score is " + lowestScore);
    }

    public static void printAverageScore(int[] testScores) {
        int scoresTotal = 0;
        double average;
        for (int i = 0; i < testScores.length; i++) {
            scoresTotal += testScores[i];
        }
        average = (double) scoresTotal / testScores.length;
        System.out.printf("The average test score is %.2f", average);
    }
}
