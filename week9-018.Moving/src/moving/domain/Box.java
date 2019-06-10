package moving.domain;

import java.util.ArrayList;
import java.util.List;

public class Box implements Thing {

    private int maximumCapacity;
    private List<Thing> thingsInside;

    public Box(int maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
        this.thingsInside = new ArrayList<Thing>();
    }
    public boolean addThing(Thing thing) {
        //if box is not empty
        if (!thingsInside.isEmpty()) {
            //check whether box current volume + thing volume exceed max capacity or not
            if (this.getVolume() + thing.getVolume() <= maximumCapacity) {
                thingsInside.add(thing);
                return true;
            } else {
                return false;
            }
        } else {
            //if box is empty, check whether thing is larger than max capacity or not
            if (thing.getVolume() <= maximumCapacity) {
                thingsInside.add(thing);
                return true;
            } else {
                return false;
            }
        }
    }

    public void addToBox(Thing thing) {
        thingsInside.add(thing);
    }

    public List<Thing> getThingsInside() {
        return thingsInside;
    }
    @Override
    public int getVolume() {
        int boxVolume = 0;
        for (Thing stuff : thingsInside) {
            boxVolume += stuff.getVolume();
        }
        return boxVolume;
    }
}
