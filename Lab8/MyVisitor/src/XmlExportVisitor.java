public class XmlExportVisitor implements Visitor {
    @Override
    public void visitSong(Song s) {
        System.out.println("  <song>");
        System.out.println("    <title>" + s.getTitle() + "</title>");
        System.out.println("    <artist>" + s.getArtist() + "</artist>");
        System.out.println("  </song>");
    }

    @Override
    public void visitPodcast(Podcast p) {
        System.out.println("  <podcast>");
        System.out.println("    <title>" + p.getTitle() + "</title>");
        System.out.println("    <episode>" + p.getEpisodeNr() + "</episode>");
        System.out.println("  </podcast>");
    }

    @Override
    public void visitVideoClip(VideoClip v) {
        System.out.println("  <video>");
        System.out.println("    <title>" + v.getTitle() + "</title>");
        System.out.println("    <resolution>" + v.getResolution() + "</resolution>");
        System.out.println("  </video>");
    }
}

