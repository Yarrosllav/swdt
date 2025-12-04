public class FacadeClient {
    public static void main(String[] args) {
        MusicPlayerFacade player = new MusicPlayerFacade();

        player.playMusic("best_song_ever.mp3", "mp3");

        try { Thread.sleep(2000); } catch (InterruptedException e) { }

        player.stopMusic();
    }
}

