
//import java.net.*;
//import java.io.*;
//
//
//public class TcpChatClient {
//    public static void main(String[] args) throws Exception{
//        Socket socket = new Socket("172.16.10.138", 9097);
//
////        ServerSocket ss = new ServerSocket(9097);
////        Socket socket =ss.accept();
//        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//        PrintWriter out =new PrintWriter(socket.getOutputStream(), true);
//
//        out.println("K xa bibek dosti");
//        out.flush();
//
//        String msg = br.readLine();
//        System.out.println("Server:"+msg);
//
//        out.close();
//        br.close();
//        socket.close();
//    }
//}

import java.net.*;
import java.io.*;

public class TcpChatClient {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("172.16.10.138", 9092); // Replace with server IP
        System.out.println("Connected to server.");

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

        // Thread to read from server
        new Thread(() -> {
            String msgFromServer;
            try {
                while ((msgFromServer = br.readLine()) != null) {
                    System.out.println("Server: " + msgFromServer);
                }
            } catch (IOException e) {
                System.err.println("Server disconnected.");
            }
        }).start();

        // Main thread to send to server
        String msgToServer;
        while ((msgToServer = keyboard.readLine()) != null) {
            out.println(msgToServer);
        }

        socket.close();
    }
}