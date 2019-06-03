import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Participant implements Comparable<Participant> {

    private String name;
    private List<Integer> lengthList;
    private int totalPoints;

    public Participant(String name) {
        this.name = name;
        this.lengthList = new ArrayList<Integer>();
        this.totalPoints = 0;
    }

    public String getName() {
        return this.name;
    }

    public List<Integer> getLengthList() {
        return this.lengthList;
    }

    public int getLength() {
        int length = 0;
        int max = 120;
        int min = 60;
        length = (int)(Math.random() * ((max - min) + 1)) + min;
        lengthList.add(length);
        return length;
    }

    public List<Integer> getJudgePoints() {
        List<Integer> judgePoints = new ArrayList<Integer>();
        int max = 20;
        int min = 10;
        for (int i = 0; i < 5; i++) {
            judgePoints.add((int)(Math.random() * ((max - min) + 1)) + min);
        }
        return judgePoints;
    }

    public void calculateTotalPoints(int length, List<Integer> judgePoints) {
        judgePoints.remove(Collections.max(judgePoints));
        judgePoints.remove(Collections.min(judgePoints));
        totalPoints += length;
        for (int points : judgePoints) {
            totalPoints += points;
        }
    }

    public int getTotalPoints() {
        return this.totalPoints;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return totalPoints == that.totalPoints &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, totalPoints);
    }

    @Override
    public int compareTo(Participant participant) {
        return this.totalPoints - participant.getTotalPoints();
    }
}
