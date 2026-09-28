import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class jdbcConnection {

    public static void main(String args[]) {

        String url = "jdbc:mysql://localhost:3306/college";
        String username = "root";
        String password = "Ajmeera4769";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, username, password);
            Statement stmt = con.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS `24761A05BI` (" +
                    "id INT PRIMARY KEY, " +
                    "name VARCHAR(50), " +
                    "course VARCHAR(50), " +
                    "marks INT)";
            stmt.executeUpdate(sql);
            System.out.println("Table created successfully!");
            String insertQuery =
                    "INSERT INTO `24761A05BI` (id, name, course, marks) " +
                            "VALUES (101, 'deepika', 'cse', 91)";

            stmt.executeUpdate(insertQuery);
            System.out.println("Data inserted successfully!");
            String selectQuery = "SELECT * FROM `24761A05BI`";

            ResultSet rs = stmt.executeQuery(selectQuery);

            System.out.println("\nStudent Details:");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " " +
                                rs.getString("name") + " " +
                                rs.getString("course") + " " +
                                rs.getInt("marks")
                );
            }
            String updateQuery =
                    "UPDATE `24761A05BI` SET marks = 95 WHERE id = 101";

            stmt.executeUpdate(updateQuery);
            System.out.println("\nData updated successfully!");
            String deleteQuery =
                    "DELETE FROM `24761A05BI` WHERE id = 101";

            stmt.executeUpdate(deleteQuery);
            System.out.println("Data deleted successfully!");

            rs.close();
            stmt.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}