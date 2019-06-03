import java.util.Objects;

public class CD implements ToBeStored {

    private String artist;
    private String title;
    private int yearPublishing;
    private double weight;

    public CD(String artist, String title, int yearPublishing) {
        this.artist = artist;
        this.title = title;
        this.yearPublishing = yearPublishing;
        this.weight = 0.1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CD cd = (CD) o;
        return yearPublishing == cd.yearPublishing &&
                Double.compare(cd.weight, weight) == 0 &&
                Objects.equals(artist, cd.artist) &&
                Objects.equals(title, cd.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(artist, title, yearPublishing, weight);
    }

    @Override
    public double weight() {
        return this.weight;
    }

    @Override
    public String toString() {
        return this.artist + ": " + this.title + " (" + this.yearPublishing + ")";
    }
}
