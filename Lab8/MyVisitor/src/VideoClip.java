public class VideoClip implements MediaElement {
    private String title;
    private String resolution;
    private double sizeMb;

    public VideoClip(String title, String resolution, double sizeMb) {
        this.title = title;
        this.resolution = resolution;
        this.sizeMb = sizeMb;
    }

    public String getTitle() { return title; }
    public String getResolution() { return resolution; }
    public double getSizeMb() { return sizeMb; }

    @Override
    public void accept(Visitor v) {
        v.visitVideoClip(this);
    }
}

