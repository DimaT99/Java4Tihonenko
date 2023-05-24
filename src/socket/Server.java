package socket;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        Server server = new Server();
        server.createServer();

    }

    void createServer() {
        try (ServerSocket serverSocket = new ServerSocket(48080);
             Socket socket = serverSocket.accept();
             Scanner scannerServer = new Scanner(socket.getInputStream());
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {
            final InetAddress localAdress = socket.getInetAddress();
            final List<String> ipList = getText("src/socket/blackIpList.txt");
            ipList.forEach(ip -> {
                if (ip.equals(localAdress.getHostAddress())) {
                    writer.write("black");
                    System.out.println("IP in blacklist");
                    writer.close();
                }
            });
            writer.write("Welcome");
            writer.flush();
            writer.close();
            do {
                System.out.println("Enter the IP to be blacklisted or \"exit\" to exit");
                Scanner scanner1 = new Scanner(System.in);
                final String text = scanner1.nextLine();
                if (text.equals("exit")) {
                    break;
                }
                writeFile("blackIpList.txt", text);
                writer.flush();
                System.out.println(text + " added");
            }
            while (true);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    List<String> getText(final String path) {
        try {
            final Path p = Paths.get(path);
            List<String> strings = Files.readAllLines(p);
            return strings;
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new IllegalStateException();
    }

    public static void writeFile(final String path, final String cont) {
        try (OutputStream out = new FileOutputStream("src/socket/blackIpList.txt", true);
             Writer file = new OutputStreamWriter(out)) {
            file.append(System.getProperty("line.separator"));
            file.append(cont);
        } catch (IOException e) {
        }
    }
}
