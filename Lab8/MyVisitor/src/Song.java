public class Song implements MediaElement {
    private String title;
    private String artist;
    private double sizeMb;

    public Song(String title, String artist, double sizeMb) {
        this.title = title;
        this.artist = artist;
        this.sizeMb = sizeMb;
    }

    public String getTitle() { return title; }
    public String getArtist() { return artist; }
    public double getSizeMb() { return sizeMb; }

    @Override
    public void accept(Visitor v) {
        v.visitSong(this);
    }
}
