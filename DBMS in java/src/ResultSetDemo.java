//import java.sql.*;
//
//public class ResultSetDemo {
//    public static void main(String[] args) throws Exception {
//        // Load MySQL JDBC driver
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        // Connect to MySQL database
//        Connection con = DriverManager.getConnection(
//                "jdbc:mysql://localhost:3306/mydb", "root", "root"
//        );
//        // SQL query
//        String sql = "SELECT * FROM user";
//        PreparedStatement pre = con.prepareStatement(sql);
//        // Execute query
//        ResultSet rs = pre.executeQuery();
//        // Print header
//        System.out.println("Name\tEmail");
//        // Process result
//        while (rs.next()) {
//            System.out.println(rs.getString("name") + "\t" + rs.getString("email"));
//        }
//        // Close resources
//        rs.close();
//        pre.close();
//        con.close();
//    }
//}


//import java.sql.*;
//public class ResultSetDemo {
//    public static void main(String[] args) throws Exception {
//        // Load MySQL JDBC driver
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        // Connect to MySQL database
//        Connection con = DriverManager.getConnection(
//                "jdbc:mysql://localhost:3306/mydb", "root", "root"
//        );
//        // SQL query
//        String sql = "SELECT * FROM user";
//        PreparedStatement pre = con.prepareStatement(sql);
//        // Execute query
//        ResultSet rs = pre.executeQuery();
//        ResultSetMetaData rm = rs.getMetaData();
//        int count = rm.getColumnCount();
//        System.out.println("tablename" + rm.getTableName());
//        for (int i = 1; i <= count; i++) {
//            System.out.println("column Name:" + rm.getColumnCount());
//            System.out.println("Column Type" + rm.getColumnCount());
//        }
//        rs.close();
//        ;
//        pre.close();
//        con.close();
//    }
//}

import javax.sql.*;
