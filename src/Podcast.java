public class Podcast extends Track {
    private String host;

    public Podcast(String title, String artist, int duration, String host) {
        super(title, artist, duration);
        this.host = host;
    }

    public String getHost() { return host; }
    public void setHost(String host) { this.host = host; }

    @Override
    public String getType() { return "Podcast"; }

    @Override
    public String toString() {
        return super.toString() + ", ведущий: " + host;
    }
}