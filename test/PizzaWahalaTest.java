package test;

import org.junit.Test;
import src.WeekOneAssignment.PizzaWahala;

import static org.junit.Assert.*;

public class PizzaWahalaTest {

    private static final int BOXES        = 0;
    private static final int TOTAL_SLICES = 1;
    private static final int LEFTOVER     = 2;
    private static final int TOTAL_PRICE  = 3;

    @Test
    public void testSapa_ExactFit() {
        int[] result = PizzaWahala.calculateOrder(8, 1);
        assertEquals(2,    result[BOXES]);
        assertEquals(8,    result[TOTAL_SLICES]);
        assertEquals(0,    result[LEFTOVER]);
        assertEquals(5000, result[TOTAL_PRICE]);
    }

    @Test
    public void testSapa_WithLeftover() {
        int[] result = PizzaWahala.calculateOrder(5, 1);
        assertEquals(2,    result[BOXES]);
        assertEquals(8,    result[TOTAL_SLICES]);
        assertEquals(3,    result[LEFTOVER]);
        assertEquals(5000, result[TOTAL_PRICE]);
    }

    @Test
    public void testSmallMoney_ExactFit() {
        int[] result = PizzaWahala.calculateOrder(12, 2);
        assertEquals(2,    result[BOXES]);
        assertEquals(12,   result[TOTAL_SLICES]);
        assertEquals(0,    result[LEFTOVER]);
        assertEquals(5800, result[TOTAL_PRICE]);
    }

    @Test
    public void testSmallMoney_WithLeftover() {
        int[] result = PizzaWahala.calculateOrder(10, 2);
        assertEquals(2,    result[BOXES]);
        assertEquals(12,   result[TOTAL_SLICES]);
        assertEquals(2,    result[LEFTOVER]);
        assertEquals(5800, result[TOTAL_PRICE]);
    }

    @Test
    public void testBigBoys_ExactFit() {
        int[] result = PizzaWahala.calculateOrder(16, 3);
        assertEquals(2,    result[BOXES]);
        assertEquals(16,   result[TOTAL_SLICES]);
        assertEquals(0,    result[LEFTOVER]);
        assertEquals(8000, result[TOTAL_PRICE]);
    }

    @Test
    public void testBigBoys_WithLeftover() {
        int[] result = PizzaWahala.calculateOrder(15, 3);
        assertEquals(2,    result[BOXES]);
        assertEquals(16,   result[TOTAL_SLICES]);
        assertEquals(1,    result[LEFTOVER]);
        assertEquals(8000, result[TOTAL_PRICE]);
    }

    @Test
    public void testOdogwu_SampleFromBrief() {
        int[] result = PizzaWahala.calculateOrder(45, 4);
        assertEquals(4,     result[BOXES]);
        assertEquals(48,    result[TOTAL_SLICES]);
        assertEquals(3,     result[LEFTOVER]);
        assertEquals(20800, result[TOTAL_PRICE]);
    }

    @Test
    public void testOdogwu_ExactFit() {
        int[] result = PizzaWahala.calculateOrder(24, 4);
        assertEquals(2,     result[BOXES]);
        assertEquals(24,    result[TOTAL_SLICES]);
        assertEquals(0,     result[LEFTOVER]);
        assertEquals(10400, result[TOTAL_PRICE]);
    }

    @Test
    public void testOdogwu_WithLeftover() {
        int[] result = PizzaWahala.calculateOrder(25, 4);
        assertEquals(3,     result[BOXES]);
        assertEquals(36,    result[TOTAL_SLICES]);
        assertEquals(11,    result[LEFTOVER]);
        assertEquals(15600, result[TOTAL_PRICE]);
    }

    @Test
    public void testSingleGuest() {
        int[] result = PizzaWahala.calculateOrder(1, 4);
        assertEquals(1,    result[BOXES]);
        assertEquals(12,   result[TOTAL_SLICES]);
        assertEquals(11,   result[LEFTOVER]);
        assertEquals(5200, result[TOTAL_PRICE]);
    }

    @Test
    public void testLargeParty() {
        int[] result =PizzaWahala.calculateOrder(100, 4);
        assertEquals(9,     result[BOXES]);
        assertEquals(108,   result[TOTAL_SLICES]);
        assertEquals(8,     result[LEFTOVER]);
        assertEquals(46800, result[TOTAL_PRICE]);
    }
}