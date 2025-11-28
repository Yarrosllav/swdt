public class RewindCommand implements Command {
    private AudioSystem audioSystem;

    public RewindCommand(AudioSystem audioSystem) {
        this.audioSystem = audioSystem;
    }

    @Override
    public void execute() {
        audioSystem.rewind();
    }
}


