package people;

public class Teacher extends Person {

    private int salary;

    public Teacher(String name, String address, int salary) {
        super(name, address);
        this.salary = salary;
    }

    @Override
    public String toString() {
        String str = super.toString() + "\n" + "  salary " + this.salary + " euros/month";
        return str;
    }
}
