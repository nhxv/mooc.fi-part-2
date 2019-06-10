import java.util.*;

public class UserInterface {

    private Scanner reader;
    private List<Person> people;

    public UserInterface(Scanner reader) {
        this.reader = reader;
        this.people = new ArrayList<Person>();
    }

    public void display() {
        //display available operations
        System.out.println("phone search");
        System.out.println("available operations:");
        System.out.println(" 1 add a number");
        System.out.println(" 2 search for a number");
        System.out.println(" 3 search for a person by phone number");
        System.out.println(" 4 add an address");
        System.out.println(" 5 search for personal information");
        System.out.println(" 6 delete personal information");
        System.out.println(" 7 filtered listing");
        System.out.println(" x quit");

        while (true) {
            System.out.println("");
            System.out.print("command: ");
            String command = reader.nextLine();

            if (command.equals("1")) {
                //add phone number
                System.out.print("whose number: ");
                String name = reader.nextLine();
                System.out.print("number: ");
                String phone = reader.nextLine();
                //check if person already exists in people
                if (isPersonExists(name)) {
                    for (Person person : people) {
                        if (person.getName().equals(name)) {
                            person.getPhone().add(phone);
                        }
                    }
                } else {
                    //if not, create a new person
                    Person person = new Person();
                    person.addName(name);
                    person.addPhone(phone);
                    people.add(person);
                }

            } else if (command.equals("2")) {
                //search phone with person name
                System.out.print("whose number: ");
                String name = reader.nextLine();
                Set<String> phones = new HashSet<String>();
                for (Person person : people) {
                    if (person.getName().equals(name)) {
                        for (String phone : person.getPhone()) {
                            phones.add(phone);
                        }
                    }
                }
                if (phones.isEmpty()) {
                    System.out.println("  not found");
                } else {
                    for (String phone : phones) {
                        System.out.println(" " + phone);
                    }
                }
            } else if (command.equals("3")) {
                //search name with phone
                System.out.print("number: ");
                String phone = reader.nextLine();
                for (Person person : people) {
                    if (person.getPhone().contains(phone)) {
                        System.out.println(" " + person.getName());
                    } else {
                        System.out.println(" not found");
                    }
                }
            } else if (command.equals("4")) {
                //add address
                System.out.print("whose address: ");
                String name = reader.nextLine();
                System.out.print("street: ");
                String street = reader.nextLine();
                System.out.print("city: ");
                String city = reader.nextLine();
                String address= street + " " + city;

                //if person name is already in people list, add address to that person
                if (isPersonExists(name)) {
                    for (Person person : people) {
                        if (person.getName().equals(name)) {
                            person.getAddress().add(address);
                        }
                    }
                } else {
                    //if person name is not in people list, create new person
                    Person person = new Person();
                    person.addName(name);
                    person.addAddress(address);
                    people.add(person);
                }
            } else if (command.equals("5")) {
                //search for address and phone with person name
                System.out.print("whose information: ");
                String name = reader.nextLine();

                //if person is in people list
                if (isPersonExists(name)) {
                    for (Person person : people) {
                        //get person
                        if (person.getName().equals(name)) {
                            printPersonInfo(person);
                        }
                    }
                } else {
                    System.out.println("  not found");
                }
            } else if (command.equals("6")) {
                //remove person info
                List<Person> toRemove = new ArrayList<Person>();
                System.out.print("whose information: ");
                String name = reader.nextLine();
                //check if person name is in people list
                if (isPersonExists(name)) {
                    for (Person person : people) {
                        if (person.getName().equals(name)) {
                            toRemove.add(person);
                        }
                    }
                }
                //remove person in people list based on toRemove
                for (Person person : toRemove) {
                    people.remove(person);
                }

            } else if (command.equals("7")) {
                //filtered search
                System.out.print("keyword (if empty, all listed): ");
                String keyword = reader.nextLine();
                int filteredResult = 0;
                //sort by alphabetical order
                Collections.sort(people);
                for (Person person : people) {
                    //print all if keyword is empty
                    if (keyword.equals("")) {
                        System.out.println(person.getName());
                        printPersonInfo(person);
                        filteredResult++;
                    } else if (person.getName().contains(keyword) || person.getPhone().contains(keyword) || isAddressContaining(person.getAddress(), keyword)) {
                        //check if person name or person phone number or person address containing keyword
                        System.out.println("");
                        System.out.println(person.getName());
                        printPersonInfo(person);
                        filteredResult++;
                    }
                }
                if (filteredResult == 0) {
                    System.out.println(" keyword not found");
                }
            } else if (command.equals("x")) {
                break;
            }
        }
    }

    public boolean isPersonExists(String name) {
        for (Person person : people) {
            if (person.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void printPersonInfo(Person person) {
        //get person's address
        if (person.getAddress().isEmpty()) {
            System.out.println("  address unknown");
        } else {
            String addressStatement = "  address: ";
            for (String address : person.getAddress()) {
                addressStatement += address + " ";
            }
            System.out.println(addressStatement);
        }
        //get person's phone
        if (person.getPhone().isEmpty()) {
            System.out.println("  phone number not found");
        } else {
            System.out.println("  phone numbers:");
            for (String phone : person.getPhone()) {
                System.out.println("   " + phone);
            }
        }
    }

    public boolean isAddressContaining(Set<String> personAddress, String keyword) {
        for (String address : personAddress) {
            if (address.contains(keyword)) {
                return true;
            }
        }
        return false;
    }
}
