package test;

import org.junit.Test;
import static org.junit.Assert.*;
import src.WeekOneAssignment.Kata;

public class KataTest {


    @Test
    public void testIsEven() {
        assertTrue(Kata.isEven(4));
        assertTrue(Kata.isEven(0));
        assertTrue(Kata.isEven(-8));
        assertFalse(Kata.isEven(7));
        assertFalse(Kata.isEven(-3));
    }


    @Test
    public void testIsPrimeNumber() {
        assertTrue(Kata.isPrimeNumber(2));
        assertTrue(Kata.isPrimeNumber(7));
        assertTrue(Kata.isPrimeNumber(13));
        assertFalse(Kata.isPrimeNumber(1));
        assertFalse(Kata.isPrimeNumber(0));
        assertFalse(Kata.isPrimeNumber(-5));
        assertFalse(Kata.isPrimeNumber(10));
    }


    @Test
    public void testSubtract() {
        assertEquals(4, Kata.subtract(3, 7));
        assertEquals(4, Kata.subtract(7, 3));
        assertEquals(0, Kata.subtract(5, 5));
        assertEquals(10, Kata.subtract(0, 10));
        assertEquals(3, Kata.subtract(-1, 2));
    }


    @Test
    public void testDivide() {
        assertEquals(2.5f,  Kata.divide(10, 4),  0.0001f);
        assertEquals(0.0f,  Kata.divide(10, 0),  0.0001f);
        assertEquals(5.0f,  Kata.divide(10, 2),  0.0001f);
        assertEquals(-2.5f, Kata.divide(-10, 4), 0.0001f);
        assertEquals(0.0f,  Kata.divide(0, 5),   0.0001f);
    }


    @Test
    public void testFactorOf() {
        assertEquals(4, Kata.factorOf(10));
        assertEquals(6, Kata.factorOf(12));
        assertEquals(1, Kata.factorOf(1));
        assertEquals(2, Kata.factorOf(7));
        assertEquals(3, Kata.factorOf(4));
    }


    @Test
    public void testIsSquare() {
        assertTrue(Kata.isSquare(25));
        assertTrue(Kata.isSquare(1));
        assertTrue(Kata.isSquare(0));
        assertTrue(Kata.isSquare(144));
        assertFalse(Kata.isSquare(20));
        assertFalse(Kata.isSquare(-4));
    }


    @Test
    public void testIsPalindrome() {
        assertTrue(Kata.isPalindrome(54145));
        assertTrue(Kata.isPalindrome(12321));
        assertTrue(Kata.isPalindrome(11111));
        assertFalse(Kata.isPalindrome(12345));
        assertFalse(Kata.isPalindrome(54321));
    }


    @Test
    public void testFactorialOf() {
        assertEquals(1L,       Kata.factorialOf(0));
        assertEquals(1L,       Kata.factorialOf(1));
        assertEquals(120L,     Kata.factorialOf(5));
        assertEquals(3628800L, Kata.factorialOf(10));
        assertEquals(2L,       Kata.factorialOf(2));
        assertEquals(6L,       Kata.factorialOf(3));
    }

    @Test
    public void testSquareOf() {
        assertEquals(25L,  Kata.squareOf(5));
        assertEquals(144L, Kata.squareOf(12));
        assertEquals(0L,   Kata.squareOf(0));
        assertEquals(1L,   Kata.squareOf(1));
        assertEquals(4L,   Kata.squareOf(-2));
    }
}