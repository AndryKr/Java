/**
 * Java. Level 2. Lesson 6. Homework
 *
 * @author Andry Krasikov
 * @version Oct 25, 2018
 */

package server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class Server {
    static ServerSocket serv = null;
    static Socket sock = null;
    static PrintWriter pw = null;

    public static void main(String[] args) {

        try {
            serv = new ServerSocket(8983);
            System.out.println("Сервер запущен!");
            sock = serv.accept();
            System.out.println("Клиент подключился");
            pw = new PrintWriter(sock.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            try {
                Scanner sc = new Scanner(sock.getInputStream());
                while (true) {
                    String str = sc.nextLine();
                    if (str.equals("/end")) {
                        sendEndSession();
                        break;
                    }
                    System.out.println("Сообщение от клиента: " + str);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            finally {
                serverClose();
                socketClose();
            }
        }).start();

        new Thread(() -> {
            try {
                Scanner input = new Scanner(System.in);
                while (true) {
                    if (input.hasNext()) {
                        pw.println(input.nextLine());
                        pw.flush();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

    private static void serverClose(){
        try {
            serv.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void socketClose(){
        try {
            sock.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void sendEndSession(){
        pw.println("end session");
        pw.flush();
    }
}
