public class Smileys {

    public static void main(String[] args) {
        printWithSmileys("Interface");
        System.out.println("Mikael".length());
    }

    private static void printWithSmileys(String characterString) {
        if (isEven(characterString)) {
            printFinal(characterString);
        } else {
            characterString += " ";
            printFinal(characterString);
        }
    }

    private static void printFinal(String characterString) {
        String middleString = ":)" + " " + characterString + " " + ":)";
        printSmiley(characterString.length());
        System.out.println(middleString);
        printSmiley(characterString.length());
    }

    private static boolean isEven(String characterString) {
        if (characterString.length() % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    private static void printSmiley(int length) {
        String smiley = ":)";
        for (int i = 0; i < ((length/2) + 3); i++) {
            if (i == ((length/2) + 2)) {
                System.out.print(smiley + "\n");
            } else {
                System.out.print(smiley);
            }

        }
    }
}