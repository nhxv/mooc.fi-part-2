package farmsimulator;

public class BulkTank {

    private double capacity;
    private double volume;

    public BulkTank(double capacity) {
        this.capacity = capacity;
        this.volume = 0.0;
    }

    public BulkTank() {
        this(2000);
    }

    public double getCapacity() {
        return capacity;
    }

    public double getVolume() {
        return volume;
    }

    public double howMuchFreeSpace() {
        return capacity - volume;
    }

    public void addToTank(double amount) {
        if (volume + amount <= capacity) {
            volume += amount;
        } else {
            volume = capacity;
        }

    }

    public double getFromTank(double amount) {
        if (amount < 0) {
            return 0.0;
        }
        if (volume >= amount) {
            volume -= amount;
            return amount;
        }
        double everything = volume;
        volume = 0.0;
        return everything;
    }

    @Override
    public String toString() {
        return Math.ceil(this.volume) + "/" + Math.ceil(this.capacity);
    }
}
