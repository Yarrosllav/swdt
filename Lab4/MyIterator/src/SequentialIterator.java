public class SequentialIterator implements MusicIterator {
    private Playlist playlist;
    private int current;

    public SequentialIterator(Playlist playlist) {
        this.playlist = playlist;
        this.current = 0;
    }

    @Override
    public void first() {
        current = 0;
    }

    @Override
    public void next() {
        current++;
    }

    @Override
    public boolean isDone() {
        return current >= playlist.size();
    }

    @Override
    public Song currentItem() {
        if (isDone()) return null;
        return playlist.getSong(current);
    }
}
