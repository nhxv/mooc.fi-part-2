package dictionary;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PersonalMultipleEntryDictionary implements MultipleEntryDictionary {

    private Map<String, Set> translation;

    public PersonalMultipleEntryDictionary() {
        this.translation = new HashMap<String, Set>();
    }


    @Override
    public void add(String word, String entry) {
        if (translation.containsKey(word)) {
            translation.get(word).add(entry);
        } else {
            translation.put(word, new HashSet<String>());
            translation.get(word).add(entry);
        }
    }

    @Override
    public Set<String> translate(String word) {
        if (!translation.containsKey(word)) {
            return null;
        } else {
            return translation.get(word);
        }
    }

    @Override
    public void remove(String word) {
        if (translation.containsKey(word)) {
            translation.remove(word);
        }
    }
}
