import java.util.Scanner;

public class Reader {

    private Scanner reader;

    public Reader() {
        this.reader = new Scanner(System.in);
    }

    public String readString() {
        String stringReader = this.reader.nextLine();
        return stringReader;
    }

    public int readInteger() {
        int intReader = Integer.parseInt(this.reader.nextLine());
        return intReader;
    }


}
