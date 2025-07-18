# JAVA DATABASE CONNECTIVITY
- To communication between Java and Database
## Type of Driver
- Type1(JDBC-ODBC-BRIDGE)-with the help of ODBC (open Database connectivity)
- Type2 (VENDOR SPECIFIC-OIC) - Vendor Provided
- Type3 (Network Driver)- Through Network
- Type4(Pure JavaDriver)- written in java eg thin (most used)
## Steps For JDBC
- import the Requirement
- load the JDVC Driver
- Establish the connection
- Prepared the Query
- Execute the query
- Process of result
- Close the connection

| Step No. | Description              | Java Syntax Example                                                                                             |
|----------|--------------------------|-----------------------------------------------------------------------------------------------------------------|
| 1        | Import the requirements  | `import java.sql.*;`                                                                                            |
| 2        | Load the JDBC driver     | `Class.forName("com.mysql.cj.jdbc.Driver");`                                                                    |
| 3        | Establish the connection | `Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbname", "username", "password");`   |
| 4        | Prepare the query        | `PreparedStatement stmt = con.prepareStatement("SELECT * FROM table_name");`                                    |
| 5        | Execute the query        | `ResultSet rs = stmt.executeQuery();`                                                                           |
| 6        | Process the result       | `while(rs.next()) { System.out.println(rs.getString("column_name")); }`                                         |
| 7        | Close the connection     | `con.close();`                                                                                                  |

### insert data in java(DBMS)
```java
import java.sql.*;
class JdbcDemo {
public static void main(String[] args) throws Exception {
// 1. Load the JDBC driver
Class.forName("com.mysql.cj.jdbc.Driver");
// 2. Establish the connection
Connection con = DriverManager.getConnection(
"jdbc:mysql://localhost:3306/your_database_name", // change this
"your_username",                                  // change this
"your_password"                                   // change this
);
// 3. Prepare the query
String q = "INSERT INTO user (id, name, email, password) VALUES (?, ?, ?, ?)";
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
```

## SQL query in java
- To Insert 
```java
String q = "INSERT INTO table_name (col1, col2) VALUES (?, ?)";
PreparedStatement ps = con.prepareStatement(q);
ps.setString(1 "value1");
ps.setString(2, "value2");
ps.executeUpdate();

```
- TO Delete
```java 
String q = "DELETE FROM table_name WHERE condition_column = ?";
PreparedStatement ps = con.prepareStatement(q);
ps.setString(1, "condition_value");
ps.executeUpdate();
```
- To Alter 
```java
String q = "ALTER TABLE table_name ADD column_name datatype";
PreparedStatement ps = con.prepareStatement(q);
ps.executeUpdate();
```
- To Update
```java
String q = "UPDATE table_name SET col1 = ? WHERE condition_column = ?";
PreparedStatement ps = con.prepareStatement(q);
ps.setString(1, "new_value");
ps.setString(2, "condition_value");
ps.executeUpdate();
```
- To Select
```java
String q = "SELECT * FROM table_name WHERE condition_column = ?";
PreparedStatement ps = con.prepareStatement(q);
ps.setString(1, "condition_value");
ResultSet rs = ps.executeQuery();
while (rs.next()) {
        System.out.println(rs.getString("column_name"));
        }
```
- Example code :
```java
import java.sql.*;

class JdbcDemo {
    public static void main(String[] args) throws Exception {
        // 1. Load the JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2. Establish the connection
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/your_database", // Replace with your DB name
                "your_username",                             // Usually 'root'
                "your_password"                              // DB password ("" if empty)
        );

        // ---------- INSERT ----------
        String insertQuery = "INSERT INTO user (id, name, email, password) VALUES (?, ?, ?, ?)";
        PreparedStatement insertStmt = con.prepareStatement(insertQuery);
        insertStmt.setString(1, "101");
        insertStmt.setString(2, "ABC");
        insertStmt.setString(3, "abc@gmail.com");
        insertStmt.setString(4, "abc123");
        insertStmt.executeUpdate();
        insertStmt.close();

        // ---------- UPDATE ----------
        String updateQuery = "UPDATE user SET email = ? WHERE id = ?";
        PreparedStatement updateStmt = con.prepareStatement(updateQuery);
        updateStmt.setString(1, "new_email@gmail.com");
        updateStmt.setString(2, "101");
        updateStmt.executeUpdate();
        updateStmt.close();

        // ---------- DELETE ----------
        String deleteQuery = "DELETE FROM user WHERE id = ?";
        PreparedStatement deleteStmt = con.prepareStatement(deleteQuery);
        deleteStmt.setString(1, "101");
        deleteStmt.executeUpdate();
        deleteStmt.close();

        // ---------- ALTER ----------
        String alterQuery = "ALTER TABLE user ADD COLUMN phone VARCHAR(15)";
        PreparedStatement alterStmt = con.prepareStatement(alterQuery);
        alterStmt.executeUpdate();
        alterStmt.close();

        // ---------- SELECT ----------
        String selectQuery = "SELECT * FROM user";
        PreparedStatement selectStmt = con.prepareStatement(selectQuery);
        ResultSet rs = selectStmt.executeQuery();

        while (rs.next()) {
            System.out.println("ID: " + rs.getString("id"));
            System.out.println("Name: " + rs.getString("name"));
            System.out.println("Email: " + rs.getString("email"));
            System.out.println("Password: " + rs.getString("password"));
            System.out.println("Phone: " + rs.getString("phone")); // if column exists
        }

        rs.close();
        selectStmt.close();

        // 3. Close the connection
        con.close();

        System.out.println("All JDBC operations completed successfully.");
    }
}
```
# ResultSet
```java
import java.sql.*;

public class ResultSetDemo {
    public static void main(String[] args) throws Exception {
        // Load MySQL JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        // Connect to MySQL database
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/mydb", "root", "root"
        );
        // SQL query
        String sql = "SELECT * FROM user";
        PreparedStatement pre = con.prepareStatement(sql);
        // Execute query
        ResultSet rs = pre.executeQuery();
        // Print header
        System.out.println("Name\tEmail");
        // Process result
        while (rs.next()) {
            System.out.println(rs.getString("name") + "\t" + rs.getString("email"));
        }
        // Close resources
        rs.close();
        pre.close();
        con.close();
    }
}

```
# ResultsetMetaData rm :
- to get information about the table structure(meta data)
- getMetaData(); --> remote Result set metadata
- getColumnCount(int);
- getColumnName();   -->Returns the name of a specific column (1-based index)
- getColumnType(int);  -->	Returns the SQL type of a column (int constant from java.sql.Types)

