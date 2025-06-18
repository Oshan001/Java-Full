import java.io.*;
        import java.net.*;

public class Main {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(7777);
        System.out.println("ChatBot Server is running...");

        Socket socket = server.accept();
        System.out.println("Client connected.");

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        String message;
        while ((message = in.readLine()) != null) {
            System.out.println("Client: " + message);

            // Bot logic (basic)
            String reply;
            switch (message.toLowerCase()) {
                case "hi":
                case "hello":
                    reply = "Hello! How can I help you?";
                    break;
                case "how are you?":
                    reply = "I'm a bot. I'm always okay!";
                    break;
                case "bye":
                    reply = "Goodbye! Have a nice day.";
                    out.println(reply);
                    break;
                default:
                    reply = "Sorry, I don't understand.";
            }

            out.println(reply);

            if (message.equalsIgnoreCase("bye")) {
                break;
            }
        }

        in.close();
        out.close();
        socket.close();
        server.close();
    }
}
