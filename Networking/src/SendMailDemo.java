import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.util.*;

public class SendMailDemo {
    public static void main(String[] args) throws Exception {
        final String username = "a@gmail.com"; // your email
        final String password = "your_app_password"; // use app password if 2FA is enabled

        // Set properties
        Properties pro = new Properties();
        pro.put("mail.smtp.auth", "true");
        pro.put("mail.smtp.starttls.enable", "true");
        pro.put("mail.smtp.host", "smtp.gmail.com");  // Fixed spelling
        pro.put("mail.smtp.port", "587");             // Fixed spelling

        // Create a session with authentication
        Session ses = Session.getInstance(pro, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        // Compose the message
        Message m = new MimeMessage(ses);
        m.setFrom(new InternetAddress(username));
        m.setRecipients(Message.RecipientType.TO, InternetAddress.parse("t@gmail.com"));
        m.setSubject("Hello");
        m.setText("message");

        // Send the message
        Transport.send(m);
        System.out.println("Email Sent");
    }
}
