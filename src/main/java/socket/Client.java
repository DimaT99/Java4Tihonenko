package socket;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket()) {
            socket.connect(new InetSocketAddress(InetAddress.getLocalHost(), 48080), 1000);
            Scanner scannerClient = new Scanner(socket.getInputStream());
            if(scannerClient.next().equals("black")) {
                System.out.println("IP in blacklist");
                System.exit(5);
            }
            System.out.println("Welcome");
            do {
                System.out.println("Work is allowed. Enter a message or \"exit\" to exit");
                scannerClient = new Scanner(System.in);
                final String text = scannerClient.nextLine();
                if (text.equals("exit")) {
                    break;
                }
                System.out.println(text + " accepted");
            }
            while (true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
