public class Playlist {
    private Long id;
    private String name;

    // Getters, Setters and toString() for display in ListView
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @Override
    public String toString() {
        return name;
    }
}
