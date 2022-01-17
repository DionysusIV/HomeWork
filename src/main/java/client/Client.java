package client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    final String SERVER_ADDRESS = "localhost";
    final int SERVER_PORT = 9000;
    Socket socket;
    Scanner in, console;
    PrintWriter out;

    public Client() {

        try {
            socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            in = new Scanner(socket.getInputStream());
            out = new PrintWriter(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }


        new Thread(() -> {
            try {
                while (true) {
                    if (in.hasNext()) {
                        String w = in.nextLine();
                        if (w.equalsIgnoreCase("end session")) break;
                        System.out.println(w);
                    }
                }
            } catch (Exception e) {
                System.out.println("Good bye!");
            }
        }).start();

        startMessaging();
    }


    public void startMessaging() {
        String message;
        console = new Scanner(System.in);
        System.out.println("Enter message:");

        while (true) {
            message = console.next();
            out.println(message);
            out.flush();
            if (message.equalsIgnoreCase("END")) {
                try {
                    console.close();
                    out.close();
                    in.close();
                    socket.close();
                    return;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
