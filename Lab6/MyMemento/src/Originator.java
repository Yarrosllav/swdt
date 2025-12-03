public interface Originator {
    PlaylistMemento save();

    void restore(PlaylistMemento memento);
}

