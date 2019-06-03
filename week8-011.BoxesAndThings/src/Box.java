import java.util.ArrayList;
import java.util.Objects;

public class Box implements ToBeStored {

    private double maxWeight;
    private ArrayList<ToBeStored> thingsStored;

    public Box(double maxWeight) {
        this.maxWeight = maxWeight;
        this.thingsStored = new ArrayList<ToBeStored>();
    }

    @Override
    public double weight() {
        double totalWeight = 0;
        for (ToBeStored thing : thingsStored) {
            totalWeight += thing.weight();
        }
        return totalWeight;
    }

    public ArrayList<ToBeStored> getThingsStored() {
        return this.thingsStored;
    }

    public void add(ToBeStored thing) {
        if (weight() + thing.weight() <= maxWeight) {
            thingsStored.add(thing);
        }
    }

    @Override
    public String toString() {
        double weight = this.weight();
        int size = this.thingsStored.size();
        return "Box: " + size + " things, total weight " + weight + " kg";
    }
}
