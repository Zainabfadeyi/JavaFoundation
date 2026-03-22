package src.WeekOneAssignment;

import java.util.Scanner;

public class PizzaWahala{

    static String[] pizzaNames   = {"Sapa", "Small Money", "Big Boys", "Odogwu"};
    static int[]    slicesPerBox = {4, 6, 8, 12};
    static int[]    pricePerBox  = {2500, 2900, 4000, 5200};

    // ─── Extracted logic — easy to test ──────────────────────────────────────
    public static int[] calculateOrder(int guests, int choice) {
        int index      = choice - 1;
        int slices     = slicesPerBox[index];
        int price      = pricePerBox[index];
        int boxes      = (int) Math.ceil((double) guests / slices);
        int totalSlices = boxes * slices;
        int leftover   = totalSlices - guests;
        int totalPrice = boxes * price;

        // returns [boxes, totalSlices, leftover, totalPrice]
        return new int[]{boxes, totalSlices, leftover, totalPrice};
    }

    // ─── Main — handles Scanner I/O only ─────────────────────────────────────
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of guests: ");
        int guests = scanner.nextInt();

        System.out.println();
        System.out.println("No  Type         Slices Price");
        for (int i = 0; i < pizzaNames.length; i++) {
            System.out.printf("%-3d %-12s %-6d %d%n",
                    (i + 1), pizzaNames[i], slicesPerBox[i], pricePerBox[i]);
        }

        System.out.print("Choose pizza type (1 - 4): ");
        int choice = scanner.nextInt();

        while (choice < 1 || choice > 4) {
            System.out.print("Invalid choice. Please enter a number between 1 and 4: ");
            choice = scanner.nextInt();
        }

        int[] result = calculateOrder(guests, choice);

        System.out.println();
        System.out.println("ORDER SUMMARY");
        System.out.println("Pizza Type     : " + pizzaNames[choice - 1]);
        System.out.println("Guests         : " + guests);
        System.out.println("Slices per box : " + slicesPerBox[choice - 1]);
        System.out.println("Boxes to buy   : " + result[0]);
        System.out.println("Total slices   : " + result[1]);
        System.out.println("Leftover slices: " + result[2]);
        System.out.println("Price per box  : " + pricePerBox[choice - 1]);
        System.out.println("TOTAL PRICE    : " + result[3]);

        scanner.close();
    }
}