package src.FireDrillFive;

public class Television {

    private static final int MIN_VOLUME     = 0;
    private static final int MAX_VOLUME     = 100;
    private static final int MIN_CHANNEL    = 1;
    private static final int MAX_CHANNEL    = 999;
    private static final int MIN_BRIGHTNESS = 0;
    private static final int MAX_BRIGHTNESS = 100;
    private static final int DEFAULT_BRIGHTNESS = 50;

    private boolean on;
    private int     volume;
    private int     channel;
    private int     brightness;
    private boolean muted;

    public Television() {
        this.on         = false;
        this.volume     = 0;
        this.channel    = 1;
        this.brightness = DEFAULT_BRIGHTNESS;
        this.muted      = false;
    }


    public void turnOn() {
        on = true;
    }

    public void turnOff() {
        on         = false;
        volume     = 0;
        channel    = 1;
        brightness = DEFAULT_BRIGHTNESS;
        muted      = false;
    }

    public boolean isOn() { return on; }


    public void increaseVolume() {
        if (!on) return;
        if (volume < MAX_VOLUME) volume++;
    }

    public void decreaseVolume() {
        if (!on) return;
        if (volume > MIN_VOLUME) volume--;
    }

    public void setVolume(int volume) {
        if (!on) return;
        if      (volume > MAX_VOLUME) this.volume = MAX_VOLUME;
        else if (volume < MIN_VOLUME) this.volume = MIN_VOLUME;
        else                          this.volume = volume;
    }

    public int getVolume() { return volume; }


    public void mute() {
        if (!on) return;
        muted = !muted;
    }

    public void unmute() {
        if (!on) return;
        muted = false;
    }

    public boolean isMuted() { return muted; }


    public void channelUp() {
        if (!on) return;
        if (channel >= MAX_CHANNEL) channel = MIN_CHANNEL;
        else                        channel++;
    }

    public void channelDown() {
        if (!on) return;
        if (channel > MIN_CHANNEL) channel--;
    }

    public void setChannel(int channel) {
        if (!on) return;
        if      (channel < MIN_CHANNEL) this.channel = MIN_CHANNEL;
        else if (channel > MAX_CHANNEL) this.channel = MAX_CHANNEL;
        else                            this.channel = channel;
    }

    public int getChannel() { return channel; }


    public void increaseBrightness() {
        if (!on) return;
        if (brightness < MAX_BRIGHTNESS) brightness++;
    }

    public void decreaseBrightness() {
        if (!on) return;
        if (brightness > MIN_BRIGHTNESS) brightness--;
    }

    public void setBrightness(int brightness) {
        if (!on) return;
        if      (brightness > MAX_BRIGHTNESS) this.brightness = MAX_BRIGHTNESS;
        else if (brightness < MIN_BRIGHTNESS) this.brightness = MIN_BRIGHTNESS;
        else                                  this.brightness = brightness;
    }

    public int getBrightness() { return brightness; }
}