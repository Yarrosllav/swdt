package server;

import common.Song;
import java.io.*;
import java.net.Socket;
import java.util.List;

public class ClientHandler implements Runnable {
    private Socket socket;
    private List<Song> library;

    public ClientHandler(Socket socket, List<Song> library) {
        this.socket = socket;
        this.library = library;
    }

    @Override
    public void run() {
        try (
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream())
        ) {
            while (true) {
                String command = (String) in.readObject();

                if ("LIST".equalsIgnoreCase(command)) {
                    out.writeObject(library);
                    out.flush();
                }
                else if (command.startsWith("PLAY:")) {
                    String songTitle = command.split(":")[1];
                    out.writeObject("STREAMING_DATA_FOR: " + songTitle);
                    out.flush();
                }
                else if ("EXIT".equalsIgnoreCase(command)) {
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Клієнт відключився.");
        }
    }
}
