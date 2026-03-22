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




    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {

            System.out.println("  1. isEven                   ");
            System.out.println("  2. isPrimeNumber            ");
            System.out.println("  3. subtract                 ");
            System.out.println("  4. divide                   ");
            System.out.println("  5. factorOf                 ");
            System.out.println("  6. isSquare                 ");
            System.out.println("  7. isPalindrome             ");
            System.out.println("  8. factorialOf              ");
            System.out.println("  9. squareOf                 ");
            System.out.println("  0. Exit                     ");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter an integer: ");
                    int n1 = scanner.nextInt();
                    System.out.println("Result: " + isEven(n1));
                    break;

                case 2:
                    System.out.print("Enter an integer: ");
                    int n2 = scanner.nextInt();
                    System.out.println("Result: " + isPrimeNumber(n2));
                    break;

                case 3:
                    System.out.print("Enter first integer: ");
                    int a3 = scanner.nextInt();
                    System.out.print("Enter second integer: ");
                    int b3 = scanner.nextInt();
                    System.out.println("Result: " + subtract(a3, b3));
                    break;

                case 4:
                    System.out.print("Enter first integer: ");
                    int a4 = scanner.nextInt();
                    System.out.print("Enter second integer: ");
                    int b4 = scanner.nextInt();
                    System.out.println("Result: " + divide(a4, b4));
                    break;

                case 5:
                    System.out.print("Enter an integer: ");
                    int n5 = scanner.nextInt();
                    System.out.println("Result: " + factorOf(n5));
                    break;

                case 6:
                    System.out.print("Enter an integer: ");
                    int n6 = scanner.nextInt();
                    System.out.println("Result: " + isSquare(n6));
                    break;

                case 7:
                    System.out.print("Enter a 5-digit integer: ");
                    int n7 = scanner.nextInt();
                    System.out.println("Result: " + isPalindrome(n7));
                    break;

                case 8:
                    System.out.print("Enter an integer: ");
                    int n8 = scanner.nextInt();
                    System.out.println("Result: " + factorialOf(n8));
                    break;

                case 9:
                    System.out.print("Enter an integer: ");
                    int n9 = scanner.nextInt();
                    System.out.println("Result: " + squareOf(n9));
                    break;

                case 0:
                    System.out.println("Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println(" Invalid option. Please choose 0 - 9.");
            }
        }

        scanner.close();
    }
}
