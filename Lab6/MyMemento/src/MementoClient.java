public class MementoClient {

    public static void main(String[] args) {
        Playlist myPlaylist = new Playlist();
        HistoryKeeper history = new HistoryKeeper(myPlaylist);

        myPlaylist.addSong(new Song("Song 1", "Artist A"));
        myPlaylist.addSong(new Song("Song 2", "Artist B"));
        System.out.println(myPlaylist);

        history.backup();

        myPlaylist.addSong(new Song("Song 3", "Artist C"));
        myPlaylist.removeSong(new Song("Song 1", "Artist A"));

        System.out.println("\nПоточний (зіпсований) стан:");
        System.out.println(myPlaylist);

        System.out.println("\nСкасування змін...");
        history.restoreLastSave();

        System.out.println("\nСтан після відновлення:");
        System.out.println(myPlaylist);
    }

}

