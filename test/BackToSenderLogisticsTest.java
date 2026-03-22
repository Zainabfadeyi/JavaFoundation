package test;

import org.junit.Test;
import src.WeekOneAssignment.BackToSenderLogistics;

import static org.junit.Assert.assertEquals;

public class BackToSenderLogisticsTest {

    private void test(int input, int expected, String label) {
        int result = BackToSenderLogistics.calculateRiderWage(input);
        assertEquals(label, expected, result);
    }

    @Test
    public void logisticsTest() {


        test(80, 45000, "Sample 1 – 80 deliveries (>=70%)");
        test(25,  9000, "Sample 2 – 25 deliveries (<50%)");


        test( 0,  5000, "<50%  –  0 deliveries");
        test(30,  9800, "<50%  – 30 deliveries");
        test(49, 12840, "<50%  – 49 deliveries");


        test(50, 15000, "50-59% – 50 deliveries");
        test(55, 16000, "50-59% – 55 deliveries");
        test(59, 16800, "50-59% – 59 deliveries");

        test(60, 20000, "60-69% – 60 deliveries");
        test(65, 21250, "60-69% – 65 deliveries");
        test(69, 22250, "60-69% – 69 deliveries");


        test( 70, 40000, ">=70% –  70 deliveries");
        test(100, 55000, ">=70% – 100 deliveries");
    }
}