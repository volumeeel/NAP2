public class Album extends Track {
    private int trackCount;

    public Album(String title, String artist, int duration, int trackCount) {
        super(title, artist, duration);
        this.trackCount = trackCount;
    }

    public int getTrackCount() { return trackCount; }
    public void setTrackCount(int trackCount) { this.trackCount = trackCount; }

    @Override
    public String getType() { return "Album"; }

    @Override
    public String toString() {
        return super.toString() + ", треков: " + trackCount;
    }
}