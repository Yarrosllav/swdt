public class Podcast implements MediaElement {
    private String title;
    private int episodeNr;
    private double sizeMb;

    public Podcast(String title, int episodeNr, double sizeMb) {
        this.title = title;
        this.episodeNr = episodeNr;
        this.sizeMb = sizeMb;
    }

    public String getTitle() { return title; }
    public int getEpisodeNr() { return episodeNr; }
    public double getSizeMb() { return sizeMb; }

    @Override
    public void accept(Visitor v) {
        v.visitPodcast(this);
    }
}

