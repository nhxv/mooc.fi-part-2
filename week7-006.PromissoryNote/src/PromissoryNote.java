import java.util.HashMap;

public class PromissoryNote {

    private HashMap<String, Double> promissoryNote;

    public PromissoryNote() {
        promissoryNote = new HashMap<String, Double>();
    }

    public void setLoan(String toWhom, double value) {
        promissoryNote.put(toWhom, value);
    }

    public double howMuchIsTheDebt(String whose) {
        if (promissoryNote.keySet().contains(whose)) {
            return promissoryNote.get(whose);
        }
        return 0;
    }
}
