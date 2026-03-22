package src.WeekOneAssignment;
import java.util.Arrays;

public class ArrayKata {

    public static int maximumIn(int[] numbers) {
        int max = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) max = numbers[i];
        }
        return max;
    }


    public static int minimumIn(int[] numbers) {
        int min = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < min) min = numbers[i];
        }
        return min;
    }


    public static int sumOf(int[] numbers) {
        int sum = 0;
        for (int number : numbers) sum += number;
        return sum;
    }


    public static int sumOfEvenNumbersIn(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            if (number % 2 == 0) sum += number;
        }
        return sum;
    }


    public static int sumOfOddNumbersIn(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            if (number % 2 != 0) sum += number;
        }
        return sum;
    }

    public static int[] maximumAndMinimumOf(int[] numbers) {
        int min = numbers[0];
        int max = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < min) min = numbers[i];
            if (numbers[i] > max) max = numbers[i];
        }
        return new int[]{min, max};
    }


    public static int noOfOddNumbersIn(int[] numbers) {
        int count = 0;
        for (int number : numbers) {
            if (number % 2 != 0) count++;
        }
        return count;
    }

    public static int noOfEvenNumbersIn(int[] numbers) {
        int count = 0;
        for (int number : numbers) {
            if (number % 2 == 0) count++;
        }
        return count;
    }


    public static int[] evenNumbersIn(int[] numbers) {
        int count = noOfEvenNumbersIn(numbers);
        int[] evens = new int[count];
        int index = 0;
        for (int number : numbers) {
            if (number % 2 == 0) evens[index++] = number;
        }
        return evens;
    }

    public static int[] oddNumbersIn(int[] numbers) {
        int count = noOfOddNumbersIn(numbers);
        int[] odds = new int[count];
        int index = 0;
        for (int number : numbers) {
            if (number % 2 != 0) odds[index++] = number;
        }
        return odds;
    }


    public static int[] squareNumbersIn(int[] numbers) {
        int count = 0;
        for (int number : numbers) {
            int sqrt = (int) Math.sqrt(number);
            if (number >= 0 && sqrt * sqrt == number) count++;
        }
        int[] squares = new int[count];
        int index = 0;
        for (int number : numbers) {
            int sqrt = (int) Math.sqrt(number);
            if (number >= 0 && sqrt * sqrt == number) squares[index++] = number;
        }
        return squares;
    }


    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 16, 25};

        System.out.println("Array         : " + Arrays.toString(numbers));
        System.out.println("Maximum       : " + maximumIn(numbers));
        System.out.println("Minimum       : " + minimumIn(numbers));
        System.out.println("Sum           : " + sumOf(numbers));
        System.out.println("Sum of evens  : " + sumOfEvenNumbersIn(numbers));
        System.out.println("Sum of odds   : " + sumOfOddNumbersIn(numbers));
        System.out.println("Min and Max   : " + Arrays.toString(maximumAndMinimumOf(numbers)));
        System.out.println("No of odds    : " + noOfOddNumbersIn(numbers));
        System.out.println("No of evens   : " + noOfEvenNumbersIn(numbers));
        System.out.println("Even numbers  : " + Arrays.toString(evenNumbersIn(numbers)));
        System.out.println("Odd numbers   : " + Arrays.toString(oddNumbersIn(numbers)));
        System.out.println("Square numbers: " + Arrays.toString(squareNumbersIn(numbers)));
    }
}
