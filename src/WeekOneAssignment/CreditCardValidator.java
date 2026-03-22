package src.WeekOneAssignment;

import java.util.Scanner;

public class CreditCardValidator {
    public static String getCardType(String cardNumber) {
        if (cardNumber.startsWith("4"))  return "Visa";
        if (cardNumber.startsWith("5"))  return "MasterCard";
        if (cardNumber.startsWith("37")) return "American Express";
        if (cardNumber.startsWith("6"))  return "Discover";
        return "Unknown";
    }

    public static boolean isValidLength(String cardNumber) {
        int length = cardNumber.length();
        return length >= 13 && length <= 16;
    }


    public static boolean isAllDigits(String cardNumber) {
        for (int i = 0; i < cardNumber.length(); i++) {
            if (!Character.isDigit(cardNumber.charAt(i))) return false;
        }
        return true;
    }


    public static int sumOfDoubledSecondDigits(int[] digits) {
        int sum = 0;
        boolean doubleIt = true;

        for (int i = digits.length - 1; i >= 0; i--) {
            if (doubleIt) {
                int doubled = digits[i] * 2;
                if (doubled > 9) {
                    doubled = (doubled / 10) + (doubled % 10);
                }
                sum += doubled;
            }
            doubleIt = !doubleIt;
        }
        return sum;
    }


    public static int sumOfOddPlaceDigits(int[] digits) {
        int sum = 0;
        boolean addIt = true;

        for (int i = digits.length - 1; i >= 0; i--) {
            if (!addIt) {
                sum += digits[i];
            }
            addIt = !addIt;
        }
        return sum;
    }


    public static boolean isValidLuhn(String cardNumber) {
        int[] digits = new int[cardNumber.length()];
        for (int i = 0; i < cardNumber.length(); i++) {
            digits[i] = cardNumber.charAt(i) - '0';
        }

        int sumDoubled = sumOfDoubledSecondDigits(digits);
        int sumOdd     = sumOfOddPlaceDigits(digits);

        return (sumDoubled + sumOdd) % 10 == 0;
    }


    public static boolean isValidCard(String cardNumber) {
        return isAllDigits(cardNumber)
                && isValidLength(cardNumber)
                && !getCardType(cardNumber).equals("Unknown")
                && isValidLuhn(cardNumber);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Hello, Kindly Enter Card details to verify: ");
        String cardNumber = scanner.nextLine().trim();

        System.out.println();

        if (!isAllDigits(cardNumber)) {
            System.out.println("Invalid Input: Card number must contain digits only.");
            scanner.close();
            return;
        }

        if (!isValidLength(cardNumber)) {
            System.out.println("Invalid Input: Card number must be between 13 and 16 digits.");
            System.out.println("Digit Length Entered: " + cardNumber.length());
            scanner.close();
            return;
        }

        String cardType = getCardType(cardNumber);

        if (cardType.equals("Unknown")) {
            System.out.println("Invalid Input: Unrecognised card prefix.");
            scanner.close();
            return;
        }

        String validityStatus = isValidLuhn(cardNumber) ? "Valid" : "Invalid";

        System.out.println("Credit Card Type            : " + cardType);
        System.out.println("Credit Card Number          : " + cardNumber);
        System.out.println("Credit Card Digit Length    : " + cardNumber.length());
        System.out.println("Credit Card Validity Status : " + validityStatus);

        scanner.close();
    }
}
