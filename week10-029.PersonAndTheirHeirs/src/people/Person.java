package people;

public class Person {

    private String name;
    private String address;

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        String str = this.name + "\n" + "  " + this.address;
        return str;
    }
}
