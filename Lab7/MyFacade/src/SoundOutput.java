class SoundOutput {
    public void initDriver() {
        System.out.println("   [SoundOutput] Підключення до аудіо-драйвера ОС");
    }

    public void playStream() {
        System.out.println("   [SoundOutput] ВІДТВОРЕННЯ ЗВУКУ ");
    }

    public void stopStream() {
        System.out.println("   [SoundOutput] Зупинка драйвера.");
    }
}

