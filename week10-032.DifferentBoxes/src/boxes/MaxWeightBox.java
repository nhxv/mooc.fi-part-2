package boxes;

import java.util.ArrayList;
import java.util.List;

public class MaxWeightBox extends Box {

    private int maxWeight;
    private List<Thing> thingInBox;

    public MaxWeightBox(int maxWeight) {
        this.maxWeight = maxWeight;
        this.thingInBox = new ArrayList<Thing>();
    }

    public int sumInBox() {
        if (thingInBox.isEmpty()) {
            return 0;
        }

        int sum = 0;
        for (Thing thing : thingInBox) {
            sum += thing.getWeight();
        }
        return sum;
    }

    @Override
    public void add(Thing thing) {
        if (thing.getWeight() + sumInBox() <= this.maxWeight) {
            thingInBox.add(thing);
        }
    }

    @Override
    public boolean isInTheBox(Thing thing) {
        if (thingInBox.contains(thing)) {
            return true;
        } else {
            return false;
        }
    }
}
