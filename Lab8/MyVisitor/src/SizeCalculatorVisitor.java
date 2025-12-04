public class SizeCalculatorVisitor implements Visitor {
    private double totalSize = 0;

    @Override
    public void visitSong(Song s) {
        totalSize += s.getSizeMb();
    }

    @Override
    public void visitPodcast(Podcast p) {
        totalSize += p.getSizeMb();
    }

    @Override
    public void visitVideoClip(VideoClip v) {
        totalSize += v.getSizeMb();
    }

    public double getTotalSize() {
        return totalSize;
    }
}


