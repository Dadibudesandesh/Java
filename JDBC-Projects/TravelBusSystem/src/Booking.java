import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Booking {

    DB db = new DB();
    Connection connection;
    Scanner scanner;
    PreparedStatement preparedStatement;

    final String RED = "\u001B[31m";
    final String GREEN = "\u001B[32m";
    final String YELLOW = "\u001B[33m";
    final String CYAN = "\u001B[36m";
    final String PURPLE = "\u001B[35m";
    final String RESET = "\u001B[0m";

    int passengerId;
    String passengerName;
    long passengerNumber;
    String source;
    String destination;
    int scheduleId;
    int seatNo;
    double fare;
    String bookingDate;
    long distance;

    public Booking() {
        db.createConnection();
        connection = db.connection;
        scanner = new Scanner(System.in);
    }

    public void bookTicket() {
        System.out.print("Enter Passenger Id : ");
        passengerId = scanner.nextInt();
        System.out.print("Enter Schedule Id  : ");
        scheduleId = scanner.nextInt();
        System.out.print("Enter Seat Number : ");
        seatNo = scanner.nextInt();
        System.out.print("Enter Fare  : ");
        fare = scanner.nextDouble();

        try {
            String checkPassenger="SELECT * FROM PASSENGER WHERE pid=?";
            preparedStatement=connection.prepareStatement(checkPassenger);
            preparedStatement.setInt(1,passengerId);
            ResultSet passengerExists=preparedStatement.executeQuery();
            if (!(passengerExists.next())){
                System.out.println(RED+"Passenger not exist of this id..!"+ RESET);
            }
            else{
                String checkSchedule = "SELECT * FROM SCHEDULE WHERE sId=?";
                preparedStatement = connection.prepareStatement(checkSchedule);
                preparedStatement.setInt(1, scheduleId);
                ResultSet scheduleExists = preparedStatement.executeQuery();
                if (!(scheduleExists.next())) {
                    System.out.println(RED+"Schedule not exist of this id...!"+RESET);
                } else {
                    // CHECK  PASSENGER ALREADY BOOKED SCHEDULED
                    String passengerCheck = "SELECT * FROM BOOKING WHERE passengerId=? AND scheduleId=?";
                    preparedStatement = connection.prepareStatement(passengerCheck);
                    preparedStatement.setInt(1, passengerId);
                    preparedStatement.setInt(2, scheduleId);
                    preparedStatement.executeQuery();
                    ResultSet isPassengerExists = preparedStatement.executeQuery();
                    if (isPassengerExists.next()) {
                        System.out.println(YELLOW+"Passenger Already Booked This Scheduled.......!"+RESET);
                    } else {
                        // CHECK ALREADY HAVE A SEAT
                        String seatNumbers = "SELECT * FROM BOOKING WHERE SeatNo=?";
                        preparedStatement = connection.prepareStatement(seatNumbers);
                        preparedStatement.setInt(1, seatNo);
                        ResultSet affectedRow = preparedStatement.executeQuery();
                        if (affectedRow.next()) {
                            System.out.println(YELLOW+"Seat Already Booked.....!"+RESET);
                        } else {

                            // BOOKING IF NOT  HAVE SEAT
                            String addBooking = "INSERT INTO BOOKING(passengerId,scheduleId,seatNo,fare,bookingDate) VALUES(?,?,?,?,?)";
                            preparedStatement = connection.prepareStatement(addBooking);
                            preparedStatement.setInt(1, passengerId);
                            preparedStatement.setInt(2, scheduleId);
                            preparedStatement.setInt(3, seatNo);
                            preparedStatement.setDouble(4, fare);
                            preparedStatement.setString(5, bookingDate);
                            int rowAffected = preparedStatement.executeUpdate();
                            if (rowAffected > 0) {
                                System.out.println(GREEN+"Booking  Successfully....! "+RESET);
                            } else {
                                System.out.println(RED+"Ticket not booked ....! "+RESET);
                            }
                        }
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
    }


    public void cancelTicket() {

        System.out.print("Enter Booking Id :");
        int bookingId = scanner.nextInt();

        try {
            String cancelBooking = "DELETE FROM BOOKING WHERE bookingId=?";
            preparedStatement = connection.prepareStatement(cancelBooking);
            preparedStatement.setInt(1, bookingId);
            int deleteBooking = preparedStatement.executeUpdate();
            if (deleteBooking > 0) {
                System.out.println(GREEN+"Cancel Ticket Successfully....!"+RESET);
            } else {
                System.out.println(RED+"Not canceled.......!"+RESET);
            }

        } catch (Exception ex) {
            System.out.println("Error : " + ex.getMessage());
        }
    }

    public void getAllBooking() {
        try {
            String getBooking = "SELECT b.*, p.pName, p.pNumber, r.source, r.destination, r.distance " +
                    "FROM booking b " +
                    "JOIN passenger p ON b.passengerId = p.pid " +
                    "JOIN schedule s ON b.scheduleId = s.sId " +
                    "JOIN route r ON s.routeId = r.routeId";

            preparedStatement = connection.prepareStatement(getBooking);
            ResultSet allBookings = preparedStatement.executeQuery();
            System.out.println("\n----------------------------------------------------- All Booking -----------------------------------------------------");
            System.out.printf(PURPLE+"%-5s %-17s %-17s %-10s %-13s %-13s %-13s %-13s %-13s%n"+RESET, "SR", "PassengerName", "PassengerNumber", "Source", "Destination","Distance", "SeatNo", "Fare", "BookingDate");
            int id = 1;
            while (allBookings.next()) {
                passengerName = allBookings.getString("pName");
                passengerNumber = allBookings.getLong("pNumber");
                source = allBookings.getString("source");
                destination = allBookings.getString("destination");
                distance=allBookings.getInt("distance");
                seatNo = allBookings.getInt("seatNo");
                fare = allBookings.getDouble("fare");
                bookingDate = allBookings.getString("bookingDate");
                System.out.printf(CYAN+"%-5d %-17s %-17d %-10s %-13s %-13s %-13d %-13f %-13s%n"+ RESET , id, passengerName, passengerNumber, source, destination, distance+"km",seatNo, fare, bookingDate );
                id++;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

}
