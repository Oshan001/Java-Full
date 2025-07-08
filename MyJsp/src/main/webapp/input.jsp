<%@ page import="java.sql.*" %>
<%
// Retrieve form parameters
String name = request.getParameter("name");
String gender = request.getParameter("gender");
String time = request.getParameter("time");
String course[] = request.getParameterValues("course"); // Corrected: parameter name & method
%>

<h1>Your Information</h1>
Name: <%= name %> <br>
Gender: <%= gender %> <br>
Time: <%= time %> <br>

<% if (course != null) { %>
<ul>
  <% for(String c : course) { %>
  <li><%= c %></li>
  <% } %>
</ul>
<% } else { %>
No course selected.
<% } %>

<%
//Database connection info
String url = "jdbc:mysql://localhost:3306/testdb";
String user = "root"; // your MySQL username
String password = "root"; // your MySQL password

try {
    Class.forName("com.mysql.cj.jdbc.Driver"); // Load driver
    Connection conn = DriverManager.getConnection(url, user, password);

    String sql = "INSERT INTO users (name, gender, time, courses) VALUES (?, ?, ?, ?)";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setString(1, name);
    ps.setString(2, gender);
    ps.setString(3, time);
    ps.setString(4, course.toString());

    ps.executeUpdate();

    out.println("<h2>Data saved successfully!</h2>");

    ps.close();
    conn.close();

} catch (Exception e) {
    out.println("<h3>Error: " + e.getMessage() + "</h3>");
    e.printStackTrace();
}

%>