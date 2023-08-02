package com.justbelieveinmyself.Sockets;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class HTTP {
    public static void main(String[] args) throws IOException {
        URLConnection connection = new URL("https://www.vk.com/").openConnection();
        Scanner scanner = new Scanner(connection.getInputStream());
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
        Map<String, List<String>> headers = connection.getHeaderFields();
        for(Map.Entry<String, List<String>> entry : headers.entrySet()){
            System.out.println(entry.getValue() + " " + entry.getKey());
        }
    }
}
