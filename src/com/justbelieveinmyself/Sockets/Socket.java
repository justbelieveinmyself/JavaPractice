package com.justbelieveinmyself.Sockets;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Scanner;

public class Socket
{
    public static void main(String[] args) throws IOException {
        try(java.net.Socket socket = new java.net.Socket()){
            socket.connect(new InetSocketAddress("localhost", 70));
            Scanner scanner = new Scanner(socket.getInputStream());
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        }
    }
}