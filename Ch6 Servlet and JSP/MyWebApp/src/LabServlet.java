package com.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LabServlet implements ActionListener {

    private JTextField nameField;
    private JTextField emailField;

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Email and Name Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 150);
        frame.setLayout(new GridLayout(3, 2, 10, 10));

        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField(20);

        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField(20);

        JButton submitButton = new JButton("Submit");

        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(emailLabel);
        frame.add(emailField);
        frame.add(new JLabel()); // empty cell
        frame.add(submitButton);

        submitButton.addActionListener(this);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Called when submitButton is clicked
        String name = nameField.getText();
        String email = emailField.getText();

        JOptionPane.showMessageDialog(null, "Name: " + name + "\nEmail: " + email);
    }
    public static void main(String[] args) {
        LabServlet app = new LabServlet();  // create instance
        app.createAndShowGUI();             // call non-static method
    }
}
