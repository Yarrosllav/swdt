package client;

import common.Song;
import java.io.*;
import java.net.Socket;
import java.util.List;

public class MusicClient {
    private Socket socket;
    private ObjectOutputStream out;
    private ObjectInputStream in;

    public void connect(String host, int port) throws IOException {
        socket = new Socket(host, port);
        out = new ObjectOutputStream(socket.getOutputStream());
        in = new ObjectInputStream(socket.getInputStream());
    }

    public List<Song> getSongList() throws IOException, ClassNotFoundException {
        out.writeObject("LIST");
        out.flush();
        return (List<Song>) in.readObject();
    }

    public String playSong(String title) throws IOException, ClassNotFoundException {
        out.writeObject("PLAY:" + title);
        out.flush();
        return (String) in.readObject();
    }

    public void disconnect() throws IOException {
        out.writeObject("EXIT");
        socket.close();
    }
}
