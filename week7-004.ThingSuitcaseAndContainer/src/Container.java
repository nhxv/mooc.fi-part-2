import java.util.ArrayList;

public class Container {

    private ArrayList<Suitcase> suitcases;
    private int maxWeight;

    public Container(int maxWeight) {
        this.maxWeight = maxWeight;
        this.suitcases = new ArrayList<Suitcase>();
    }

    public void addSuitcase(Suitcase suitcase) {
        if (belowMaxWeight(suitcase)) {
            suitcases.add(suitcase);
        }
    }


    public boolean belowMaxWeight(Suitcase suitcase) {
        if ((suitcase.totalWeight() + totalSuitcaseWeight()) <= this.maxWeight) {
            return true;
        } else {
            return false;
        }
    }

    public int totalSuitcaseWeight() {
        int sum = 0;
        for (Suitcase suitcase : suitcases) {
            sum += suitcase.totalWeight();
        }
        return sum;
    }

    public void printThings() {
        for (Suitcase suitcase : suitcases) {
            suitcase.printThings();
        }
    }

    public String toString() {
        if (suitcases.size() == 0) {
            return "empty (0 kg)";
        } else if (suitcases.size() == 1) {
            return "1 suitcase (" + totalSuitcaseWeight() + " kg)";
        } else {
            return suitcases.size() + " suitcases (" + totalSuitcaseWeight() + " kg)";
        }
    }
}
