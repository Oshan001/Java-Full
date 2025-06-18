import java.sql.*;
class JdbcDemo {
    public static void main(String[] args) throws Exception {
        // 1. Load the JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 2. Establish the connection
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/java", // change this
                "root",                                  // change this
                "root"                                   // change this
        );
        // 3. Prepare the query
        String q = "INSERT INTO information (id, name, email, password) VALUES (?, ?, ?, ?)";
//        String q = "UPDATE  user set name =? where id = ?";
        PreparedStatement pre = con.prepareStatement(q);
        // 4. Set values
        pre.setString(1, "101");
        pre.setString(2, "ABC");
        pre.setString(3, "ABC@gmail.com");
        pre.setString(4, "abc");
        // 5. Execute the query
        pre.executeUpdate();
        // 6. Close connections
        pre.close();
        con.close();

        System.out.println("Data Inserted Successfully!");
    }
}
