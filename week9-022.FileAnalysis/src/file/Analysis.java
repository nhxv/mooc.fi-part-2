package file;

import java.io.File;
import java.util.Scanner;

public class Analysis {

    private File file;

    public Analysis(File file) throws Exception {
        this.file = file;
    }

    public int lines() throws Exception {
        Scanner reader = new Scanner(this.file);
        int countLine = 0;
        while (reader.hasNextLine()) {
            reader.nextLine();
            countLine++;
        }
        return countLine;
    }

    public int characters() throws Exception {
        Scanner reader = new Scanner(file);
        int countChar = 0;
        while (reader.hasNextLine()) {
            reader.nextLine();
            for (int i = 0; i < line.length(); i++) {
                countChar++;
            }
        }
        return countChar + lines();
    }

}
