public interface MusicIterator {
    void first();
    void next();
    boolean isDone();
    Song currentItem();
}