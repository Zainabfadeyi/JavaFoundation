package test;

import org.junit.Test;
import org.junit.Before;
import src.FireDrillFive.AirConditioning;

import static org.junit.Assert.*;

public class AirConditioningTest {

    AirConditioning ac;

    @Before
    public void setUp() {
        ac = new AirConditioning();
    }



    @Test
    public void testAcIsOffByDefault() {
        assertFalse(ac.isOn());
    }

    @Test
    public void testDefaultTemperatureIs16() {
        assertEquals(16, ac.getTemperature());
    }

    @Test
    public void testDefaultModeIsCool() {
        assertEquals("COOL", ac.getMode());
    }

    @Test
    public void testDefaultFanSpeedIsLow() {
        assertEquals("LOW", ac.getFanSpeed());
    }

    @Test
    public void testDefaultIsNotSleepMode() {
        assertFalse(ac.isSleepMode());
    }

    @Test
    public void testDefaultIsNotTimerSet() {
        assertFalse(ac.isTimerSet());
    }

    @Test
    public void testDefaultSwingIsOff() {
        assertFalse(ac.isSwingOn());
    }



    @Test
    public void testAcCanBeTurnedOn() {
        ac.turnOn();
        assertTrue(ac.isOn());
    }

    @Test
    public void testAcCanBeTurnedOff() {
        ac.turnOn();
        ac.turnOff();
        assertFalse(ac.isOn());
    }

    @Test
    public void testAcResetsTemperatureOnTurnOff() {
        ac.turnOn();
        ac.setTemperature(25);
        ac.turnOff();
        assertEquals(16, ac.getTemperature());
    }

    @Test
    public void testAcResetsModeOnTurnOff() {
        ac.turnOn();
        ac.setMode("HEAT");
        ac.turnOff();
        assertEquals("COOL", ac.getMode());
    }

    @Test
    public void testAcResetsFanSpeedOnTurnOff() {
        ac.turnOn();
        ac.setFanSpeed("HIGH");
        ac.turnOff();
        assertEquals("LOW", ac.getFanSpeed());
    }

    @Test
    public void testAcResetsSleepModeOnTurnOff() {
        ac.turnOn();
        ac.setSleepMode(true);
        ac.turnOff();
        assertFalse(ac.isSleepMode());
    }

    @Test
    public void testAcResetsSwingOnTurnOff() {
        ac.turnOn();
        ac.toggleSwing();
        ac.turnOff();
        assertFalse(ac.isSwingOn());
    }

    @Test
    public void testAcResetsTimerOnTurnOff() {
        ac.turnOn();
        ac.setTimer(2);
        ac.turnOff();
        assertFalse(ac.isTimerSet());
    }



    @Test
    public void testCannotIncreaseTemperatureWhenOff() {
        ac.increaseTemperature();
        assertEquals(16, ac.getTemperature());
    }

    @Test
    public void testCannotDecreaseTemperatureWhenOff() {
        ac.decreaseTemperature();
        assertEquals(16, ac.getTemperature());
    }

    @Test
    public void testCannotSetModeWhenOff() {
        ac.setMode("HEAT");
        assertEquals("COOL", ac.getMode());
    }

    @Test
    public void testCannotSetFanSpeedWhenOff() {
        ac.setFanSpeed("HIGH");
        assertEquals("LOW", ac.getFanSpeed());
    }

    @Test
    public void testCannotToggleSwingWhenOff() {
        ac.toggleSwing();
        assertFalse(ac.isSwingOn());
    }

    @Test
    public void testCannotSetSleepModeWhenOff() {
        ac.setSleepMode(true);
        assertFalse(ac.isSleepMode());
    }

    @Test
    public void testCannotSetTimerWhenOff() {
        ac.setTimer(2);
        assertFalse(ac.isTimerSet());
    }



    @Test
    public void testIncreaseTemperature() {
        ac.turnOn();
        ac.setTemperature(22);
        ac.increaseTemperature();
        assertEquals(23, ac.getTemperature());
    }

    @Test
    public void testDecreaseTemperature() {
        ac.turnOn();
        ac.setTemperature(22);
        ac.decreaseTemperature();
        assertEquals(21, ac.getTemperature());
    }

    @Test
    public void testTemperatureDoesNotGoBelowSixteen() {
        ac.turnOn();
        ac.setTemperature(16);
        ac.decreaseTemperature();
        assertEquals(16, ac.getTemperature());
    }

    @Test
    public void testTemperatureDoesNotExceedThirty() {
        ac.turnOn();
        ac.setTemperature(30);
        ac.increaseTemperature();
        assertEquals(30, ac.getTemperature());
    }

    @Test
    public void testSetTemperatureDirectly() {
        ac.turnOn();
        ac.setTemperature(24);
        assertEquals(24, ac.getTemperature());
    }

    @Test
    public void testSetTemperatureAboveMaxIsClampedToThirty() {
        ac.turnOn();
        ac.setTemperature(40);
        assertEquals(30, ac.getTemperature());
    }

    @Test
    public void testSetTemperatureBelowMinIsClampedToSixteen() {
        ac.turnOn();
        ac.setTemperature(10);
        assertEquals(16, ac.getTemperature());
    }



    @Test
    public void testSetModeToCool() {
        ac.turnOn();
        ac.setMode("COOL");
        assertEquals("COOL", ac.getMode());
    }

    @Test
    public void testSetModeToHeat() {
        ac.turnOn();
        ac.setMode("HEAT");
        assertEquals("HEAT", ac.getMode());
    }

