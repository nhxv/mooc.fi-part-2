import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private Scanner reader;
    private List<Participant> participants;

    public UserInterface(Scanner reader) {
        this.reader = reader;
        this.participants = new ArrayList<Participant>();
    }

    public void run() {
        System.out.println("Kumpula ski jumping week");
        System.out.print("\n");
        System.out.println("Write the names of the participants one at a time; an empty string brings you to the jumping phase.");
        //sign up
        while (true) {
            System.out.print("  Participant name: ");
            String participantName = reader.nextLine();
            if (participantName.equals("")) {
                break;
            }
            participants.add(new Participant(participantName));
        }
        System.out.print("\n");
        System.out.println("The tournament begins!");
        //begin tournament
        int round = 0;
        while (true) {
            System.out.print("\n");
            System.out.print("Write \"jump\" to jump; otherwise you quit: ");
            String command = reader.nextLine();
            if(!command.equals("jump")) {
                break;
            }
            //begin round
            if(command.equals("jump")) {
                round++;
                System.out.println("Round " + round);
                System.out.print("\n");
                //jump order
                Collections.sort(participants);
                System.out.println("Jumping order:");
                int order = 0;
                for (Participant participant : participants) {
                    order++;
                    System.out.println("  " + order + ". " + participant.getName() + " (" + participant.getTotalPoints() + " points)");
                }
                System.out.print("\n");
                //show round result
                System.out.println("Results of round " + round);
                for (Participant participant : participants) {
                    int length = participant.getLength();
                    List<Integer> judgePoints = participant.getJudgePoints();
                    System.out.println("  " + participant.getName());
                    System.out.println("    length: " + length);
                    System.out.println("    judge votes: " + judgePoints);
                    participant.calculateTotalPoints(length, judgePoints);
                }
            }
        }
        //show tournament result
        System.out.print("\n");
        System.out.println("Thanks!");
        System.out.print("\n");
        System.out.println("Tournament results:");
        System.out.println("Position    Name");
        int rank = 0;
        Collections.sort(participants);
        Collections.reverse(participants);
        for (Participant participant : participants) {
            rank++;
            System.out.println(rank + "           " + participant.getName() + " (" + participant.getTotalPoints() + " points)");
            List<Integer> lengthList = participant.getLengthList();
            String lengthResult = "            jump lengths: ";
            for (int length : lengthList) {
                if (lengthList.indexOf(length) != lengthList.size() - 1) {
                    lengthResult += length + " m, ";
                } else {
                    lengthResult += length + " m";
                }
            }
            System.out.println(lengthResult);
        }
    }
}
