import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateDept {
    public static void main(String[] args) {
        //Configure database connection
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String username = "root";
        String password = "mysql";

        //SQL query to update department details
        String updateSQL = 
            "UPDATE DEPARTMENT SET deptname = ?, Loc = ? WHERE deptno = ?";

        // values to update
        long deptNoToUpdate = 11L;
        String newDeptName = "Marketing";
        String newLoc = "Hyderabad";

        //Connect and execute update
        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement pstmt = conn.prepareStatement(updateSQL)) {

            pstmt.setString(1, newDeptName);
            pstmt.setString(2, newLoc);
            pstmt.setLong(3, deptNoToUpdate);

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Success! Updated department with deptno=" + deptNoToUpdate);
            } else {
                System.out.println("No department found with deptno=" + deptNoToUpdate);
            }

        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
        }
    }
}
