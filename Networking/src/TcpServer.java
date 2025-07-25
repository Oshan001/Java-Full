import java.io.*;
import java.net.*;
public class TcpServer {
    public static void main(String[] args) throws Exception {
   ServerSocket ss = new ServerSocket(9097);
        System.out.println("Waiting for client...");
        Socket socket =ss.accept();
        System.out.println("Client connected!");
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
        String cmsg = br.readLine();
        System.out.println("client:"+cmsg);
        out.println("hi from server ");
        out.flush();
        socket.close();
        ss.close();
    }
}



//
//import java.io.*;
//import java.net.*;
//public class TcpServer {
//    public static void main(String[] args) throws Exception {
//
//        ServerSocket serverSocket = new ServerSocket(1234);
//        System.out.println("Waiting for client...");
//
//
//        Socket socket = serverSocket.accept();
//        System.out.println("Client connected!");
//
//
//        InputStream input = socket.getInputStream();
//
//
//        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
//
//
//        OutputStream output = socket.getOutputStream();
//        PrintWriter writer = new PrintWriter(output, true);
//
//        String message = reader.readLine();
//
//
//        System.out.println("Received from client: " + message);
//
//        String reply = "Hello from Server!";
//        writer.println(reply);
//        reader.close();
//        socket.close();
//        serverSocket.close();
//    }
//}