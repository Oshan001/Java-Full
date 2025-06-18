import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        // Set properties
        Properties pro = new Properties();
        pro.put("mail.smtp.auth", "true");
        pro.put("mail.smtp.starttls.enable", "true");
        pro.put("mail.smtp.host", "smtp.gmail.com");  // Fixed spelling
        pro.put("mail.smtp.port", "587");             // Fixed spelling

        // Create a session with authentication
        Session ses = Session.getInstance(pro, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("oshanbaj@gmail.com", "password");
            }
        });

        // Compose the message
        Message m = new MimeMessage(ses);
        m.setFrom(new InternetAddress("oshanbaj@gmail.com"));
        m.setRecipients(Message.RecipientType.TO, InternetAddress.parse("t@gmail.com"));
        m.setSubject("Hello");
        m.setText("message");

        // Send the message
        Transport.send(m);
        System.out.println("Email Sent");
    }
}

//import jakarta.mail.*;
//import jakarta.mail.internet.*;
//import  java.util.*;
//public class SendMailDemo {
//    public static void main(String[] args)throws Exception {
//        Properties pro = new Properties();
//        pro.put("mail.smtp:auth",true);
//        pro.put("mail.smtp:starttls.enable",true);
//        pro.put("mail.smtp:hoost","smpt.gmail.com");
//        pro.put("mail.smpt.port",587);
//        Session ses = Session.getInstance(pro,new Authenticator(){
//            protected PassswordAutentication getPasswordAuthencation()
//            {
//                return new PasswordAuthentication("a@gamil.com",password);
//            }
//        });
//        Message = new Message(ses);
//        m.setFrom(new InternetAddress("a@gamil.com"));
//        m.setRecePients(Message.recepidentsType,TO,Internet Adderss.parse("t@gmail.com"));
//        m.setSubject("hello");
//        m.setText("message");
//        Transport.send(m);
//        System.out.println("Email Sent");
//
//    }
//}
