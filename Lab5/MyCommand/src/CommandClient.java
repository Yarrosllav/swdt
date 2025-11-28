public class CommandClient {
    public static void main(String[] args) {
        AudioSystem myAudio = new AudioSystem();

        Command play = new PlayCommand(myAudio);
        Command stop = new StopCommand(myAudio);
        Command rewind = new RewindCommand(myAudio);

        PlayerControlPanel remote = new PlayerControlPanel();

        remote.setPlayCommand(play);
        remote.setStopCommand(stop);
        remote.setRewindCommand(rewind);

        System.out.println("- Тестування пульта -");
        remote.pressPlay();
        remote.pressRewind();
        remote.pressStop();
    }
}

