package src.FireDrillFour;

import java.util.Scanner;

public class MorningDrill {

    static String[] ones = {
            "", "one", "two", "three", "four",
            "five", "six", "seven", "eight", "nine",
            "ten", "eleven", "twelve", "thirteen", "fourteen",
            "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
    };

    static String[] tens = {
            "", "", "twenty", "thirty", "forty",
            "fifty", "sixty", "seventy", "eighty", "ninety"
    };

    public static String convert(int num) {
        if (num == 0) return "zero";
        if (num == 1000000) return "one million";

        String result = "";


        if (num >= 1000) {
            result += convertBelowThousand(num / 1000) + " thousand ";
            num %= 1000;
        }


        if (num > 0) {
            result += convertBelowThousand(num);
        }

        return result.trim();
    }

    private static String convertBelowThousand(int num) {
        String result = "";


        if (num >= 100) {
            result += ones[num / 100] + " hundred ";
            num %= 100;
        }


        if (num >= 20) {
            result += tens[num / 10] + " ";
            num %= 10;
        }

        if (num > 0) {
            result += ones[num] + " ";
        }

        return result.trim();
    }

    public static void main(String[] args) {
        System.out.println(convert(1));        // one
        System.out.println(convert(15));       // fifteen
        System.out.println(convert(50));       // fifty
        System.out.println(convert(123));      // one hundred twenty three
        System.out.println(convert(1005));     // one thousand five
        System.out.println(convert(123456));   // one hundred twenty three thousand four hundred fifty six
        System.out.println(convert(1000000));  // one million
    }

}
