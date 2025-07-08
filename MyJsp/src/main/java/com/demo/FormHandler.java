// File: src/main/java/com/demo/FormHandler.java
package com.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/FormHandler")
public class FormHandler extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // Read form data
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String time = request.getParameter("time");
        String[] courses = request.getParameterValues("course");

        // Convert courses array to comma-separated string
        String courseList = (courses != null) ? String.join(", ", courses) : "None";

        // Database connection info
        String url = "jdbc:mysql://localhost:3306/testdb";
        String user = "root";       // your DB username
        String password = "root";   // your DB password

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the DB
            Connection conn = DriverManager.getConnection(url, user, password);

            // SQL insert
            String sql = "INSERT INTO users (name, time, gender, courses) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, gender);
            ps.setString(3, time);
            ps.setString(4, courseList);

            // Execute insert
            ps.executeUpdate();

            // Confirmation
            out.println("<h2>Data saved successfully!</h2>");

            // Close
            ps.close();
            conn.close();

        } catch (Exception e) {
            out.println("<h3>Error: " + e.getMessage() + "</h3>");
            e.printStackTrace(new PrintWriter(out)); // ✅ Corrected here
        }

        // Echo submitted info
        out.println("<h3>Your Input:</h3>");
        out.println("Name: " + name + "<br>");
        out.println("Gender: " + gender + "<br>");
        out.println("Time: " + time + "<br>");
        out.println("Courses: " + courseList + "<br>");
        out.println("<br><a href='form.html'>Go Back</a>");
    }
}
