package test;

import org.junit.Test;
import src.FireDrillFive.LCMCalculator;

import static org.junit.Assert.*;

public class LCMCalculatorTest {


    @Test
    public void testGcd_CommonCase() {
        assertEquals(2, LCMCalculator.lcmGcd(4, 6));
    }

    @Test
    public void testGcd_SameNumbers() {
        assertEquals(5, LCMCalculator.lcmGcd(5, 5));
    }

    @Test
    public void testGcd_OneIsOne() {
        assertEquals(1, LCMCalculator.lcmGcd(1, 9));
    }

    @Test
    public void testGcd_Coprime() {
        assertEquals(1, LCMCalculator.lcmGcd(7, 13));
    }

    @Test
    public void testGcd_OneIsMultipleOfOther() {
        assertEquals(4, LCMCalculator.lcmGcd(4, 8));
    }

    @Test
    public void testGcd_LargeNumbers() {
        assertEquals(12, LCMCalculator.lcmGcd(144, 60));
    }



    @Test
    public void testLcm_CommonCase() {
        assertEquals(12, LCMCalculator.lcm(4, 6));
    }

    @Test
    public void testLcm_SameNumbers() {
        assertEquals(5, LCMCalculator.lcm(5, 5));
    }

    @Test
    public void testLcm_OneIsOne() {
        assertEquals(9, LCMCalculator.lcm(1, 9));
    }

    @Test
    public void testLcm_Coprime() {
        assertEquals(91, LCMCalculator.lcm(7, 13));
    }

    @Test
    public void testLcm_OneIsMultipleOfOther() {
        assertEquals(8, LCMCalculator.lcm(4, 8));
    }

    @Test
    public void testLcm_LargeNumbers() {
        assertEquals(720, LCMCalculator.lcm(144, 60));
    }


    // ─── lcmOfArray ───────────────────────────────────────────────────────────
    @Test
    public void testLcmOfArray_SampleInput() {
        assertEquals(24, LCMCalculator.lcmOfArray(new int[]{4, 6, 8}));
    }

    @Test
    public void testLcmOfArray_AllSameNumbers() {
        assertEquals(5, LCMCalculator.lcmOfArray(new int[]{5, 5, 5}));
    }

    @Test
    public void testLcmOfArray_IncludesOne() {
        assertEquals(12, LCMCalculator.lcmOfArray(new int[]{1, 4, 12}));
    }

    @Test
    public void testLcmOfArray_CoprimeNumbers() {
        assertEquals(105, LCMCalculator.lcmOfArray(new int[]{3, 5, 7}));
    }

    @Test
    public void testLcmOfArray_ConsecutiveNumbers() {
        assertEquals(6, LCMCalculator.lcmOfArray(new int[]{1, 2, 3}));
    }

    @Test
    public void testLcmOfArray_MultipleOfEachOther() {
        assertEquals(12, LCMCalculator.lcmOfArray(new int[]{2, 4, 12}));
    }

    @Test
    public void testLcmOfArray_LargeNumbers() {
        assertEquals(360, LCMCalculator.lcmOfArray(new int[]{8, 9, 40}));
    }

    @Test
    public void testLcmOfArray_SingleElement() {
        assertEquals(7, LCMCalculator.lcmOfArray(new int[]{7}));
    }

    @Test
    public void testLcmOfArray_AllOnes() {
        assertEquals(1, LCMCalculator.lcmOfArray(new int[]{1, 1, 1}));
    }
}