import java.util.ArrayList;
import java.util.List;

public class TournamentData {

    private List<Participant> participants;

    public TournamentData() {
        this.participants = new ArrayList<Participant>();
    }

    public void addParticipant(String name) {
        participants.add(new Participant(name));
    }

    public List<Participant> getParticipants() {
        return this.participants;
    }
}
