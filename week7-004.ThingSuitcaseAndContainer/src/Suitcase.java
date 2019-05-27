import java.util.ArrayList;

public class Suitcase {

    private ArrayList<Thing> things;
    private int maxWeight;

    public Suitcase(int maxWeight) {
        this.maxWeight = maxWeight;
        this.things = new ArrayList<Thing>();
    }

    public void addThing(Thing thing) {
       if (belowMaxWeight(thing)) {
           things.add(thing);
       }
    }

    public boolean belowMaxWeight(Thing thing) {
        if ((thing.getWeight() + totalWeight()) <= this.maxWeight) {
            return true;
        } else {
            return false;
        }
    }

    public int totalWeight() {
        int sum = 0;
        for (Thing thing : things) {
            sum += thing.getWeight();
        }
        return sum;
    }

    public Thing heaviestThing() {
        for (Thing thing : things) {
            if (thing.getWeight() == heaviestWeight()) {
                return thing;
            }
        }
        return null;
    }

    public int heaviestWeight() {
        int heaviest = 0;
        for (Thing thing : things) {
            if (heaviest < thing.getWeight()) {
                heaviest = thing.getWeight();
            }
        }
        return heaviest;
    }

    public void printThings() {
        for (Thing thing : things) {
            System.out.println(thing);
        }
    }

    public String toString() {
        if (things.size() == 0) {
            return "empty (0 kg)";
        } else if (things.size() == 1) {
            return "1 thing (" + totalWeight() + " kg)";
        } else {
            return things.size() + " things (" + totalWeight() + " kg)";
        }
    }

}
