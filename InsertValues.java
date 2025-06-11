//TO Insert values in the Department Table
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class InsertValues {
        public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String username = "root";
        String password = "mysql";
        String insertSQL = 
            "INSERT INTO DEPARTMENT (deptno, deptname, Loc) VALUES (?, ?, ?)";

        //  values to insert
        long deptNo =10L;
        String deptName = "Accounting";
        String loc = "NewYork";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {

            pstmt.setLong(1, deptNo);
            pstmt.setString(2, deptName);
            pstmt.setString(3, loc);

            int rows = pstmt.executeUpdate();
            System.out.println(rows + " row(s) inserted into DEPARTMENT.");

        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
        }
    }
}
