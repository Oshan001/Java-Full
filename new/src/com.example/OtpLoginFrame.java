import javax.swing.*;
import java.awt.*;
import java.util.Properties;
import java.util.Random;
import jakarta.mail.*;
import jakarta.mail.internet.*;

class OtpLoginFrame extends JFrame {

    private JTextField emailField;
    private JButton sendOtpButton;
    private JTextField otpField;
    private JButton verifyOtpButton;
    private JLabel statusLabel;

    private int generatedOtp;

    // Your Gmail credentials here - use app password if 2FA enabled
    private final String fromEmail = "oshanbaj@gamil.com";
    private final String emailPassword = "pghmcgfosyesqopi";

    public OtpLoginFrame() {
        setTitle("Email OTP Login");
        setSize(400, 220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        // Email Label
        gbc.gridx = 0; gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        add(new JLabel("Email:"), gbc);

        // Email Field
        emailField = new JTextField(20);
        gbc.gridx = 1;
        add(emailField, gbc);

        // Send OTP Button
        sendOtpButton = new JButton("Send OTP");
        gbc.gridx = 2;
        add(sendOtpButton, gbc);

        // OTP Label
        gbc.gridx = 0; gbc.gridy = 1;
        add(new JLabel("Enter OTP:"), gbc);

        // OTP Field
        otpField = new JTextField(10);
        otpField.setEnabled(false);
        gbc.gridx = 1;
        add(otpField, gbc);

        // Verify OTP Button
        verifyOtpButton = new JButton("Verify OTP");
        verifyOtpButton.setEnabled(false);
        gbc.gridx = 2;
        add(verifyOtpButton, gbc);

        // Status Label
        statusLabel = new JLabel(" ");
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        add(statusLabel, gbc);

        // Button actions
        sendOtpButton.addActionListener(e -> sendOtp());
        verifyOtpButton.addActionListener(e -> verifyOtp());
    }

    private void sendOtp() {
        String email = emailField.getText().trim();
        if (email.isEmpty() || !email.contains("@")) {
            JOptionPane.showMessageDialog(this, "Please enter a valid email.", "Invalid Email", JOptionPane.ERROR_MESSAGE);
            return;
        }

        generatedOtp = new Random().nextInt(900000) + 100000;

        boolean emailSent = sendEmail(email, generatedOtp);
        if (emailSent) {
            statusLabel.setText("OTP sent to " + email);
            otpField.setEnabled(true);
            verifyOtpButton.setEnabled(true);
        } else {
            statusLabel.setText("Failed to send OTP. Check console for errors.");
        }
    }

    private boolean sendEmail(String toEmail, int otp) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, emailPassword);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipients(
                    Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject("Your OTP Code");
            message.setText("Your OTP is: " + otp);

            Transport.send(message);
            return true;

        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
    }

    private void verifyOtp() {
        String enteredOtpStr = otpField.getText().trim();
        if (enteredOtpStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter the OTP.", "Missing OTP", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            int enteredOtp = Integer.parseInt(enteredOtpStr);
            if (enteredOtp == generatedOtp) {
                JOptionPane.showMessageDialog(this, "Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                statusLabel.setText("Logged in!");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid OTP.", "Error", JOptionPane.ERROR_MESSAGE);
                statusLabel.setText("Invalid OTP. Try again.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "OTP must be a number.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new OtpLoginFrame().setVisible(true);
        });
    }
}
