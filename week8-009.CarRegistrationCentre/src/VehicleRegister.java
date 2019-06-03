import java.util.ArrayList;
import java.util.HashMap;

public class VehicleRegister {

    private HashMap<RegistrationPlate, String> owners;

    public VehicleRegister() {
        this.owners = new HashMap<RegistrationPlate, String>();
    }

    public boolean add(RegistrationPlate plate, String owner) {
        if (owners.get(plate) == null) {
            owners.put(plate, owner);
            return true;
        } else {
            return false;
        }
    }

    public String get(RegistrationPlate plate) {
        if (owners.keySet().contains(plate)) {
            return owners.get(plate);
        } else {
            return null;
        }
    }

    public boolean delete(RegistrationPlate plate) {
        if (owners.keySet().contains(plate)) {
            owners.remove(plate);
            return true;
        } else {
            return false;
        }
    }

    public void printRegistrationPlates() {
        for (RegistrationPlate reg : owners.keySet()) {
            System.out.println(reg);
        }
    }

    public void printOwners() {
        ArrayList <String> ownerList = new ArrayList<String>();
        for (RegistrationPlate reg : owners.keySet()) {
            if (!ownerList.contains(owners.get(reg))) {
                ownerList.add(owners.get(reg));
            }
        }
        for (String owner : ownerList) {
            System.out.println(owner);
        }
    }
}
