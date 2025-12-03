import java.util.ArrayList;
import java.util.List;

public class Playlist implements Originator {
    private List<Song> songs = new ArrayList<>();

    public void addSong(Song song) {
        songs.add(song);
        System.out.println("Додано: " + song);
    }

    public void removeSong(Song song) {
        if (songs.remove(song)) {
            System.out.println("Видалено: " + song);
        } else {
            System.out.println("Пісню не знайдено: " + song);
        }
    }

    @Override
    public PlaylistMemento save() {
        System.out.println("[Originator] Створення знімка стану");
        return new PlaylistMemento(songs);
    }

    @Override
    public void restore(PlaylistMemento memento) {
        this.songs = memento.getSavedSongs();
        System.out.println("[Originator] Стан відновлено");
    }

    @Override
    public String toString() {
        return "Плейлист: " + songs.toString();
    }
}
