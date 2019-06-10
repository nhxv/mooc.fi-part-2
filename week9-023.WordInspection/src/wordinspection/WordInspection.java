package wordinspection;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordInspection {

    private File file;

    public WordInspection(File file) throws Exception {
        this.file = file;
    }

    public int wordCount() throws Exception {
        Scanner reader = new Scanner(file);
        int wordCount = 0;
        while (reader.hasNextLine()) {
            reader.nextLine();
            wordCount++;
        }
        return wordCount;
    }

    public List<String> wordsContainingZ() throws Exception {
        Scanner reader = new Scanner(file);
        List<String> wordContainingZ = new ArrayList<String>();
        while (reader.hasNextLine()) {
            String word = reader.nextLine();
            if (word.contains("z")) {
                wordContainingZ.add(word);
            }
        }
        return wordContainingZ;
    }

    public List<String> wordsEndingInL() throws Exception {
        Scanner reader = new Scanner(file);
        List<String> wordsEndingInL = new ArrayList<String>();
        while (reader.hasNextLine()) {
            String word = reader.nextLine();
            if (String.valueOf(word.charAt(word.length() - 1)).equals("l")) {
                wordsEndingInL.add(word);
            }
        }
        return wordsEndingInL;
    }

    public List<String> palindromes() throws Exception{
        Scanner reader = new Scanner(file);
        List<String> palindromes = new ArrayList<String>();
        while(reader.hasNextLine()) {
            String word = reader.nextLine();
            if (isPalindromes(word)) {
                palindromes.add(word);
            }
        }
        return palindromes;
    }

    public boolean isPalindromes(String word) {
        String reverseWord = "";
        for (int i = word.length() - 1; i >= 0; i--) {
            reverseWord += word.charAt(i);
        }
        if (word.equals(reverseWord)) {
            return true;
        } else {
            return false;
        }
    }

    public List<String> wordsWhichContainAllVowels() throws Exception {
        Scanner reader = new Scanner(file);
        List<String> wordsWhichContainAllVowels = new ArrayList<String>();
        while (reader.hasNextLine()) {
            String word = reader.nextLine();
            if (word.contains("a") && word.contains("e") && word.contains("i") && word.contains("o") && word.contains("u") && word.contains("y") && word.contains("ä") && word.contains("ö")) {
                wordsWhichContainAllVowels.add(word);
            }
        }
        return wordsWhichContainAllVowels;
    }

}
