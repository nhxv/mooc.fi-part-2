import java.util.*;

public class Person implements Comparable<Person> {

    private String name;
    private Set<String> phones;
    private Set<String> addresses;

    public Person() {
        this.name = "";
        this.phones = new HashSet<String>();
        this.addresses = new HashSet<String>();
    }

    public void addName(String name) {
        this.name = name;
    }

    public void addPhone(String phone) {
        this.phones.add(phone);
    }

    public void addAddress(String address) {
        this.addresses.add(address);
    }

    public String getName() {
        return this.name;
    }

    public Set<String> getPhone() {
        return this.phones;
    }

    public Set<String> getAddress() {
        return this.addresses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(phones, person.phones) &&
                Objects.equals(addresses, person.addresses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phones, addresses);
    }

    @Override
    public int compareTo(Person o) {
        return this.getName().compareTo(o.getName());
    }
}
