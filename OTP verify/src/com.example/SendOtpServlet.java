package com.example;

//import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.Properties;
import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.util.logging.*;

@WebServlet("/send-otp")
public class SendOtpServlet extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(SendOtpServlet.class.getName());

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String email = req.getParameter("email");
        int otp = (int)(Math.random() * 900000) + 100000;

        HttpSession session = req.getSession();
        session.setAttribute("otp", otp);
        session.setAttribute("email", email);

        final String from = "your_email@gmail.com";
        final String password = "your_app_password";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session mailSession = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });

        try {
            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(from));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            msg.setSubject("Your OTP Code");
            msg.setText("Your OTP is: " + otp);
            Transport.send(msg);

            res.sendRedirect("verify.jsp");
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error sending OTP email", e);
            res.getWriter().write("Error sending OTP: " + e.getMessage());
        }
    }
}
