public class MusicPlayerFacade {
    private AudioLoader loader;
    private Codec codec;
    private AudioMixer mixer;
    private SoundOutput output;

    public MusicPlayerFacade() {
        this.loader = new AudioLoader();
        this.codec = new Codec();
        this.mixer = new AudioMixer();
        this.output = new SoundOutput();
    }

    public void playMusic(String filename, String format) {
        System.out.println("Фасад: Початок процедури запуску музики");
        loader.loadFile(filename);
        codec.decode(format);
        mixer.fixEqualizer();
        output.initDriver();
        output.playStream();

        System.out.println("Фасад: Музика успішно грає\n");
    }

    public void stopMusic() {
        System.out.println("Фасад: Запит на зупинку");
        output.stopStream();
    }
}