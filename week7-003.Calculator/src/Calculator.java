import java.lang.reflect.Array;

public class Calculator {

    private Reader reader;
    private int counter;

    public Calculator() {
        this.reader = new Reader();
        this.counter = 0;
    }

    public void start() {
        while(true) {
            System.out.print("command: ");
            String command = reader.readString();
            if (command.equals("end")) {
                break;
            }

            if (command.equals("sum")) {
                sum();
                this.counter++;
            } else if (command.equals("difference")) {
                difference();
                this.counter++;
            } else if (command.equals("product")) {
                product();
                this.counter++;
            }
        }

        statistics();
    }

    private int[] readValues() {
        int[] arrayValues = new int[2];
        System.out.print("value1: ");
        arrayValues[0] = reader.readInteger();
        System.out.print("value2: ");
        arrayValues[1] = reader.readInteger();
        return arrayValues;
    }

    private void sum() {
        int[] arrayValues = readValues();
        int sum = arrayValues[0] + arrayValues[1];
        System.out.println("sum of the values " + sum);
    }

    private void difference() {
        int[] arrayValues = readValues();
        int difference = arrayValues[0] - arrayValues[1];
        System.out.println("difference of the values " + difference);
    }

    private void product() {
        int[] arrayValues = readValues();
        int product = arrayValues[0] * arrayValues[1];
        System.out.println("product of the values " + product);
    }

    private void statistics() {
        System.out.println("Calculations done " + this.counter);
    }
}
