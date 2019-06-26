package farmsimulator;

public class MilkingRobot {

    private BulkTank tank;

    public MilkingRobot() {

    }

    public void setBulkTank(BulkTank tank) {
        this.tank = tank;
    }

    public BulkTank getBulkTank() {
        if (this.tank == null) {
            return null;
        }
        return this.tank;
    }

    public void milk(Milkable milkable) {
        if (this.tank == null) {
            throw new java.lang.IllegalStateException("The MilkingRobot hasn't been installed");
        }
        tank.addToTank(milkable.milk());
    }
}
