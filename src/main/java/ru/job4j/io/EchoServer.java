package ru.job4j.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    out.write("Hello, dear friend.\n".getBytes());
                    for (String str = in.readLine(); str != null && !str.isEmpty(); str = in.readLine()) {
                        if (str.contains("msg=")) {
                            if (str.contains("Exit")) {
                                System.out.println("Server is closed!");
                                server.close();
                            } else if (str.contains("Hello")) {
                                out.write("Hello".getBytes());
                            } else {
                                out.write("What".getBytes());
                            }
                        }
                        System.out.println(str);
                    }
                    out.flush();
                }
            }
        }
    }
}