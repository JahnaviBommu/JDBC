//Java Program to create a table DEPT in JDBC database
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class CreateTableExample {
    public static void main(String[] args) {
        // Database credentials
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String user = "root";
        String password = "mysql"; // Replace with your MySQL password

        // SQL query to create a table
        String createTableSQL = "CREATE TABLE Employees ("
                + "empid INT PRIMARY KEY,"
                + "empname VARCHAR(100),"
                + "dob DATE,"
                + "city VARCHAR(50),"
                + "salary DECIMAL(10, 2)"
                + ");";

        // Establishing connection and executing the query
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {

            // Execute the SQL query
            stmt.executeUpdate(createTableSQL);
            System.out.println("Table 'Employees' created successfully.");

        } catch (SQLException e) {
            System.err.println("SQL Exception: " + e.getMessage());
        }
    }
}
