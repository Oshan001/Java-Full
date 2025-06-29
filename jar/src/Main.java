import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        // Your Gmail address
        final String username = "oshanbaj@gmail.com";
        // Your Gmail App Password (16 chars, no spaces)
        final String appPassword = "pghm cgfo syes qopi";

        // Recipient email address
        String toEmail = "oshanbaj11@gmail.com";

        // SMTP server configuration
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        // Create session with authenticator
        Session session = Session.getInstance(props,
                new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, appPassword);
                    }
                }
        );

        // Enable debug output (optional)
        session.setDebug(true);

        try {
            // Compose the message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(toEmail)
            );
            message.setSubject("Test Email from Java");
            message.setText("Hello! This is a test email sent from Java using Jakarta Mail.");

            // Send the email
            Transport.send(message);

            System.out.println("Email sent successfully!");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
