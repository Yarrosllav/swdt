import java.util.ArrayList;
import java.util.List;

public class PlaylistMemento {
    private final List<Song> songsState;

    public PlaylistMemento(List<Song> songs) {
        this.songsState = new ArrayList<>(songs);
    }

    public List<Song> getSavedSongs() {
        return songsState;
    }
}

