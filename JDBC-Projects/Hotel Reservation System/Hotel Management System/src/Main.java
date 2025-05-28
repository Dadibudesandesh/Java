import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Main {
    private static final String DB = "jdbc:mysql://localhost:3306";
    private static final String userName = "root";
    private static final String userPass = "";

    public static void main(String[] args) throws ClassNotFoundException, SQLException , InterruptedException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            Connection conn = DriverManager.getConnection(DB, userName, userPass);
            Statement state = conn.createStatement();
            Scanner sc = new Scanner(System.in);
            String query = "use hotel";
            state.executeUpdate(query);
            while (true) {
                System.out.println();
                System.out.println("       +----------------------------+     ");
                System.out.println("++-----|  H O T E L   P A L A C E   |-----++");
                System.out.println("       +----------------------------+     ");
                System.out.println("1] Reserve a room");
                System.out.println("2] View Reservations");
                System.out.println("3] Get Room Number");
                System.out.println("4] Update Reservations");
                System.out.println("5] Delete Reservations");
                System.out.println("6] Exit");
                System.out.print("\n\n==>>  Choose an option : ");
                int ch = sc.nextInt();
                switch (ch) {
                    case 1:
                        reserveRoom(conn, sc, state);
                        break;
                    case 2:
                        viewReservations(conn, state);
                        break;
                    case 3:
                        getRoomNumber(conn, sc, state);
                        break;
                    case 4:
                        updateReservation(conn, sc, state);
                        break;
                    case 5:
                        deleteReservation(conn, sc, state);
                        break;
                    case 6:
                        exit(sc);
                        return;
                    default:
                        System.out.println("Enter valid choice, Try again.");
                        break;
                }

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void reserveRoom(Connection conn, Scanner sc, Statement state) {
        try {
            System.out.print("Enter Guest Name : ");
            String guestName = sc.next();
            System.out.print("Enter Room Number : ");
            int roomNumber = sc.nextInt();
            System.out.print("Enter Contact Number : ");
            long contactNumber = sc.nextLong();
            String query = "INSERT INTO RESERVATIONS (guest_name,room_number,contact_number) VALUES ('" + guestName
                    + "','" + roomNumber + "','" + contactNumber + "')";
            int affectedRow = state.executeUpdate(query);
            if (affectedRow > 0) {
                System.out.println("Reservation successfull");
            } else {
                System.out.println("Reservation Failed...!!");
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void viewReservations(Connection conn, Statement state) {
        String query = "SELECT * FROM RESERVATIONS";
        try {
            ResultSet resultSet = state.executeQuery(query);
            while (resultSet.next()) {
                System.out.println("+--------------------------------+");
                System.out.println("Reservation ID   : " + resultSet.getInt("reservation_id"));
                System.out.println("Guest Name       : " + resultSet.getString("guest_name"));
                System.out.println("Room Number      : " + resultSet.getInt("room_number"));
                System.out.println("Contact Number   : " + resultSet.getLong("contact_number"));
                System.out.println("Reservation Date : " + resultSet.getDate("reservation_date"));
                System.out.println("Reservation Time : " + resultSet.getTime("reservation_date"));
                System.out.println("+--------------------------------+");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void getRoomNumber(Connection conn, Scanner sc, Statement state) {
        System.out.print("Enter Reservation Id : ");
        int reservationID = sc.nextInt();
        String query = "select room_number from reservations where reservation_id='" + reservationID + "'";
        try {

            ResultSet resultSet = state.executeQuery(query);
            if (resultSet.next()) {
                System.out.println("Room Number of " + reservationID + " ID is : " + resultSet.getInt("room_number"));
            } else {
                System.out.println("Reservation not found for the given ID....!");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void updateReservation(Connection conn, Scanner sc, Statement state) {
        System.out.print("Enter Reservation Id For Update Data : ");
        int reservationId = sc.nextInt();
        System.out.print("Enter Guest Name : ");
        String guestName = sc.next();
        System.out.print("Enter Room Number : ");
        int roomNumber = sc.nextInt();
        System.out.print("Enter Contact Number : ");
        long contactNumber = sc.nextLong();

        String query = "update reservations set guest_name='" + guestName + "', room_number='" + roomNumber
                + "', contact_number='" + contactNumber + "' where reservation_id='" + reservationId + "' ";
        try {
            int affectedRow = state.executeUpdate(query);
            if (affectedRow > 0) {
                System.out.println("Reservation updated successfully");
            } else {
                System.out.println("Reservation update failed...!");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void deleteReservation(Connection conn, Scanner sc, Statement state) {
        System.out.print("Enter Reservation Id For Delete Data : ");
        int reservationId = sc.nextInt();
        String query = "delete from reservations where reservation_id='" + reservationId + "'";
        try {
            int affectedRow = state.executeUpdate(query);
            if (affectedRow > 0) {
                System.out.println("Record deleted successfully...");
            } else {
                System.out.println("Deletion failed");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void exit(Scanner sc) throws InterruptedException {
        System.out.print("Exiting System");
        int i=1;
        while (i<=5) {
            System.out.print(".");
            Thread.sleep(700);
            i++;
        }
        System.out.println("\nCome Again.....");
        

    }

}
