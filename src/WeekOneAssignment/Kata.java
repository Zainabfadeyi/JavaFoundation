package src.WeekOneAssignment;

import java.util.Scanner;

public class Kata {

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static boolean isPrimeNumber(int number) {
        if (number < 2) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    public static int subtract(int a, int b) {
        return Math.abs(a - b);
    }

    public static float divide(int a, int b) {
        if (b == 0) return 0;
        return (float) a / b;
    }

    public static int factorOf(int number) {
        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) count++;
        }
        return count;
    }

    public static boolean isSquare(int number) {
        if (number < 0) return false;
        int sqrt = (int) Math.sqrt(number);
        return sqrt * sqrt == number;
    }

    public static boolean isPalindrome(int number) {
        String str = String.valueOf(number);
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equals(reversed);
    }

    public static long factorialOf(int number) {
        if (number == 0 || number == 1) return 1;
        long result = 1;
        for (int i = 2; i <= number; i++) {
            result *= i;
        }
        return result;
    }

    public static long squareOf(int number) {
        return (long) number * number;
    }




   
}
