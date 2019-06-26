package farmsimulator;

import java.util.Random;

public class Cow implements Alive, Milkable {

    private String name;
    private double capacity;
    private static final String[] NAMES = new String[]{
            "Anu", "Arpa", "Essi", "Heluna", "Hely",
            "Hento", "Hilke", "Hilsu", "Hymy", "Ihq", "Ilme", "Ilo",
            "Jaana", "Jami", "Jatta", "Laku", "Liekki",
            "Mainikki", "Mella", "Mimmi", "Naatti",
            "Nina", "Nyytti", "Papu", "Pullukka", "Pulu",
            "Rima", "Soma", "Sylkki", "Valpu", "Virpi"};

    private int aliveHour;
    private double cowMilkAmount;

    public Cow(String name) {
        this.name = name;
        Random random = new Random();
        this.capacity = 15 + (40 - 15)*random.nextDouble();
        this.aliveHour = 0;
        this.cowMilkAmount = 0.0;
    }

    public Cow() {
        this.name = NAMES[(int)(Math.random() * ((NAMES.length) + 1))];
        Random random = new Random();
        this.capacity = 15 + (40 - 15)*random.nextDouble();
        this.aliveHour = 0;
        this.cowMilkAmount = 0.0;
    }

    public String getName() {
        return this.name;
    }

    public double getCapacity() {
        return this.capacity;
    }

    public double getAmount() {
        return cowMilkAmount;
    }

    @Override
    public void liveHour() {
        this.aliveHour++;
        double increasedAmount = 0.7 + (2 - 0.7)*new Random().nextDouble();
        if (cowMilkAmount + increasedAmount > capacity) {
            this.cowMilkAmount = capacity;
        } else {
            this.cowMilkAmount += increasedAmount;
        }

    }

    @Override
    public double milk() {
        double everything = cowMilkAmount;
        cowMilkAmount = 0.0;
        return everything;
    }

    @Override
    public String toString() {
        return this.name + " " + Math.ceil(this.cowMilkAmount) + "/" + Math.ceil(this.capacity);
    }
}
