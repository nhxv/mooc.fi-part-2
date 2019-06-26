import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RingingCentre {

    private Map<Bird, List<String>> observationInfo;

    public RingingCentre() {
        this.observationInfo = new HashMap<Bird, List<String>>();
    }

    public void observe(Bird bird, String place) {
        if (!observationInfo.keySet().contains(bird)) {
            observationInfo.put(bird, new ArrayList<String>());
            observationInfo.get(bird).add(place);
        } else {
            observationInfo.get(bird).add(place);
        }
    }

    public void observations(Bird bird) {
        if (observationInfo.keySet().contains(bird)) {
            System.out.println(bird + " observations: " + observationInfo.get(bird).size());
            for (String place : observationInfo.get(bird)) {
                System.out.println(place);
            }
        } else {
            System.out.println(bird + " observations: 0");
        }

    }
}
