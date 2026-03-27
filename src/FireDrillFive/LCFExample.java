package src.FireDrillFive;

import java.util.Arrays;

public class LCFExample {

    public static int[] getPrimeFactors(int number) {

        int temp = number;
        int count = 0;

        for (int i = 2; i <= temp; i++) {
            while (temp % i == 0) {
                count++;
                temp /= i;
            }
        }

        int[] factors = new int[count];

        int index = 0;
        temp = number;

        for (int i = 2; i <= temp; i++) {
            while (temp % i == 0) {
                factors[index] = i;
                index++;
                temp /= i;
            }
        }

        return factors;
    }

    public static void main(String[] args) {

        int[] factors20 = getPrimeFactors(20);
        int[] factors30 = getPrimeFactors(30);

        System.out.println("20 → " + Arrays.toString(factors20));
        System.out.println("30 → " + Arrays.toString(factors30));
    }
}