    @Test
    public void testSetModeToFan() {
        ac.turnOn();
        ac.setMode("FAN");
        assertEquals("FAN", ac.getMode());
    }

    @Test
    public void testSetModeToDry() {
        ac.turnOn();
        ac.setMode("DRY");
        assertEquals("DRY", ac.getMode());
    }

    @Test
    public void testSetModeToAuto() {
        ac.turnOn();
        ac.setMode("AUTO");
        assertEquals("AUTO", ac.getMode());
    }

    @Test
    public void testSetInvalidModeDoesNotChange() {
        ac.turnOn();
        ac.setMode("INVALID");
        assertEquals("COOL", ac.getMode());
    }



    @Test
    public void testSetFanSpeedToLow() {
        ac.turnOn();
        ac.setFanSpeed("LOW");
        assertEquals("LOW", ac.getFanSpeed());
    }

    @Test
    public void testSetFanSpeedToMedium() {
        ac.turnOn();
        ac.setFanSpeed("MEDIUM");
        assertEquals("MEDIUM", ac.getFanSpeed());
    }

    @Test
    public void testSetFanSpeedToHigh() {
        ac.turnOn();
        ac.setFanSpeed("HIGH");
        assertEquals("HIGH", ac.getFanSpeed());
    }

    @Test
    public void testSetFanSpeedToAuto() {
        ac.turnOn();
        ac.setFanSpeed("AUTO");
        assertEquals("AUTO", ac.getFanSpeed());
    }

    @Test
    public void testSetInvalidFanSpeedDoesNotChange() {
        ac.turnOn();
        ac.setFanSpeed("INVALID");
        assertEquals("LOW", ac.getFanSpeed());
    }

    @Test
    public void testIncreaseFanSpeed_LowToMedium() {
        ac.turnOn();
        ac.setFanSpeed("LOW");
        ac.increaseFanSpeed();
        assertEquals("MEDIUM", ac.getFanSpeed());
    }

    @Test
    public void testIncreaseFanSpeed_MediumToHigh() {
        ac.turnOn();
        ac.setFanSpeed("MEDIUM");
        ac.increaseFanSpeed();
        assertEquals("HIGH", ac.getFanSpeed());
    }

    @Test
    public void testIncreaseFanSpeed_HighToAuto() {
        ac.turnOn();
        ac.setFanSpeed("HIGH");
        ac.increaseFanSpeed();
        assertEquals("AUTO", ac.getFanSpeed());
    }

    @Test
    public void testIncreaseFanSpeed_AutoDoesNotChange() {
        ac.turnOn();
        ac.setFanSpeed("AUTO");
        ac.increaseFanSpeed();
        assertEquals("AUTO", ac.getFanSpeed());
    }

    @Test
    public void testDecreaseFanSpeed_AutoToHigh() {
        ac.turnOn();
        ac.setFanSpeed("AUTO");
        ac.decreaseFanSpeed();
        assertEquals("HIGH", ac.getFanSpeed());
    }

    @Test
    public void testDecreaseFanSpeed_HighToMedium() {
        ac.turnOn();
        ac.setFanSpeed("HIGH");
        ac.decreaseFanSpeed();
        assertEquals("MEDIUM", ac.getFanSpeed());
    }

    @Test
    public void testDecreaseFanSpeed_MediumToLow() {
        ac.turnOn();
        ac.setFanSpeed("MEDIUM");
        ac.decreaseFanSpeed();
        assertEquals("LOW", ac.getFanSpeed());
    }

    @Test
    public void testDecreaseFanSpeed_LowDoesNotChange() {
        ac.turnOn();
        ac.setFanSpeed("LOW");
        ac.decreaseFanSpeed();
        assertEquals("LOW", ac.getFanSpeed());
    }



    @Test
    public void testEnableSleepMode() {
        ac.turnOn();
        ac.setSleepMode(true);
        assertTrue(ac.isSleepMode());
    }

    @Test
    public void testDisableSleepMode() {
        ac.turnOn();
        ac.setSleepMode(true);
        ac.setSleepMode(false);
        assertFalse(ac.isSleepMode());
    }

    @Test
    public void testSleepModeSetsFanSpeedToLow() {
        ac.turnOn();
        ac.setFanSpeed("HIGH");
        ac.setSleepMode(true);
        assertEquals("LOW", ac.getFanSpeed());
    }



    @Test
    public void testToggleSwingOn() {
        ac.turnOn();
        ac.toggleSwing();
        assertTrue(ac.isSwingOn());
    }

    @Test
    public void testToggleSwingOff() {
        ac.turnOn();
        ac.toggleSwing();
        ac.toggleSwing();
        assertFalse(ac.isSwingOn());
    }



    @Test
    public void testSetTimer() {
        ac.turnOn();
        ac.setTimer(2);
        assertTrue(ac.isTimerSet());
    }

    @Test
    public void testGetTimerHours() {
        ac.turnOn();
        ac.setTimer(3);
        assertEquals(3, ac.getTimerHours());
    }

    @Test
    public void testCancelTimer() {
        ac.turnOn();
        ac.setTimer(2);
        ac.cancelTimer();
        assertFalse(ac.isTimerSet());
    }

    @Test
    public void testSetTimerZeroHoursDoesNotSetTimer() {
        ac.turnOn();
        ac.setTimer(0);
        assertFalse(ac.isTimerSet());
    }

    @Test
    public void testSetTimerAbove24HoursIsIgnored() {
        ac.turnOn();
        ac.setTimer(25);
        assertFalse(ac.isTimerSet());
    }
}