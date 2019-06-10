package application;

import java.util.ArrayList;
import java.util.List;

public class AverageSensor implements Sensor {
    private List<Sensor> sensorList;
    private List<Integer> averageList;

    public AverageSensor() {
        this.sensorList = new ArrayList<Sensor>();
        this.averageList = new ArrayList<Integer>();
    }

    public void addSensor(Sensor traditional) {
        sensorList.add(traditional);
    }

    public List<Integer> readings() {
        return averageList;
    }

    @Override
    public boolean isOn() {
        for (Sensor sensor : sensorList) {
            if (!sensor.isOn()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void on() {
        for (Sensor sensor : sensorList) {
            sensor.on();
        }
    }

    @Override
    public void off() {
        sensorList.get(0).off();
    }

    @Override
    public int measure() {
        if (!this.isOn() || this.sensorList.isEmpty()) {
            throw new IllegalStateException("Invalid state!");
        }

        //Calculate average
        int sum = 0;
        for (Sensor sensor : sensorList) {
            sum += sensor.measure();
        }
        int average = sum/sensorList.size();
        averageList.add(average);
        return average;
    }
}
