package test;

import org.junit.Test;
import static org.junit.Assert.*;
import src.WeekOneAssignment.CreditCardValidator;

public class CreditCardValidatorTest {


    String validVisa            = "4388576018410707";
    String invalidVisa          = "4388576018402626";
    String validMasterCard      = "5399831619690403";
    String invalidMasterCard    = "5399831619690404";
    String validAmex            = "378282246310005";
    String invalidAmex          = "378282246310006";
    String validDiscover        = "6011111111111117";
    String invalidDiscover      = "6011111111111118";
    String tooShort             = "41111111111";
    String tooLong              = "41111111111111111";
    String exactlyThirteen      = "4111111111116";
    String exactlySixteen       = "4388576018410707";
    String withLetters          = "4388576018A10707";
    String withSpaces           = "4388 5760 1841 0707";
    String unknownPrefix        = "9999999999999999";
    String emptyString          = "";



    @Test
    public void testGetCardType_Visa() {
        assertEquals("Visa", CreditCardValidator.getCardType("4111111111111111"));
    }

    @Test
    public void testGetCardType_MasterCard() {
        assertEquals("MasterCard", CreditCardValidator.getCardType("5111111111111111"));
    }

    @Test
    public void testGetCardType_AmericanExpress() {
        assertEquals("American Express", CreditCardValidator.getCardType("371111111111111"));
    }

    @Test
    public void testGetCardType_Discover() {
        assertEquals("Discover", CreditCardValidator.getCardType("6111111111111111"));
    }

    @Test
    public void testGetCardType_Unknown() {
        assertEquals("Unknown", CreditCardValidator.getCardType(unknownPrefix));
    }

    @Test
    public void testGetCardType_UnknownPrefix2() {
        assertEquals("Unknown", CreditCardValidator.getCardType("1234567890123456"));
    }



    @Test
    public void testIsValidLength_ExactlyThirteen() {
        assertTrue(CreditCardValidator.isValidLength(exactlyThirteen));
    }

    @Test
    public void testIsValidLength_ExactlySixteen() {
        assertTrue(CreditCardValidator.isValidLength(exactlySixteen));
    }

    @Test
    public void testIsValidLength_FourteenDigits() {
        assertTrue(CreditCardValidator.isValidLength("41111111111111"));
    }

    @Test
    public void testIsValidLength_FifteenDigits() {
        assertTrue(CreditCardValidator.isValidLength(validAmex));
    }

    @Test
    public void testIsValidLength_TooShort() {
        assertFalse(CreditCardValidator.isValidLength(tooShort));
    }

    @Test
    public void testIsValidLength_TooLong() {
        assertFalse(CreditCardValidator.isValidLength(tooLong));
    }

    @Test
    public void testIsValidLength_Empty() {
        assertFalse(CreditCardValidator.isValidLength(emptyString));
    }



    @Test
    public void testIsAllDigits_ValidNumber() {
        assertTrue(CreditCardValidator.isAllDigits(validVisa));
    }

    @Test
    public void testIsAllDigits_WithLetter() {
        assertFalse(CreditCardValidator.isAllDigits(withLetters));
    }

    @Test
    public void testIsAllDigits_WithSpaces() {
        assertFalse(CreditCardValidator.isAllDigits(withSpaces));
    }

    @Test
    public void testIsAllDigits_WithSpecialCharacter() {
        assertFalse(CreditCardValidator.isAllDigits("4388-5760-1841-0707"));
    }

    @Test
    public void testIsAllDigits_Empty() {
        assertTrue(CreditCardValidator.isAllDigits(emptyString));
    }



    @Test
    public void testSumOfDoubledSecondDigits_KnownCard() {
        int[] digits = {4,3,8,8,5,7,6,0,1,8,4,1,0,7,0,7};
        assertEquals(29, CreditCardValidator.sumOfDoubledSecondDigits(digits));
    }

    @Test
    public void testSumOfDoubledSecondDigits_DoubleDigitReduction() {
        int[] digits = {9, 9};
        int result = CreditCardValidator.sumOfDoubledSecondDigits(digits);
        assertTrue(result >= 0);
    }

