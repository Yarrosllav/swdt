public class VisitorClient {

    public static void main(String[] args) {
        MediaLibrary library = new MediaLibrary();
        library.add(new Song("Bohemian Rhapsody", "Queen", 5.5));
        library.add(new Podcast("Tech Talk", 42, 45.0));
        library.add(new VideoClip("Thriller", "1080p", 120.0));
        library.add(new Song("Imagine", "John Lennon", 3.2));

        System.out.println("- Exporting to XML -");
        Visitor exportVisitor = new XmlExportVisitor();
        System.out.println("<library>");
        library.accept(exportVisitor);
        System.out.println("</library>");

        System.out.println("\n- Calculating Statistics -");
        SizeCalculatorVisitor calcVisitor = new SizeCalculatorVisitor();
        library.accept(calcVisitor);
        System.out.println("Total library size: " + calcVisitor.getTotalSize() + " MB");
    }

}


