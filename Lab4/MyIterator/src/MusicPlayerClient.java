public class MusicPlayerClient {
    public static void main(String[] args) {
        Playlist myPlaylist = new Playlist();
        myPlaylist.addSong(new Song("Billie Jean", "Michael Jackson"));
        myPlaylist.addSong(new Song("Imagine", "John Lennon"));
        myPlaylist.addSong(new Song("Smells Like Teen Spirit", "Nirvana"));
        myPlaylist.addSong(new Song("Shape of My Heart", "Sting"));

        System.out.println("--- Normal Playback ---");
        MusicIterator normalIterator = myPlaylist.createIterator();

        for (normalIterator.first(); !normalIterator.isDone(); normalIterator.next()) {
            System.out.println("Playing: " + normalIterator.currentItem());
        }

        System.out.println("\n--- Shuffle Playback ---");
        MusicIterator shuffleIterator = myPlaylist.createShuffleIterator();

        for (shuffleIterator.first(); !shuffleIterator.isDone(); shuffleIterator.next()) {
            System.out.println("Playing: " + shuffleIterator.currentItem());
        }

        System.out.println("\n--- Checking original order ---");
        normalIterator.first();
        System.out.println("First song is: " + normalIterator.currentItem().getTitle());
    }
}