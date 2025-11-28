public class PlayCommand implements Command {
    private AudioSystem audioSystem;

    public PlayCommand(AudioSystem audioSystem) {
        this.audioSystem = audioSystem;
    }

    @Override
    public void execute() {
        audioSystem.startPlaying();
    }
}
