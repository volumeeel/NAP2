public class Song extends Track {
    private String genre;

    public Song(String title, String artist, int duration, String genre) {
        super(title, artist, duration);
        this.genre = genre;
    }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    @Override
    public String getType() { return "Song"; }

    @Override
    public String toString() {
        return super.toString() + ", жанр: " + genre;
    }
}