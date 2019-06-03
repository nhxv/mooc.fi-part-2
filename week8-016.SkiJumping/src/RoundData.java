import java.util.HashMap;
import java.util.Map;

public class RoundData {

    private Map<String, Integer> participantNamesAndLengths;

    public RoundData() {
        this.participantNamesAndLengths = new HashMap<String, Integer>();
    }

    public void addParticipantNamesAndLengths(String name, int length) {
        participantNamesAndLengths.put(name, length);
    }

}
