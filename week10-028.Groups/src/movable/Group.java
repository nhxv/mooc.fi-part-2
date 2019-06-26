package movable;

import java.util.ArrayList;
import java.util.List;

public class Group implements Movable {

    private List<Movable> movableList;

    public Group() {
        movableList = new ArrayList<Movable>();
    }

    public void addToGroup(Movable movable) {
        movableList.add(movable);
    }

    @Override
    public String toString() {
        String str = "";
        for (Movable movable : movableList) {
            str += movable.toString() + "\n";
        }
        return str;
    }
    @Override
    public void move(int dx, int dy) {
        for (Movable movable : movableList) {
            movable.move(dx, dy);
        }
    }
}