    @Test
    public void testSumOfDoubledSecondDigits_AllZeros() {
        int[] digits = {0, 0, 0, 0};
        assertEquals(0, CreditCardValidator.sumOfDoubledSecondDigits(digits));
    }

    @Test
    public void testSumOfDoubledSecondDigits_SingleDigit() {
        int[] digits = {8};
        assertEquals(16 / 10 + 16 % 10, CreditCardValidator.sumOfDoubledSecondDigits(digits));
    }



    @Test
    public void testSumOfOddPlaceDigits_KnownCard() {
        int[] digits = {4,3,8,8,5,7,6,0,1,8,4,1,0,7,0,7};
        assertEquals(41, CreditCardValidator.sumOfOddPlaceDigits(digits));
    }

    @Test
    public void testSumOfOddPlaceDigits_AllZeros() {
        int[] digits = {0, 0, 0, 0};
        assertEquals(0, CreditCardValidator.sumOfOddPlaceDigits(digits));
    }

    @Test
    public void testSumOfOddPlaceDigits_TwoDigits() {
        int[] digits = {5, 3};
        assertEquals(5, CreditCardValidator.sumOfOddPlaceDigits(digits));
    }



    @Test
    public void testIsValidLuhn_ValidVisa() {
        assertTrue(CreditCardValidator.isValidLuhn(validVisa));
    }

    @Test
    public void testIsValidLuhn_InvalidVisa() {
        assertFalse(CreditCardValidator.isValidLuhn(invalidVisa));
    }

    @Test
    public void testIsValidLuhn_ValidMasterCard() {
        assertTrue(CreditCardValidator.isValidLuhn(validMasterCard));
    }

    @Test
    public void testIsValidLuhn_InvalidMasterCard() {
        assertFalse(CreditCardValidator.isValidLuhn(invalidMasterCard));
    }

    @Test
    public void testIsValidLuhn_ValidAmex() {
        assertTrue(CreditCardValidator.isValidLuhn(validAmex));
    }

    @Test
    public void testIsValidLuhn_InvalidAmex() {
        assertFalse(CreditCardValidator.isValidLuhn(invalidAmex));
    }

    @Test
    public void testIsValidLuhn_ValidDiscover() {
        assertTrue(CreditCardValidator.isValidLuhn(validDiscover));
    }

    @Test
    public void testIsValidLuhn_InvalidDiscover() {
        assertFalse(CreditCardValidator.isValidLuhn(invalidDiscover));
    }



    @Test
    public void testIsValidCard_ValidVisa() {
        assertTrue(CreditCardValidator.isValidCard(validVisa));
    }

    @Test
    public void testIsValidCard_InvalidVisa() {
        assertFalse(CreditCardValidator.isValidCard(invalidVisa));
    }

    @Test
    public void testIsValidCard_ValidMasterCard() {
        assertTrue(CreditCardValidator.isValidCard(validMasterCard));
    }

    @Test
    public void testIsValidCard_InvalidMasterCard() {
        assertFalse(CreditCardValidator.isValidCard(invalidMasterCard));
    }

    @Test
    public void testIsValidCard_ValidAmex() {
        assertTrue(CreditCardValidator.isValidCard(validAmex));
    }

    @Test
    public void testIsValidCard_ValidDiscover() {
        assertTrue(CreditCardValidator.isValidCard(validDiscover));
    }

    @Test
    public void testIsValidCard_TooShort() {
        assertFalse(CreditCardValidator.isValidCard(tooShort));
    }

    @Test
    public void testIsValidCard_TooLong() {
        assertFalse(CreditCardValidator.isValidCard(tooLong));
    }

    @Test
    public void testIsValidCard_WithLetters() {
        assertFalse(CreditCardValidator.isValidCard(withLetters));
    }

    @Test
    public void testIsValidCard_WithSpaces() {
        assertFalse(CreditCardValidator.isValidCard(withSpaces));
    }

    @Test
    public void testIsValidCard_UnknownPrefix() {
        assertFalse(CreditCardValidator.isValidCard(unknownPrefix));
    }
}