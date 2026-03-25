package src.FireDrillFive;

public class AirConditioning {

    private static final int    MIN_TEMP         = 16;
    private static final int    MAX_TEMP         = 30;
    private static final int    DEFAULT_TEMP     = 16;
    private static final String DEFAULT_MODE     = "COOL";
    private static final String DEFAULT_FAN      = "LOW";

    private static final String[] VALID_MODES    = {"COOL", "HEAT", "FAN", "DRY", "AUTO"};
    private static final String[] FAN_SPEEDS     = {"LOW", "MEDIUM", "HIGH", "AUTO"};

    private boolean on;
    private int     temperature;
    private String  mode;
    private String  fanSpeed;
    private boolean sleepMode;
    private boolean swingOn;
    private boolean timerSet;
    private int     timerHours;


    public AirConditioning() {
        this.on          = false;
        this.temperature = DEFAULT_TEMP;
        this.mode        = DEFAULT_MODE;
        this.fanSpeed    = DEFAULT_FAN;
        this.sleepMode   = false;
        this.swingOn     = false;
        this.timerSet    = false;
        this.timerHours  = 0;
    }


    // ─── Turn On / Off ────────────────────────────────────────────────────────
    public void turnOn() {
        on = true;
    }

    public void turnOff() {
        on          = false;
        temperature = DEFAULT_TEMP;
        mode        = DEFAULT_MODE;
        fanSpeed    = DEFAULT_FAN;
        sleepMode   = false;
        swingOn     = false;
        timerSet    = false;
        timerHours  = 0;
    }

    public boolean isOn() { return on; }


    // ─── Temperature ─────────────────────────────────────────────────────────
    public void increaseTemperature() {
        if (!on) return;
        if (temperature < MAX_TEMP) temperature++;
    }

    public void decreaseTemperature() {
        if (!on) return;
        if (temperature > MIN_TEMP) temperature--;
    }

    public void setTemperature(int temperature) {
        if (!on) return;
        if      (temperature > MAX_TEMP) this.temperature = MAX_TEMP;
        else if (temperature < MIN_TEMP) this.temperature = MIN_TEMP;
        else                             this.temperature = temperature;
    }

    public int getTemperature() { return temperature; }


    // ─── Mode ─────────────────────────────────────────────────────────────────
    public void setMode(String mode) {
        if (!on) return;
        for (String validMode : VALID_MODES) {
            if (validMode.equals(mode)) {
                this.mode = mode;
                return;
            }
        }
    }

    public String getMode() { return mode; }


    // ─── Fan Speed ────────────────────────────────────────────────────────────
    public void setFanSpeed(String fanSpeed) {
        if (!on) return;
        for (String speed : FAN_SPEEDS) {
            if (speed.equals(fanSpeed)) {
                this.fanSpeed = fanSpeed;
                return;
            }
        }
    }

    public void increaseFanSpeed() {
        if (!on) return;
        for (int i = 0; i < FAN_SPEEDS.length - 1; i++) {
            if (FAN_SPEEDS[i].equals(fanSpeed)) {
                fanSpeed = FAN_SPEEDS[i + 1];
                return;
            }
        }
    }

    public void decreaseFanSpeed() {
        if (!on) return;
        for (int i = FAN_SPEEDS.length - 1; i > 0; i--) {
            if (FAN_SPEEDS[i].equals(fanSpeed)) {
                fanSpeed = FAN_SPEEDS[i - 1];
                return;
            }
        }
    }

    public String getFanSpeed() { return fanSpeed; }


    // ─── Sleep Mode ───────────────────────────────────────────────────────────
    public void setSleepMode(boolean sleepMode) {
        if (!on) return;
        this.sleepMode = sleepMode;
        if (sleepMode) fanSpeed = "LOW";
    }

    public boolean isSleepMode() { return sleepMode; }


    // ─── Swing ────────────────────────────────────────────────────────────────
    public void toggleSwing() {
        if (!on) return;
        swingOn = !swingOn;
    }

    public boolean isSwingOn() { return swingOn; }


    // ─── Timer ────────────────────────────────────────────────────────────────
    public void setTimer(int hours) {
        if (!on) return;
        if (hours <= 0 || hours > 24) return;
        timerHours = hours;
        timerSet   = true;
    }

    public void cancelTimer() {
        if (!on) return;
        timerSet   = false;
        timerHours = 0;
    }

    public boolean isTimerSet()  { return timerSet;   }
    public int     getTimerHours() { return timerHours; }
}
