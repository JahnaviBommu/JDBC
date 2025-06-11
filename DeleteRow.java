// Here Deleting the row which has deptNo. as 13 in DEPARTMENT Table
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteRow{
    public static void main(String[] args){
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String username = "root";
        String password = "mysql";

        String deleteSQL = "DELETE FROM DEPARTMENT WHERE deptno = ?";

        long deptNoToDelete = 13L;  

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement pstmt = conn.prepareStatement(deleteSQL)) {

            pstmt.setLong(1, deptNoToDelete);

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Deleted department with deptno = " + deptNoToDelete);
            } else {
                System.out.println("No department found with deptno = " + deptNoToDelete);
            }

        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
        }
    }
}
