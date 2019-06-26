package containers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ContainerHistory {

    private List<Double> containerHistory;

    public ContainerHistory() {
        this.containerHistory = new ArrayList<Double>();
    }

    public void add(double situation) {
        containerHistory.add(situation);
    }

    public void reset() {
        containerHistory.clear();
    }

    public double maxValue() {
        double max = Collections.max(containerHistory);
        return max;
    }

    public double minValue() {
        double min = Collections.min(containerHistory);
        return  min;
    }

    public double average() {
        double sum = 0;
        for (double situation : containerHistory) {
            sum += situation;
        }
        double average = sum/containerHistory.size();
        return average;
    }

    public double variance() {
        if (containerHistory.size() < 2) {
            return 0;
        } else {
            double variance = 0;
            double temp = 0;
            for (double situation : containerHistory) {
                temp += Math.pow(situation - average(), 2);
            }
            variance = temp/(containerHistory.size() - 1);
            return variance;
        }
    }

    public double greatestFluctuation() {
        if (containerHistory.size() < 2) {
            return 0;
        } else {
            double greatestChange = Math.abs(containerHistory.get(0) - containerHistory.get(1));
            for (int i = 0; i < containerHistory.size(); i++) {
                if (i != containerHistory.size() - 1) {
                    if (greatestChange < Math.abs(containerHistory.get(i) - containerHistory.get(i + 1))) {
                        greatestChange = Math.abs(containerHistory.get(i) - containerHistory.get(i + 1));
                    }
                }
            }
            return greatestChange;
        }
    }

    @Override
    public String toString() {
        return containerHistory.toString();
    }
}
