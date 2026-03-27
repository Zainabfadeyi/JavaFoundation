package test;

import org.junit.Test;
import src.FireDrillFive.Drill;

import static org.junit.Assert.assertArrayEquals;

public class DrillTest {

    @Test
    public void testFactorsOfNormalNumber() {
        int[] expected = {2, 3, 4, 6, 12};
        assertArrayEquals(expected, Drill.factorsOf(12));
    }


}