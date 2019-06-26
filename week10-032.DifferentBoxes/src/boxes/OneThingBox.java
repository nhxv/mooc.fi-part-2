package boxes;

import java.util.ArrayList;
import java.util.List;

public class OneThingBox extends Box {
    private List<Thing> oneInBox;

    public OneThingBox() {
        this.oneInBox = new ArrayList<Thing>();
    }

    @Override
    public void add(Thing thing) {
        if (oneInBox.size() < 1) {
            oneInBox.add(thing);
        }
    }

    @Override
    public boolean isInTheBox(Thing thing) {
        if (oneInBox.contains(thing)) {
            return true;
        } else {
            return false;
        }
    }
}
