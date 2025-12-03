import java.util.Stack;

public class HistoryKeeper {
    private Stack<PlaylistMemento> history = new Stack<>();
    private Playlist playlist;

    public HistoryKeeper(Playlist playlist) {
        this.playlist = playlist;
    }

    public void backup() {
        history.push(playlist.save());
    }

    public void undo() {
        if (!history.isEmpty()) {
            history.pop();
            if (!history.isEmpty()) {
                playlist.restore(history.peek());
            } else {
                System.out.println("Історія порожня!");
            }
        } else {
            System.out.println("Нічого скасовувати!");
        }
    }

    public void restoreLastSave() {
        if (!history.isEmpty()) {
            playlist.restore(history.pop());
        } else {
            System.out.println("Немає збережених станів!");
        }
    }
}