import java.io.Serializable;

public abstract class Track implements Serializable {
    private String title;
    private String artist;
    private int duration;

    public Track(String title, String artist, int duration) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }

    public String getTitle() { return title; }
    public String getArtist() { return artist; }
    public int getDuration() { return duration; }

    public void setTitle(String title) { this.title = title; }
    public void setArtist(String artist) { this.artist = artist; }
    public void setDuration(int duration) { this.duration = duration; }

    public abstract String getType();

    @Override
    public String toString() {
        return String.format("[%s] %s - %s (%d сек)", getType(), artist, title, duration);
    }
}