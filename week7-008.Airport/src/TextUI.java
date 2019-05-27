import java.util.HashMap;
import java.util.Scanner;

public class TextUI {

    private Scanner reader;
    private HashMap <String, Integer> planes; //contain: planesID and capacity
    private HashMap <String[], String> flights; //contain:  [departure, destination] and planesID

    public TextUI(Scanner reader) {
        this.reader = reader;
        this.planes = new HashMap<String, Integer>();
        this.flights = new HashMap<String[], String>();
    }

    public void airportPanel() {
        System.out.println("Airport panel\n" +
                "--------------------\n");
        while (true) {
            System.out.println(
                    "Choose operation:\n" +
                    "[1] Add airplane\n" +
                    "[2] Add flight\n" +
                    "[x] Exit");

            String operation = reader.nextLine();
            if (operation.equals("1")) {
                System.out.print("Give plane ID: ");
                String planeID = reader.nextLine();
                System.out.print("Give plane capacity: ");
                int capacity = Integer.parseInt(reader.nextLine());
                planes.put(planeID, capacity);

            } else if (operation.equals("2")) {
                System.out.print("Give plane ID: ");
                String planeID = reader.nextLine();
                System.out.print("Give departure airport code: ");
                String departureCode = reader.nextLine();
                System.out.print("Give destination airport code: ");
                String destinationCode = reader.nextLine();
                String[] codes = new String[2];
                codes[0] = departureCode;
                codes[1] = destinationCode;
                flights.put(codes, planeID);

            } else if (operation.equals("x")) {
                break;
            }
        }
    }

    public void flightPanel() {
        System.out.println("Flight service\n" +
                        "------------\n\n");
        while(true) {
            System.out.println("Flight service\n" +
                    "------------\n\n" +
                    "Choose operation:\n" +
                    "[1] Print planes\n" +
                    "[2] Print flights\n" +
                    "[3] Print plane info\n" +
                    "[x] Quit");

            String operation = reader.nextLine();
            if (operation.equals("1")) {
                printPlanes();
            } else if (operation.equals("2")) {
                printFlights();
            } else if (operation.equals("3")) {
                System.out.print("Give plane ID: ");
                String id = reader.nextLine();
                printPlaneInfo(id);
            } else if (operation.equals("x")) {
                break;
            }
        }
    }

    public void printPlanes() {
        for (String planeID : planes.keySet()) {
            System.out.println(planeID + " (" + planes.get(planeID) + " ppl)");
        }
    }

    public void printFlights() {
        for (String[] codes : flights.keySet()) {
            System.out.println(
                    flights.get(codes) + " (" + planes.get(flights.get(codes)) + " ppl) "
                            + "(" + codes[0] + "-" + codes[1] + ")"
            );
        }
    }

    public void printPlaneInfo(String id) {
        for (String planeID : planes.keySet()) {
            if (planeID.equals(id)) {
                System.out.println(planeID +  " (" + planes.get(planeID) + " ppl)");
            }
        }
    }

}