```java

import java.sql.*;
public class ResultSetDemo {
    public static void main(String[] args) throws Exception {
        // Load MySQL JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        // Connect to MySQL database
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/mydb", "root", "root"
        );
        // SQL query
        String sql = "SELECT * FROM user";
        PreparedStatement pre = con.prepareStatement(sql);
        // Execute query
        ResultSet rs = pre.executeQuery();
        ResultSetMetaData rm = rs.getMetaData();
        int count = rm.getColumnCount();
        System.out.println("tablename" + rm.getTableName());
        for (int i = 1; i <= count; i++) {
            System.out.println("column Name:" + rm.getColumnCount());
            System.out.println("Column Type" + rm.getColumnCount());
        }
        rs.close();
        ;
        pre.close();
        con.close();
    }
}

```
## Statement vs preparedStatement
| Statement                | preparedStatement     |
|--------------------------|-----------------------|
| `static query`           | dynamic query         |
| `possible sql injection` | prevets sql injection |
| `slow performance`       | fast performance      |
| `no place holder suport` | place holder support  |
- RowSet : Enhance the result to dynamically manipulate the data
### ✅ Types of RowSet in JDBC

| RowSet Type       | Description                                                       | Connection Type     |
|-------------------|-------------------------------------------------------------------|---------------------|
| JDBCRowSet        | Connected RowSet; works like ResultSet with scroll and update     | Connected           |
| CachedRowSet      | Disconnected; stores data in memory and can be serialized         | Disconnected        |
| WebRowSet         | CachedRowSet with XML read/write support                          | Disconnected        |
| FilteredRowSet    | CachedRowSet that filters rows based on custom logic              | Disconnected        |
| JoinRowSet        | Joins data from multiple RowSet objects like SQL joins            | Disconnected        |

# lib:javax.sql* ;
- Syntax:
```java
CachedRowSet cr = RowSetProvidedFactory().CreateCachedRowSet();
cr.setUrl("jdbc://sql//localhost/,mysql");
cr.setUserName("root");
cr.setPassword("root");
cr.setCommand("Select * from user");
cr.execute();
while(cr.next()){
cr.getString("name:);
 }
}
```
-Example Code
```java
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

public class CachedRowSetDemo {
    public static void main(String[] args) {
        try {
            // 1. Create a CachedRowSet instance using RowSetProvider
            CachedRowSet cr = RowSetProvider.newFactory().createCachedRowSet();
            // 2. Set JDBC connection details
            cr.setUrl("jdbc:mysql://localhost:3306/your_database"); // Replace with your DB
            cr.setUsername("root");
            cr.setPassword("root");
            // 3. Set SQL command
            cr.setCommand("SELECT * FROM user");
            // 4. Execute query
            cr.execute();
            // 5. Iterate and display data
            while (cr.next()) {
                System.out.println("Name: " + cr.getString("name"));
            }
            // 6. Close the RowSet
            cr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```


