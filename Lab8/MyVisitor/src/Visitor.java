public interface Visitor {
    void visitSong(Song s);
    void visitPodcast(Podcast p);
    void visitVideoClip(VideoClip v);
}

