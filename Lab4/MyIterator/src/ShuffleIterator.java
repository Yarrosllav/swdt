import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShuffleIterator implements MusicIterator {
    private Playlist playlist;
    private int current;
    private List<Integer> shuffledIndices;

    public ShuffleIterator(Playlist playlist) {
        this.playlist = playlist;
        first();
    }

    @Override
    public void first() {
        current = 0;
        shuffledIndices = new ArrayList<>();
        for (int i = 0; i < playlist.size(); i++) {
            shuffledIndices.add(i);
        }
        Collections.shuffle(shuffledIndices);
    }

    @Override
    public void next() {
        current++;
    }

    @Override
    public boolean isDone() {
        return current >= shuffledIndices.size();
    }

    @Override
    public Song currentItem() {
        if (isDone()) return null;
        int realIndex = shuffledIndices.get(current);
        return playlist.getSong(realIndex);
    }
}