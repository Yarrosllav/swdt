import java.util.ArrayList;
import java.util.List;

public class MediaLibrary {
    private List<MediaElement> elements = new ArrayList<>();

    public void add(MediaElement e) {
        elements.add(e);
    }

    public void accept(Visitor v) {
        for (MediaElement element : elements) {
            element.accept(v);
        }
    }
}

