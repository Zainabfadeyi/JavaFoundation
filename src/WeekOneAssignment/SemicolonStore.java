package src.WeekOneAssignment;

import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SemicolonStore {

    static String[] itemNames    = new String[100];
    static int[]    itemQty      = new int[100];
    static double[] itemPrice    = new double[100];
    static double[] itemTotal    = new double[100];
    static int      itemCount    = 0;

    static final double VAT_RATE      = 0.075;
    static final String STORE_NAME    = "MAIN BRANCH";
    static final String STORE_ADDRESS = "312, HERBERT MACAULAY WAY, SABO YABA, LAGOS.";
    static final String STORE_TEL     = "TEL: 03293828343";
    static final String DIVIDER       = "ニニニニニニニニニニニニニニニニニニニニニニニニニニニニニニニニニニニニニ";
    static final String HALF_DIVIDER  = "ニニニニニニニニニニニニニニニニニニ";


    public static void addItem(String name, int qty, double price) {
        itemNames[itemCount] = name;
        itemQty[itemCount]   = qty;
        itemPrice[itemCount] = price;
        itemTotal[itemCount] = qty * price;
        itemCount++;
    }


    public static double calculateSubTotal() {
        double subTotal = 0;
        for (int i = 0; i < itemCount; i++) {
            subTotal += itemTotal[i];
        }
        return subTotal;
    }


    public static double calculateVAT(double subTotal, double discount) {
        return (subTotal - discount) * VAT_RATE;
    }


    public static double calculateBillTotal(double subTotal, double discount, double vat) {
        return (subTotal - discount) + vat;
    }

    public static void resetCart() {
        itemNames  = new String[100];
        itemQty    = new int[100];
        itemPrice  = new double[100];
        itemTotal  = new double[100];
        itemCount  = 0;
    }

    public static void printInvoice(String customerName, String cashierName, double discount) {
        double subTotal  = calculateSubTotal();
        double vat       = calculateVAT(subTotal, discount);
        double billTotal = calculateBillTotal(subTotal, discount, vat);

        LocalDateTime now       = LocalDateTime.now();
        DateTimeFormatter fmt   = DateTimeFormatter.ofPattern("dd-MMM-yy h:mm:ss a");
        String dateTime         = now.format(fmt);

        System.out.println();
        System.out.println("          " + STORE_NAME);
        System.out.println("  " + STORE_ADDRESS);
        System.out.println("            " + STORE_TEL);
        System.out.println("Date: " + dateTime);
        System.out.println("Cashier: " + cashierName);
        System.out.println("Customer Name: " + customerName);
        System.out.println(DIVIDER);
        System.out.printf("%-20s %5s %10s %15s%n", "ITEM", "QTY", "PRICE", "TOTAL (NGN)");
        System.out.println(DIVIDER);

        for (int i = 0; i < itemCount; i++) {
            System.out.printf("%-20s %5d %10.2f %15.2f%n",
                    itemNames[i], itemQty[i], itemPrice[i], itemTotal[i]);
        }

        System.out.println(DIVIDER);
        System.out.printf("%-35s %15.2f%n", "Sub Total:",  subTotal);
        System.out.printf("%-35s %15.2f%n", "Discount:",   discount);
        System.out.printf("%-35s %15.2f%n", "VAT @ 7.50%:", vat);
        System.out.println(DIVIDER);
        System.out.printf("%-35s %15.2f%n", "Bill Total:", billTotal);
        System.out.println();
        System.out.println("S-----");
        System.out.println("        THIS IS NOT AN");
        System.out.println(HALF_DIVIDER + "=");
        System.out.printf("   RECEIPT KINDLY PAY %.2f%n", billTotal);
        System.out.println(DIVIDER);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("What is the customer's Name? ");
        String customerName = scanner.nextLine().trim();

        boolean addMore = true;
        while (addMore) {
            System.out.print("What did the user buy? ");
            String productName = scanner.nextLine().trim();

            System.out.print("How many pieces? ");
            int qty = scanner.nextInt();

            System.out.print("How much per unit? ");
            double price = scanner.nextDouble();
            scanner.nextLine();

            addItem(productName, qty, price);

            System.out.print("Add more items? (yes/no): ");
            String response = scanner.nextLine().trim();
            addMore = response.equalsIgnoreCase("yes") || response.equalsIgnoreCase("y");
        }

        System.out.print("Cashier's Name: ");
        String cashierName = scanner.nextLine().trim();

        System.out.print("How much discount will the customer get? ");
        double discount = scanner.nextDouble();
        scanner.nextLine();

        printInvoice(customerName, cashierName, discount);

        double subTotal  = calculateSubTotal();
        double vat       = calculateVAT(subTotal, discount);
        double billTotal = calculateBillTotal(subTotal, discount, vat);

        System.out.print("How much did the customer give to you? ");
        double amountGiven = scanner.nextDouble();

        double change = amountGiven - billTotal;

        System.out.println();
        System.out.println(DIVIDER);
        if (change >= 0) {
            System.out.printf("  Change:  NGN %.2f%n", change);
        } else {
            System.out.printf("  Balance Owed:  NGN %.2f%n", Math.abs(change));
        }
        System.out.println(DIVIDER);
        System.out.println("       Thank you for shopping at");
        System.out.println("          Semicolon Store! 🛍");
        System.out.println(DIVIDER);

        scanner.close();
    }
}
