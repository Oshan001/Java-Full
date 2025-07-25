import java.io.*;
import java.net.*;
public class TcpClient {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost",9097);
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
        out.println("hi from client ");
        out.flush();
        String msg = br.readLine();
        System.out.println("Server:"+msg);
       out.close();
       br.close();
       socket.close();
    }
}




//
//import java.io.*;      // For stream handling
//import java.net.*;     // For Socket
//
//public class TcpClient {
//    public static void main(String[] args) throws Exception {
//
//        Socket socket = new Socket("localhost", 1234);
//        System.out.println("Connected to server!");
//
//        OutputStream output = socket.getOutputStream();
//        PrintWriter writer = new PrintWriter(output, true);
//
//        InputStream input = socket.getInputStream();
//        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
//        String messageToServer = "Hello from Client!";
//        writer.println(messageToServer);
//        String replyFromServer = reader.readLine();
//        System.out.println("Received from server: " + replyFromServer);
//        writer.close();
//        reader.close();
//        socket.close();
//    }
//}
