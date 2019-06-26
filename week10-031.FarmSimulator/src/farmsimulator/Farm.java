package farmsimulator;

import java.util.ArrayList;
import java.util.List;

public class Farm implements Alive {

    private String owner;
    private Barn barn;
    private List<Cow> herd;

    public Farm(String owner, Barn barn) {
        this.owner = owner;
        this.barn = barn;
        this.herd = new ArrayList<Cow>();
    }

    public String getOwner() {
        return owner;
    }

    public void addCow(Cow cow) {
        herd.add(cow);
    }

    public void manageCows() {
        barn.takeCareOf(herd);
    }

    public void installMilkingRobot(MilkingRobot milkingRobot) {
        barn.installMilkingRobot(milkingRobot);
    }

    @Override
    public void liveHour() {
        if (herd.size() > 0) {
            for (Cow cow : herd) {
                cow.liveHour();
            }
        }
    }

    @Override
    public String toString() {
        String statement = "Farm owner: " + this.owner + "\n"
                + "Barn bulk tank: " + this.barn.toString() + "\n";
        if (herd.size() == 0) {
            statement += "No cows.";
            return statement;
        }

        statement += "Animals:"  + "\n";
        for (Cow cow : herd) {
            statement += "        " + cow.toString() + "\n";
        }
        return statement;
    }
}
