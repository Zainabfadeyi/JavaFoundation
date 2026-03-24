package src.FireDrillFive;

public class AutomaticBike {

    private boolean on;
    private int     speed;
    private int     gear;

    public AutomaticBike() {
        this.on    = false;
        this.speed = 0;
        this.gear  = 1;
    }


    public void turnOn() {
        on    = true;
        speed = 0;
        gear  = 1;
    }

    public void turnOff() {
        on    = false;
        speed = 0;
        gear  = 1;
    }

    public boolean isOn() {
        return on;
    }


    public void accelerate() {
        if (!on) return;
        speed += gear;
        updateGear();
    }


    public void decelerate() {
        if (!on) return;
        speed -= gear;
        if (speed < 0) speed = 0;
        updateGear();
    }


    private void updateGear() {
        if      (speed <= 20) gear = 1;
        else if (speed <= 30) gear = 2;
        else if (speed <= 40) gear = 3;
        else                  gear = 4;
    }


    public int getSpeed() { return speed; }
    public int getGear()  { return gear;  }

    public void setSpeed(int speed) {
        if (!on) return;
        this.speed = speed;
        updateGear();
    }
}