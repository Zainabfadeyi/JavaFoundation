package test;

import org.junit.Test;
import org.junit.Before;
import src.FireDrillFive.Television;

import static org.junit.Assert.*;

public class TelevisionTest {

    Television tv;

    @Before
    public void setUp() {
        tv = new Television();
    }



    @Test
    public void testTvIsOffByDefault() {
        assertFalse(tv.isOn());
    }

    @Test
    public void testDefaultVolumeIsZero() {
        assertEquals(0, tv.getVolume());
    }

    @Test
    public void testDefaultChannelIsOne() {
        assertEquals(1, tv.getChannel());
    }

    @Test
    public void testDefaultBrightnessIsFifty() {
        assertEquals(50, tv.getBrightness());
    }

    @Test
    public void testDefaultIsMuted() {
        assertFalse(tv.isMuted());
    }



    @Test
    public void testTvCanBeTurnedOn() {
        tv.turnOn();
        assertTrue(tv.isOn());
    }

    @Test
    public void testTvCanBeTurnedOff() {
        tv.turnOn();
        tv.turnOff();
        assertFalse(tv.isOn());
    }

    @Test
    public void testTvResetsVolumeOnTurnOff() {
        tv.turnOn();
        tv.setVolume(30);
        tv.turnOff();
        assertEquals(0, tv.getVolume());
    }

    @Test
    public void testTvResetsChannelOnTurnOff() {
        tv.turnOn();
        tv.setChannel(10);
        tv.turnOff();
        assertEquals(1, tv.getChannel());
    }

    @Test
    public void testTvResetsBrightnessOnTurnOff() {
        tv.turnOn();
        tv.setBrightness(80);
        tv.turnOff();
        assertEquals(50, tv.getBrightness());
    }



    @Test
    public void testCannotIncreaseVolumeWhenOff() {
        tv.increaseVolume();
        assertEquals(0, tv.getVolume());
    }

    @Test
    public void testCannotDecreaseVolumeWhenOff() {
        tv.decreaseVolume();
        assertEquals(0, tv.getVolume());
    }

    @Test
    public void testCannotChannelUpWhenOff() {
        tv.channelUp();
        assertEquals(1, tv.getChannel());
    }

    @Test
    public void testCannotChannelDownWhenOff() {
        tv.channelDown();
        assertEquals(1, tv.getChannel());
    }

    @Test
    public void testCannotIncreaseBrightnessWhenOff() {
        tv.increaseBrightness();
        assertEquals(50, tv.getBrightness());
    }

    @Test
    public void testCannotDecreaseBrightnessWhenOff() {
        tv.decreaseBrightness();
        assertEquals(50, tv.getBrightness());
    }

    @Test
    public void testCannotMuteWhenOff() {
        tv.mute();
        assertFalse(tv.isMuted());
    }



    @Test
    public void testIncreaseVolume() {
        tv.turnOn();
        tv.setVolume(10);
        tv.increaseVolume();
        assertEquals(11, tv.getVolume());
    }

    @Test
    public void testDecreaseVolume() {
        tv.turnOn();
        tv.setVolume(10);
        tv.decreaseVolume();
        assertEquals(9, tv.getVolume());
    }

    @Test
    public void testVolumeDoesNotGoBelowZero() {
        tv.turnOn();
        tv.setVolume(0);
        tv.decreaseVolume();
        assertEquals(0, tv.getVolume());
    }

    @Test
    public void testVolumeDoesNotExceedOneHundred() {
        tv.turnOn();
        tv.setVolume(100);
        tv.increaseVolume();
        assertEquals(100, tv.getVolume());
    }

    @Test
    public void testSetVolumeDirectly() {
        tv.turnOn();
        tv.setVolume(50);
        assertEquals(50, tv.getVolume());
    }

    @Test
    public void testSetVolumeAboveMaxIsClampedToHundred() {
        tv.turnOn();
        tv.setVolume(150);
        assertEquals(100, tv.getVolume());
    }

    @Test
    public void testSetVolumeBelowMinIsClampedToZero() {
        tv.turnOn();
        tv.setVolume(-10);
        assertEquals(0, tv.getVolume());
    }



    @Test
    public void testMuteSetsIsMutedToTrue() {
        tv.turnOn();
        tv.mute();
        assertTrue(tv.isMuted());
    }

    @Test
    public void testUnmuteSetsIsMutedToFalse() {
        tv.turnOn();
        tv.mute();
        tv.unmute();
        assertFalse(tv.isMuted());
    }

    @Test
    public void testMuteDoesNotChangeVolume() {
        tv.turnOn();
        tv.setVolume(40);
        tv.mute();
        assertEquals(40, tv.getVolume());
    }

    @Test
    public void testUnmuteRestoresVolume() {
        tv.turnOn();
        tv.setVolume(40);
        tv.mute();
        tv.unmute();
        assertEquals(40, tv.getVolume());
    }

    @Test
    public void testToggleMute() {
        tv.turnOn();
        tv.mute();
        assertTrue(tv.isMuted());
        tv.mute();
        assertFalse(tv.isMuted());
    }



    @Test
    public void testChannelUp() {
        tv.turnOn();
        tv.setChannel(5);
        tv.channelUp();
        assertEquals(6, tv.getChannel());
    }

    @Test
    public void testChannelDown() {
        tv.turnOn();
        tv.setChannel(5);
        tv.channelDown();
        assertEquals(4, tv.getChannel());
    }

    @Test
    public void testChannelDoesNotGoBelowOne() {
        tv.turnOn();
        tv.setChannel(1);
        tv.channelDown();
        assertEquals(1, tv.getChannel());
    }

    @Test
    public void testChannelWrapsAroundAtMax() {
        tv.turnOn();
        tv.setChannel(999);
        tv.channelUp();
        assertEquals(1, tv.getChannel());
    }

    @Test
    public void testSetChannelDirectly() {
        tv.turnOn();
        tv.setChannel(20);
        assertEquals(20, tv.getChannel());
    }

    @Test
    public void testSetChannelBelowOneIsClampedToOne() {
        tv.turnOn();
        tv.setChannel(-5);
        assertEquals(1, tv.getChannel());
    }


    @Test
    public void testIncreaseBrightness() {
        tv.turnOn();
        tv.setBrightness(50);
        tv.increaseBrightness();
        assertEquals(51, tv.getBrightness());
    }

    @Test
    public void testDecreaseBrightness() {
        tv.turnOn();
        tv.setBrightness(50);
        tv.decreaseBrightness();
        assertEquals(49, tv.getBrightness());
    }

    @Test
    public void testBrightnessDoesNotExceedOneHundred() {
        tv.turnOn();
        tv.setBrightness(100);
        tv.increaseBrightness();
        assertEquals(100, tv.getBrightness());
    }

    @Test
    public void testBrightnessDoesNotGoBelowZero() {
        tv.turnOn();
        tv.setBrightness(0);
        tv.decreaseBrightness();
        assertEquals(0, tv.getBrightness());
    }

    @Test
    public void testSetBrightnessDirectly() {
        tv.turnOn();
        tv.setBrightness(75);
        assertEquals(75, tv.getBrightness());
    }

    @Test
    public void testSetBrightnessAboveMaxIsClampedToHundred() {
        tv.turnOn();
        tv.setBrightness(150);
        assertEquals(100, tv.getBrightness());
    }

    @Test
    public void testSetBrightnessBelowMinIsClampedToZero() {
        tv.turnOn();
        tv.setBrightness(-10);
        assertEquals(0, tv.getBrightness());
    }
}