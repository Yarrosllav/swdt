public class StopCommand implements Command {
    private AudioSystem audioSystem;

    public StopCommand(AudioSystem audioSystem) {
        this.audioSystem = audioSystem;
    }

    @Override
    public void execute() {
        audioSystem.stopPlaying();
    }
}

