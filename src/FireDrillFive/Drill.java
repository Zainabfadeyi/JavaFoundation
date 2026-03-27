package src.FireDrillFive;

import java.util.Scanner;
import java.util.Arrays;

public class Drill {

    public static int[] factorsOf(int number) {
        int count = 0;

        for (int i = 2; i <= number; i++) {
            if (number % i == 0) count++;
        }

        int[] factors = new int[count];
        int index = 0;


        for (int i = 2; i <= number; i++) {
            if (number % i == 0) {
                factors[index] = i;
                index++;
            }
        }

        return factors;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int n5 = scanner.nextInt();

        int[] result = factorsOf(n5);

        System.out.println("Factors: " + Arrays.toString(result));
    }
}