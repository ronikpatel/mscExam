import java.sql.*;
import java.util.Scanner;

public class EmployeeJDBC {

    public static void main(String[] args) {
        // Database connection details - change as per your setup
        String url = "jdbc:mysql://localhost:3306/your_database"; // Replace your_database
        String user = "root";    // Your DB username
        String password = "password";  // Your DB password

        Scanner sc = new Scanner(System.in);

        try {
            // Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            Connection con = DriverManager.getConnection(url, user, password);

            // Insert record
            System.out.print("Enter Employee ID: ");
            int empId = sc.nextInt();
            sc.nextLine(); // consume newline

            System.out.print("Enter Employee Name: ");
            String empName = sc.nextLine();

            System.out.print("Enter Department: ");
            String department = sc.nextLine();

            String insertQuery = "INSERT INTO EMPLOYEE (emp_id, emp_name, department) VALUES (?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(insertQuery);
            pstmt.setInt(1, empId);
            pstmt.setString(2, empName);
            pstmt.setString(3, department);

            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Record inserted successfully.");
            }

            // Display all records
            System.out.println("\nAll records from EMPLOYEE table:");
            String selectQuery = "SELECT * FROM EMPLOYEE";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(selectQuery);

            System.out.println("EMP_ID\tEMP_NAME\tDEPARTMENT");
            System.out.println("---------------------------------------");
            while (rs.next()) {
                System.out.println(rs.getInt("emp_id") + "\t" + 
                                   rs.getString("emp_name") + "\t" + 
                                   rs.getString("department"));
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
