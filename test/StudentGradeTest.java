package test;

import org.junit.Test;
import static org.junit.Assert.*;
import src.WeekOneAssignment.StudentGrade;

public class StudentGradeTest {


    int[][] twoStudentsTwoSubjects = {
            {80, 70},
            {60, 50}
    };

    int[][] threeStudentsThreeSubjects = {
            {90, 80, 70},
            {60, 55, 45},
            {30, 40, 50}
    };

    int[][] allSameScores = {
            {50, 50},
            {50, 50},
            {50, 50}
    };

    int[][] oneStudentOneSubject = {
            {75}
    };

    int[][] allPassScores = {
            {100, 90},
            {80,  70},
            {60,  50}
    };

    int[][] allFailScores = {
            {10, 20},
            {30, 40},
            {15, 25}
    };

    int[][] mixedPassFail = {
            {100, 10},
            {20,  90},
            {50,  50}
    };



    @Test
    public void testStudentTotal_TwoScores() {
        assertEquals(150, StudentGrade.studentTotal(new int[]{80, 70}));
    }

    @Test
    public void testStudentTotal_ThreeScores() {
        assertEquals(240, StudentGrade.studentTotal(new int[]{90, 80, 70}));
    }

    @Test
    public void testStudentTotal_SingleScore() {
        assertEquals(75, StudentGrade.studentTotal(new int[]{75}));
    }

    @Test
    public void testStudentTotal_AllZeros() {
        assertEquals(0, StudentGrade.studentTotal(new int[]{0, 0, 0}));
    }

    @Test
    public void testStudentTotal_MaxScores() {
        assertEquals(300, StudentGrade.studentTotal(new int[]{100, 100, 100}));
    }



    @Test
    public void testStudentAverage_TwoScores() {
        assertEquals(75.0, StudentGrade.studentAverage(new int[]{80, 70}), 0.01);
    }

    @Test
    public void testStudentAverage_ThreeScores() {
        assertEquals(80.0, StudentGrade.studentAverage(new int[]{90, 80, 70}), 0.01);
    }

    @Test
    public void testStudentAverage_SingleScore() {
        assertEquals(75.0, StudentGrade.studentAverage(new int[]{75}), 0.01);
    }

    @Test
    public void testStudentAverage_AllZeros() {
        assertEquals(0.0, StudentGrade.studentAverage(new int[]{0, 0, 0}), 0.01);
    }

    @Test
    public void testStudentAverage_NonWholeNumber() {
        assertEquals(66.67, StudentGrade.studentAverage(new int[]{100, 50, 50}), 0.01);
    }



    @Test
    public void testAllStudentTotals_TwoStudents() {
        int[] expected = {150, 110};
        assertArrayEquals(expected, StudentGrade.allStudentTotals(twoStudentsTwoSubjects, 2));
    }

    @Test
    public void testAllStudentTotals_ThreeStudents() {
        int[] expected = {240, 160, 120};
        assertArrayEquals(expected, StudentGrade.allStudentTotals(threeStudentsThreeSubjects, 3));
    }

    @Test
    public void testAllStudentTotals_SingleStudent() {
        int[] expected = {75};
        assertArrayEquals(expected, StudentGrade.allStudentTotals(oneStudentOneSubject, 1));
    }

    @Test
    public void testAllStudentTotals_AllSameScores() {
        int[] expected = {100, 100, 100};
        assertArrayEquals(expected, StudentGrade.allStudentTotals(allSameScores, 3));
    }



    @Test
    public void testAllStudentPositions_TwoStudents() {
        int[] totals   = {150, 110};
        int[] expected = {1, 2};
        assertArrayEquals(expected, StudentGrade.allStudentPositions(totals, 2));
    }

    @Test
    public void testAllStudentPositions_ThreeStudents() {
        int[] totals   = {240, 160, 120};
        int[] expected = {1, 2, 3};
        assertArrayEquals(expected, StudentGrade.allStudentPositions(totals, 3));
    }

    @Test
    public void testAllStudentPositions_TiedScores() {
        int[] totals   = {100, 100, 100};
        int[] expected = {1, 1, 1};
        assertArrayEquals(expected, StudentGrade.allStudentPositions(totals, 3));
    }

    @Test
    public void testAllStudentPositions_SingleStudent() {
        int[] totals   = {75};
        int[] expected = {1};
        assertArrayEquals(expected, StudentGrade.allStudentPositions(totals, 1));
    }

    @Test
    public void testAllStudentPositions_ReverseOrder() {
        int[] totals   = {120, 160, 240};
        int[] expected = {3, 2, 1};
        assertArrayEquals(expected, StudentGrade.allStudentPositions(totals, 3));
    }



    @Test
    public void testTotalsAndPositions_ThreeStudents() {
        int[] totals    = StudentGrade.allStudentTotals(threeStudentsThreeSubjects, 3);
        int[] positions = StudentGrade.allStudentPositions(totals, 3);

        assertArrayEquals(new int[]{240, 160, 120}, totals);
        assertArrayEquals(new int[]{1, 2, 3},       positions);
    }

    @Test
    public void testTotalsAndPositions_AllSameScores() {
        int[] totals    = StudentGrade.allStudentTotals(allSameScores, 3);
        int[] positions = StudentGrade.allStudentPositions(totals, 3);

        assertArrayEquals(new int[]{100, 100, 100}, totals);
        assertArrayEquals(new int[]{1, 1, 1},       positions);
    }

    @Test
    public void testTotalsAndPositions_AllPassScores() {
        int[] totals    = StudentGrade.allStudentTotals(allPassScores, 3);
        int[] positions = StudentGrade.allStudentPositions(totals, 3);

        assertArrayEquals(new int[]{190, 150, 110}, totals);
        assertArrayEquals(new int[]{1, 2, 3},       positions);
    }

    @Test
    public void testTotalsAndPositions_AllFailScores() {
        int[] totals    = StudentGrade.allStudentTotals(allFailScores, 3);
        int[] positions = StudentGrade.allStudentPositions(totals, 3);

        assertArrayEquals(new int[]{30, 70, 40}, totals);
        assertArrayEquals(new int[]{3, 1, 2},    positions);
    }

    @Test
    public void testTotalsAndPositions_MixedPassFail() {
        int[] totals    = StudentGrade.allStudentTotals(mixedPassFail, 3);
        int[] positions = StudentGrade.allStudentPositions(totals, 3);

        assertArrayEquals(new int[]{110, 110, 100}, totals);
        assertArrayEquals(new int[]{1, 1, 3},       positions);
    }
}