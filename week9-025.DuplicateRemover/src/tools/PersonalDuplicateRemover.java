package tools;

import java.util.HashSet;
import java.util.Set;

public class PersonalDuplicateRemover implements DuplicateRemover {

    private Set<String> uniqueCharacterStrings;
    private int count;

    public PersonalDuplicateRemover() {
        this.uniqueCharacterStrings = new HashSet<String>();
        this.count = 0;
    }

    @Override
    public void add(String characterString) {
        if (!uniqueCharacterStrings.add(characterString)) {
            count++;
        } else {
            uniqueCharacterStrings.add(characterString);
        }
    }

    @Override
    public int getNumberOfDetectedDuplicates() {
        return this.count;
    }

    @Override
    public Set<String> getUniqueCharacterStrings() {
        return uniqueCharacterStrings;
    }

    @Override
    public void empty() {
        this.count = 0;
        uniqueCharacterStrings.clear();
    }
}
