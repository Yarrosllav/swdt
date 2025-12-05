package server;

import common.Song;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MusicServer {
    private static final int PORT = 5000;
    private static List<Song> musicLibrary = new ArrayList<>();

    static {
        musicLibrary.add(new Song("Shape of You", "Ed Sheeran"));
        musicLibrary.add(new Song("Blinding Lights", "The Weeknd"));
        musicLibrary.add(new Song("Bohemian Rhapsody", "Queen"));
    }

    public static void main(String[] args) {
        System.out.println("Сервер запущено на порту " + PORT);
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Новий клієнт підключився: " + clientSocket.getInetAddress());
                new Thread(new ClientHandler(clientSocket, musicLibrary)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
