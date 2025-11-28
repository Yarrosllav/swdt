public class PlayerControlPanel {
    private Command playButton;
    private Command stopButton;
    private Command rewindButton;

    public void setPlayCommand(Command playButton) {
        this.playButton = playButton;
    }

    public void setStopCommand(Command stopButton) {
        this.stopButton = stopButton;
    }

    public void setRewindCommand(Command rewindButton) {
        this.rewindButton = rewindButton;
    }

    public void pressPlay() {
        System.out.print("Натиснуто Play: ");
        if (playButton != null) playButton.execute();
    }

    public void pressStop() {
        System.out.print("Натиснуто Stop: ");
        if (stopButton != null) stopButton.execute();
    }

    public void pressRewind() {
        System.out.print("Натиснуто Rewind: ");
        if (rewindButton != null) rewindButton.execute();
    }
}

