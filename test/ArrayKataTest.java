package test;


import org.junit.Test;
import static org.junit.Assert.*;
import src.WeekOneAssignment.ArrayKata;

public class ArrayKataTest {

    int[] numbers       = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 16, 25};
    int[] allEvens      = {2, 4, 6, 8, 10};
    int[] allOdds       = {1, 3, 5, 7, 9};
    int[] allSquares    = {1, 4, 9, 16, 25};
    int[] singleElement = {42};
    int[] negatives     = {-5, -3, -1, 0, 1, 3, 5};
    int[] duplicates    = {4, 4, 4, 4};


    @Test
    public void testMaximumIn_MixedArray() {
        assertEquals(25, ArrayKata.maximumIn(numbers));
    }

    @Test
    public void testMaximumIn_SingleElement() {
        assertEquals(42, ArrayKata.maximumIn(singleElement));
    }

    @Test
    public void testMaximumIn_WithNegatives() {
        assertEquals(5, ArrayKata.maximumIn(negatives));
    }

    @Test
    public void testMaximumIn_Duplicates() {
        assertEquals(4, ArrayKata.maximumIn(duplicates));
    }


    @Test
    public void testMinimumIn_MixedArray() {
        assertEquals(1, ArrayKata.minimumIn(numbers));
    }

    @Test
    public void testMinimumIn_SingleElement() {
        assertEquals(42, ArrayKata.minimumIn(singleElement));
    }

    @Test
    public void testMinimumIn_WithNegatives() {
        assertEquals(-5, ArrayKata.minimumIn(negatives));
    }

    @Test
    public void testMinimumIn_Duplicates() {
        assertEquals(4, ArrayKata.minimumIn(duplicates));
    }


    @Test
    public void testSumOf_MixedArray() {
        assertEquals(96, ArrayKata.sumOf(numbers));
    }

    @Test
    public void testSumOf_SingleElement() {
        assertEquals(42, ArrayKata.sumOf(singleElement));
    }

    @Test
    public void testSumOf_AllEvens() {
        assertEquals(30, ArrayKata.sumOf(allEvens));
    }

    @Test
    public void testSumOf_AllOdds() {
        assertEquals(25, ArrayKata.sumOf(allOdds));
    }

    @Test
    public void testSumOf_WithNegatives() {
        assertEquals(0, ArrayKata.sumOf(negatives));
    }


    @Test
    public void testSumOfEvenNumbersIn_MixedArray() {
        assertEquals(46, ArrayKata.sumOfEvenNumbersIn(numbers));
    }

    @Test
    public void testSumOfEvenNumbersIn_AllEvens() {
        assertEquals(30, ArrayKata.sumOfEvenNumbersIn(allEvens));
    }

    @Test
    public void testSumOfEvenNumbersIn_AllOdds() {
        assertEquals(0, ArrayKata.sumOfEvenNumbersIn(allOdds));
    }

    @Test
    public void testSumOfEvenNumbersIn_Duplicates() {
        assertEquals(16, ArrayKata.sumOfEvenNumbersIn(duplicates));
    }

    @Test
    public void testSumOfOddNumbersIn_MixedArray() {
        assertEquals(50, ArrayKata.sumOfOddNumbersIn(numbers));
    }

    @Test
    public void testSumOfOddNumbersIn_AllOdds() {
        assertEquals(25, ArrayKata.sumOfOddNumbersIn(allOdds));
    }

    @Test
    public void testSumOfOddNumbersIn_AllEvens() {
        assertEquals(0, ArrayKata.sumOfOddNumbersIn(allEvens));
    }

    @Test
    public void testSumOfOddNumbersIn_Duplicates() {
        assertEquals(0, ArrayKata.sumOfOddNumbersIn(duplicates));
    }

    @Test
    public void testMaximumAndMinimumOf_MixedArray() {
        assertArrayEquals(new int[]{1, 25}, ArrayKata.maximumAndMinimumOf(numbers));
    }

    @Test
    public void testMaximumAndMinimumOf_SingleElement() {
        assertArrayEquals(new int[]{42, 42}, ArrayKata.maximumAndMinimumOf(singleElement));
    }

    @Test
    public void testMaximumAndMinimumOf_WithNegatives() {
        assertArrayEquals(new int[]{-5, 5}, ArrayKata.maximumAndMinimumOf(negatives));
    }

    @Test
    public void testMaximumAndMinimumOf_Duplicates() {
        assertArrayEquals(new int[]{4, 4}, ArrayKata.maximumAndMinimumOf(duplicates));
    }

    @Test
    public void testNoOfOddNumbersIn_MixedArray() {
        assertEquals(7, ArrayKata.noOfOddNumbersIn(numbers));
    }

    @Test
    public void testNoOfOddNumbersIn_AllOdds() {
        assertEquals(5, ArrayKata.noOfOddNumbersIn(allOdds));
    }

    @Test
    public void testNoOfOddNumbersIn_AllEvens() {
        assertEquals(0, ArrayKata.noOfOddNumbersIn(allEvens));
    }

    @Test
    public void testNoOfOddNumbersIn_Duplicates() {
        assertEquals(0, ArrayKata.noOfOddNumbersIn(duplicates));
    }

    @Test
    public void testNoOfEvenNumbersIn_MixedArray() {
        assertEquals(5, ArrayKata.noOfEvenNumbersIn(numbers));
    }

    @Test
    public void testNoOfEvenNumbersIn_AllEvens() {
        assertEquals(5, ArrayKata.noOfEvenNumbersIn(allEvens));
    }

    @Test
    public void testNoOfEvenNumbersIn_AllOdds() {
        assertEquals(0, ArrayKata.noOfEvenNumbersIn(allOdds));
    }

    @Test
    public void testNoOfEvenNumbersIn_Duplicates() {
        assertEquals(4, ArrayKata.noOfEvenNumbersIn(duplicates));
    }

    @Test
    public void testEvenNumbersIn_MixedArray() {
        assertArrayEquals(new int[]{2, 4, 6, 8, 10, 16}, ArrayKata.evenNumbersIn(numbers));
    }

    @Test
    public void testEvenNumbersIn_AllEvens() {
        assertArrayEquals(new int[]{2, 4, 6, 8, 10}, ArrayKata.evenNumbersIn(allEvens));
    }

    @Test
    public void testEvenNumbersIn_AllOdds() {
        assertArrayEquals(new int[]{}, ArrayKata.evenNumbersIn(allOdds));
    }

    @Test
    public void testEvenNumbersIn_Duplicates() {
        assertArrayEquals(new int[]{4, 4, 4, 4}, ArrayKata.evenNumbersIn(duplicates));
    }

    @Test
    public void testOddNumbersIn_MixedArray() {
        assertArrayEquals(new int[]{1, 3, 5, 7, 9, 25}, ArrayKata.oddNumbersIn(numbers));
    }

    @Test
    public void testOddNumbersIn_AllOdds() {
        assertArrayEquals(new int[]{1, 3, 5, 7, 9}, ArrayKata.oddNumbersIn(allOdds));
    }

    @Test
    public void testOddNumbersIn_AllEvens() {
        assertArrayEquals(new int[]{}, ArrayKata.oddNumbersIn(allEvens));
    }

    @Test
    public void testOddNumbersIn_Duplicates() {
        assertArrayEquals(new int[]{}, ArrayKata.oddNumbersIn(duplicates));
    }


    @Test
    public void testSquareNumbersIn_MixedArray() {
        assertArrayEquals(new int[]{1, 4, 9, 16, 25}, ArrayKata.squareNumbersIn(allSquares));
    }

    @Test
    public void testSquareNumbersIn_NoSquares() {
        assertArrayEquals(new int[]{}, ArrayKata.squareNumbersIn(new int[]{3, 5, 7, 11}));
    }

    @Test
    public void testSquareNumbersIn_IncludesZero() {
        assertArrayEquals(new int[]{0, 1, 4}, ArrayKata.squareNumbersIn(new int[]{0, 1, 2, 3, 4}));
    }

    @Test
    public void testSquareNumbersIn_AllSquares() {
        assertArrayEquals(new int[]{1, 4, 9, 16, 25}, ArrayKata.squareNumbersIn(allSquares));
    }

    @Test
    public void testSquareNumbersIn_WithNegatives() {
        assertArrayEquals(new int[]{1, 4}, ArrayKata.squareNumbersIn(new int[]{-4, -1, 1, 4}));
    }
}