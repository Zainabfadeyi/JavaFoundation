package src.WeekOneAssignment;

public class BackToSenderLogistics {

    public static int calculateRiderWage(int successfulDeliveries) {
        final int BASE_PAY = 5000;
        final int TOTAL_PACKAGES = 100;

        double collectionRate = (successfulDeliveries / (double) TOTAL_PACKAGES) * 100;

        int amountPerParcel;

        if (collectionRate < 50) {
            amountPerParcel = 160;
        } else if (collectionRate <= 59) {
            amountPerParcel = 200;
        } else if (collectionRate <= 69) {
            amountPerParcel = 250;
        } else {
            amountPerParcel = 500;
        }

        return successfulDeliveries * amountPerParcel + BASE_PAY;
    }

    public static void main(String[] args) {
        System.out.println(calculateRiderWage(80));
        System.out.println(calculateRiderWage(25));  
    }
}
