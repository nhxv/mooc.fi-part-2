public class Main {

    public static void main(String[] args) {
        Container container = new Container(1000);
        addSuitcasesFullOfBricks(container);
        System.out.println(container);
    }

    public static void addSuitcasesFullOfBricks(Container container) {
        int brickWeight = 1;
        for (int i = 0; i < 100; i++) {
            Thing brick = new Thing("Brick", brickWeight);
            Suitcase suitcase = new Suitcase(100);
            suitcase.addThing(brick);
            container.addSuitcase(suitcase);
            brickWeight++;
        }
    }
}
