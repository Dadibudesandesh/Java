import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class HospitalManagementSystem {
    private static final String db = "jdbc:mysql://localhost:3306/hospital";
    private static final String user = "root";
    private static final String pass = "";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            Connection conn = DriverManager.getConnection(db, user, pass);
            Paitient paitient = new Paitient(conn, sc);
            Doctor doctor = new Doctor(conn);
            while (true) {
                System.out.println("\n----------------|  H E A L T H    H O S P I T A L  |-----------------");
                System.out.println("1] Add Patients");
                System.out.println("2] View Paitients ");
                System.out.println("3] View Doctors ");
                System.out.println("4] Book Apointments");
                System.out.println("5] Exit");
                System.out.print("\nEnter Option : ");
                int ch = sc.nextInt();

                switch (ch) {
                    case 1:
                        paitient.addPaitient();
                        break;
                    case 2:
                        paitient.viewPaitient();
                        break;
                    case 3:
                        doctor.viewDoctors();
                        break;
                    case 4:
                        appointment(paitient, doctor, conn, sc);
                        break;
                    case 5:
                        return;

                    default:
                        System.out.println("Enter Valid Option .....!");
                        break;
                }
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void appointment(Paitient paitient, Doctor doctor, Connection conn, Scanner scanner) {
        System.out.print("Enter Paitient Id : ");
        int paitientId = scanner.nextInt();
        System.out.print("Enter Doctor Id : ");
        int doctorId = scanner.nextInt();
        System.out.print("Enter Appointment Date(YYYY-MM-DD) : ");
        String appointmentDate = scanner.next();
        if (paitient.checkPaitient(paitientId) && doctor.checkDoctor(doctorId)) {
            if (doctorAvailability(doctorId, appointmentDate, conn)) {
                String appointmentQuery = "INSERT INTO apointments (paitient_id,doctors_id,appoient_date) values(?,?,?)";
                try {
                    PreparedStatement preparedStatement = conn.prepareStatement(appointmentQuery);
                    preparedStatement.setInt(1, paitientId);
                    preparedStatement.setInt(2, doctorId);
                    preparedStatement.setString(3, appointmentDate);
                    int affectedRows = preparedStatement.executeUpdate();
                    if (affectedRows > 0) {
                        System.out.println("Appointmnet Booked...");
                    } else {
                        System.out.println("Appoint failed..!!!!");
                    }
                } catch (SQLException ex) {
                    // System.out.println(ex.getMessage());
                    ex.printStackTrace();
                }
            } else {
                System.out.println("Doctor Not Available.");
            }
        } else {
            System.out.println("Doctor Either Paitient Not Available in Table.");
        }
    }

    public static boolean doctorAvailability(int doctorId, String appointDate, Connection connection) {
        String query = "select count(*) from apointments where doctors_id=? and appoient_date=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, doctorId);
            preparedStatement.setString(2, appointDate);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                if (count == 0) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
}
