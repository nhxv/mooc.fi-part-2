import java.util.ArrayList;
import java.util.HashMap;

public class Dictionary {

    private HashMap<String, String> dictionary;

    public Dictionary() {
        this.dictionary = new HashMap<String, String>();
    }

    public void add(String word, String translation) {
        dictionary.put(word, translation);
    }

    public String translate(String word) {
        if (dictionary.keySet().contains(word)) {
            return dictionary.get(word);
        }
        return null;
    }

    public ArrayList<String> translationList() {
        ArrayList<String> translationList = new ArrayList<String>();
        for (String word : dictionary.keySet()) {
            String translatePair = word + " = " + dictionary.get(word);
            translationList.add(translatePair);
        }
        return translationList;
    }

    public void printList() {
        System.out.println(this.dictionary);
    }

    public int amountOfWords() {
        return dictionary.size();
    }

}
