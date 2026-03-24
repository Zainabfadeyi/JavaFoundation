package src.FireDrillFive;

import java.util.Scanner;

public class LCMCalculator {

    public static int lcmGcd(int a, int b) {
        while (b != 0) {
            int num = b;
            b = a % b;
            a = num;
        }
        return a;
    }

    public static int lcm(int a, int b) {
        return (a / lcmGcd(a, b)) * b;
    }

    public static int lcmOfArray(int[] numbers) {
        int result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            result = lcm(result, numbers[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[3];

        System.out.println("Enter 3 numbers:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        int result = lcmOfArray(numbers);

        System.out.println("\nNumbers  : " + numbers[0] + ", " + numbers[1] + ", " + numbers[2]);
        System.out.println("LCM      : " + result);

        scanner.close();
    }
}