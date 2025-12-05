package client;

import common.Song;
import java.util.List;
import java.util.Scanner;

public class ClientApp {
    public static void main(String[] args) {
        MusicClient client = new MusicClient();
        try {
            System.out.println("Підключення до сервера");
            client.connect("localhost", 5000);
            System.out.println("Підключено!");

            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("\n- MENU -");
                System.out.println("1. Список пісень");
                System.out.println("2. Грати пісню");
                System.out.println("3. Вихід");
                System.out.print("Вибір: ");

                String choice = scanner.nextLine();

                if ("1".equals(choice)) {
                    List<Song> songs = client.getSongList();
                    System.out.println("Пісні на сервері:");
                    for (Song s : songs) System.out.println(" - " + s);
                }
                else if ("2".equals(choice)) {
                    System.out.print("Введіть назву: ");
                    String title = scanner.nextLine();
                    String response = client.playSong(title);
                    System.out.println("Сервер: " + response);
                }
                else if ("3".equals(choice)) {
                    client.disconnect();
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
