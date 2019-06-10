package application;

import java.util.Random;

public class Thermometer implements Sensor {

    private boolean status;

    public Thermometer() {
        this.status = false;
    }

    @Override
    public boolean isOn() {
        return this.status;
    }

    @Override
    public void on() {
        status = true;
    }

    @Override
    public void off() {
        status = false;
    }

    @Override
    public int measure() {
        if (!this.isOn()) {
            throw new IllegalStateException("Thermometer is off!");
        }
        return (int)(Math.random() * ((30 - -30) + 1)) + -30;
    }
}
