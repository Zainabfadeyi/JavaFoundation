package test;

import org.junit.Test;
import org.junit.Before;
import src.FireDrillFive.AutomaticBike;

import static org.junit.Assert.*;

public class AutomaticBikeTest {

    AutomaticBike bike;

    @Before
    public void setUp() {
        bike = new AutomaticBike();
    }



    @Test
    public void testBikeIsOffByDefault() {
        assertFalse(bike.isOn());
    }

    @Test
    public void testBikeCanBeTurnedOn() {
        bike.turnOn();
        assertTrue(bike.isOn());
    }

    @Test
    public void testBikeCanBeTurnedOff() {
        bike.turnOn();
        bike.turnOff();
        assertFalse(bike.isOn());
    }

    @Test
    public void testBikeSpeedIsZeroWhenTurnedOn() {
        bike.turnOn();
        assertEquals(0, bike.getSpeed());
    }

    @Test
    public void testBikeSpeedResetsToZeroWhenTurnedOff() {
        bike.turnOn();
        bike.accelerate();
        bike.turnOff();
        assertEquals(0, bike.getSpeed());
    }

    @Test
    public void testBikeGearIsOneWhenTurnedOn() {
        bike.turnOn();
        assertEquals(1, bike.getGear());
    }


    // ─── Cannot accelerate or decelerate when off ─────────────────────────────
    @Test
    public void testCannotAccelerateWhenOff() {
        bike.accelerate();
        assertEquals(0, bike.getSpeed());
    }

    @Test
    public void testCannotDecelerateWhenOff() {
        bike.decelerate();
        assertEquals(0, bike.getSpeed());
    }



    @Test
    public void testGearOneOnStartup() {
        bike.turnOn();
        assertEquals(1, bike.getGear());
    }

    @Test
    public void testAccelerateOnGearOne_IncrementsBy1() {
        bike.turnOn();
        bike.setSpeed(15);
        bike.accelerate();
        assertEquals(16, bike.getSpeed());
    }

    @Test
    public void testDecelerateOnGearOne_DecrementsBy1() {
        bike.turnOn();
        bike.setSpeed(15);
        bike.decelerate();
        assertEquals(14, bike.getSpeed());
    }

    @Test
    public void testAccelerateOnGearOne_FromZero() {
        bike.turnOn();
        bike.accelerate();
        assertEquals(1, bike.getSpeed());
    }

    @Test
    public void testSpeedDoesNotGoBelowZero() {
        bike.turnOn();
        bike.decelerate();
        assertEquals(0, bike.getSpeed());
    }


    // ─── Gear 2: speed 21 - 30, increment/decrement of 2 ────────────────────
    @Test
    public void testGearChangesToTwoAt21() {
        bike.turnOn();
        bike.setSpeed(21);
        assertEquals(2, bike.getGear());
    }

    @Test
    public void testAccelerateOnGearTwo_IncrementsBy2() {
        bike.turnOn();
        bike.setSpeed(24);
        bike.accelerate();
        assertEquals(26, bike.getSpeed());
    }

    @Test
    public void testDecelerateOnGearTwo_DecrementsBy2() {
        bike.turnOn();
        bike.setSpeed(24);
        bike.decelerate();
        assertEquals(22, bike.getSpeed());
    }

    @Test
    public void testGearTwoAtUpperBoundary() {
        bike.turnOn();
        bike.setSpeed(30);
        assertEquals(2, bike.getGear());
    }


    // ─── Gear 3: speed 31 - 40, increment/decrement of 3 ────────────────────
    @Test
    public void testGearChangesToThreeAt31() {
        bike.turnOn();
        bike.setSpeed(31);
        assertEquals(3, bike.getGear());
    }

    @Test
    public void testAccelerateOnGearThree_IncrementsBy3() {
        bike.turnOn();
        bike.setSpeed(35);
        bike.accelerate();
        assertEquals(38, bike.getSpeed());
    }

    @Test
    public void testDecelerateOnGearThree_DecrementsBy3() {
        bike.turnOn();
        bike.setSpeed(35);
        bike.decelerate();
        assertEquals(32, bike.getSpeed());
    }

    @Test
    public void testGearThreeAtUpperBoundary() {
        bike.turnOn();
        bike.setSpeed(40);
        assertEquals(3, bike.getGear());
    }



    @Test
    public void testGearChangesToFourAt41() {
        bike.turnOn();
        bike.setSpeed(41);
        assertEquals(4, bike.getGear());
    }

    @Test
    public void testAccelerateOnGearFour_IncrementsBy4() {
        bike.turnOn();
        bike.setSpeed(44);
        bike.accelerate();
        assertEquals(48, bike.getSpeed());
    }

    @Test
    public void testDecelerateOnGearFour_DecrementsBy4() {
        bike.turnOn();
        bike.setSpeed(44);
        bike.decelerate();
        assertEquals(40, bike.getSpeed());
    }

    @Test
    public void testGearFourAtHighSpeed() {
        bike.turnOn();
        bike.setSpeed(100);
        assertEquals(4, bike.getGear());
    }



    @Test
    public void testGearShiftsUpFrom1To2OnAcceleration() {
        bike.turnOn();
        bike.setSpeed(20);
        bike.accelerate();
        assertEquals(21, bike.getSpeed());
        assertEquals(2,  bike.getGear());
    }

    @Test
    public void testGearShiftsUpFrom2To3OnAcceleration() {
        bike.turnOn();
        bike.setSpeed(30);
        bike.accelerate();
        assertEquals(32, bike.getSpeed());
        assertEquals(3,  bike.getGear());
    }

    @Test
    public void testGearShiftsUpFrom3To4OnAcceleration() {
        bike.turnOn();
        bike.setSpeed(40);
        bike.accelerate();
        assertEquals(43, bike.getSpeed());
        assertEquals(4,  bike.getGear());
    }



    @Test
    public void testGearShiftsDownFrom2To1OnDeceleration() {
        bike.turnOn();
        bike.setSpeed(21);
        bike.decelerate();
        assertEquals(19, bike.getSpeed());
        assertEquals(1,  bike.getGear());
    }

    @Test
    public void testGearShiftsDownFrom3To2OnDeceleration() {
        bike.turnOn();
        bike.setSpeed(31);
        bike.decelerate();
        assertEquals(28, bike.getSpeed());
        assertEquals(2,  bike.getGear());
    }

    @Test
    public void testGearShiftsDownFrom4To3OnDeceleration() {
        bike.turnOn();
        bike.setSpeed(41);
        bike.decelerate();
        assertEquals(37, bike.getSpeed());
        assertEquals(3,  bike.getGear());
    }
}