import java.util.ArrayList;

public class Changer {

    private ArrayList<Change> changes = new ArrayList<Change>();

    public Changer() {

    }

    public  void addChange(Change change) {
        changes.add(change);
    }

    public String change(String characterString) {
        for (Change change : changes) {
            characterString = change.change(characterString);
        }
        return characterString;
    }
}
