//Java Program to create a table DEPT in JDBC database
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class CreateTable {
       public static void main(String[] args) {
        // Database credentials
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String username = "root";
        String password = "mysql"; 

        // SQL query to create a table
       
       String createTableSQL =
       "CREATE TABLE DEPARTMENT (" +
       "deptno BIGINT PRIMARY KEY," +
       "deptname VARCHAR(100)," +
       "Loc VARCHAR(50)" +
       ");";

        // Establishing connection and executing the query
        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement()) {

            // Execute the SQL query
            stmt.executeUpdate(createTableSQL);
            System.out.println("Table 'Department' created successfully.");

        } catch (SQLException e) {
            System.err.println("SQL Exception: " + e.getMessage());
        }
    }
}

