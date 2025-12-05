package common;

import java.io.Serializable;

public class Song implements Serializable {
    private static final long serialVersionUID = 1L;
    private String title;
    private String artist;

    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title + " - " + artist;
    }
}

