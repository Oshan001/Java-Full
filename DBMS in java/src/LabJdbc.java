//
//import java.sql.*;
//
//public class LabJdbc {
//    public static void main(String[] args) throws Exception {
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "root");
//        String q = "INSERT INTO information (id, name, email, password) VALUES (?, ?, ?, ?)";
//        PreparedStatement pre = con.prepareStatement(q);
//        pre.setString(1, "101");
//        pre.setString(2, "ABC");
//        pre.setString(3, "abc@gmail.com");
//        pre.setString(4, "ABC");
//        pre.executeUpdate();
//        pre.close();
//        con.close();
//        System.out.println("Data Added Successfully");
//    }
//}


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class LabJdbc extends JFrame implements ActionListener {
    JTextField idField, nameField, emailField;
    JPasswordField passwordField;
    JButton button;
    public LabJdbc() {
        setTitle("User Registration Form");
        setLayout(new FlowLayout());
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new JLabel("ID:"));
        idField = new JTextField(15);
        add(idField);
        add(new JLabel("Name:"));
        nameField = new JTextField(15);
        add(nameField);
        add(new JLabel("Email:"));
        emailField = new JTextField(15);
        add(emailField);
        add(new JLabel("Password:"));
        passwordField = new JPasswordField(15);
        add(passwordField);
        button = new JButton("Submit");
        add(button);
        button.addActionListener(this);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        String id = idField.getText();
        String name = nameField.getText();
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());
        if (id.isEmpty() || name.isEmpty() || email.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are required!");
            return;
        }
        try {
            insertData(id, name, email, password);
            JOptionPane.showMessageDialog(this, "Data inserted successfully!");
            // Clear fields
            idField.setText("");
            nameField.setText("");
            emailField.setText("");
            passwordField.setText("");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    public void insertData(String id, String name, String email, String password) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/java", "root", "root"
        );
        String q = "INSERT INTO information (id, name, email, password) VALUES (?, ?, ?, ?)";
        PreparedStatement pre = con.prepareStatement(q);
        pre.setString(1, id);
        pre.setString(2, name);
        pre.setString(3, email);
        pre.setString(4, password);
        pre.executeUpdate();
        pre.close();
        con.close();
    }
    public static void main(String[] args) {
        new LabJdbc();
    }
}


