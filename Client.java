/**
 * Java. Level 2. Lesson 6. Homework
 *
 * @author Andry Krasikov
 * @version Oct 25, 2018
 */

package client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class Client {
    static Socket sock = null;
    static PrintWriter out = null;
    static Scanner in = null;

    public static void main(String[] args) {
        final String SERVER_ADDR = "localhost";
        final int SERVER_PORT = 8983;

        try {
            sock = new Socket(SERVER_ADDR, SERVER_PORT);
            System.out.println("Мы подключились к серверу");
            out = new PrintWriter(sock.getOutputStream(), true);
            in = new Scanner(sock.getInputStream());

        } catch (IOException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            try {
                while (true) {
                    if (in.hasNext()) {
                        String w = in.nextLine();
                        if (w.equalsIgnoreCase("end session")) break;
                        System.out.println("Сообщение от сервера: " + w);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    sock.close();
                    out.close();
                    in.close();
                } catch (IOException exc) {
                }
            }
        }).start();

        new Thread(() -> {
            try {
                Scanner input = new Scanner(System.in);
                while (true) {
                    if (input.hasNext()) {
                        out.println(input.nextLine());
                        out.flush();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}
