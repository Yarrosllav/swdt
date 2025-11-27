import java.util.ArrayList;
import java.util.List;

public class Playlist implements Aggregate {
    private List<Song> songs = new ArrayList<>();

    public void addSong(Song song) {
        songs.add(song);
    }

    public int size() {
        return songs.size();
    }

    public Song getSong(int index) {
        return songs.get(index);
    }

    @Override
    public MusicIterator createIterator() {
        return new SequentialIterator(this);
    }

    public MusicIterator createShuffleIterator() {
        return new ShuffleIterator(this);
    }
}