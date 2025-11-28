import java.sql.*;
import java.util.Scanner;

public class StudentJDBC {

    public static void main(String[] args) {
        // Database URL, username and password — change accordingly
        String url = "jdbc:mysql://localhost:3306/your_database"; // replace your_database
        String user = "root";    // your DB username
        String password = "password";  // your DB password

        Scanner sc = new Scanner(System.in);

        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to DB
            Connection con = DriverManager.getConnection(url, user, password);

            // Insert record
            System.out.print("Enter student id: ");
            int id = sc.nextInt();
            sc.nextLine(); // consume leftover newline

            System.out.print("Enter student name: ");
            String name = sc.nextLine();

            System.out.print("Enter student address: ");
            String address = sc.nextLine();

            String insertQuery = "INSERT INTO STUDENT (id, name, address) VALUES (?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(insertQuery);
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, address);

            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Record inserted successfully.");
            }

            // Display all records
            System.out.println("\nAll records from STUDENT table:");
            String selectQuery = "SELECT * FROM STUDENT";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(selectQuery);

            System.out.println("ID\tName\tAddress");
            System.out.println("-----------------------------");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + "\t" + 
                                   rs.getString("name") + "\t" + 
                                   rs.getString("address"));
            }

            // Close resources
            rs.close();
            stmt.close();
            pstmt.close();
            con.close();

        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database error!");
            e.printStackTrace();
        }

        sc.close();
    }
}
