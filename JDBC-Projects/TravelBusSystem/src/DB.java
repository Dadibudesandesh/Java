import java.sql.*;

public class DB {
    private final String dbUrl = "jdbc:mysql://localhost:3306/";
    private final String username = "root";
    private final String password = "";

    Connection connection;
    Statement statement;

    final String RED = "\u001B[31m";
    final String GREEN = "\u001B[32m";
    final String YELLOW = "\u001B[33m";
    final String CYAN = "\u001B[36m";
    final String PURPLE = "\u001B[35m";
    final String RESET = "\u001B[0m";

    public void createConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(dbUrl, username, password);
            String createDb = "CREATE DATABASE IF NOT EXISTS busAgency";
            String useDb = "use busAgency";
            statement = connection.createStatement();
            statement.executeUpdate(createDb);
            statement.executeUpdate(useDb);

            // CREATE PASSENGERS TABLE
            String tablePassenger = "CREATE TABLE IF NOT EXISTS PASSENGER("
                    + "pid INT  AUTO_INCREMENT PRIMARY KEY,"
                    + "pName VARCHAR(255),"
                    + "pGender VARCHAR(255),"
                    + "pNumber bigint)";


            // CREATE BUSES TABLE
            String tableBus = "CREATE TABLE IF NOT EXISTS BUS("
                    + "busId INT PRIMARY KEY AUTO_INCREMENT,"
                    + "busNo VARCHAR(255),"
                    + "busType VARCHAR(255),"
                    + "totalSeats BIGINT)";


            // CREATE ROUTE TABLE
            String tableRoute = "CREATE TABLE IF NOT EXISTS ROUTE("
                    + "routeId INT PRIMARY KEY AUTO_INCREMENT,"
                    + "source VARCHAR(255),"
                    + "destination VARCHAR(255),"
                    + "distance bigint)";


            // CREATE SCHEDULES TABLE
            String tableSchedule = "CREATE TABLE IF NOT EXISTS SCHEDULE("
                    + "sId INT PRIMARY KEY AUTO_INCREMENT,"
                    + "busId INT,"
                    + "routeId INT,"
                    + "travelDate date," +
                    "departureTime time," +
                    "FOREIGN KEY (busId) REFERENCES BUS(busId)," +
                    "FOREIGN KEY (routeId) REFERENCES ROUTE(routeId))";


            // CREATE BOOKING TABLE
            String tableBooking = "CREATE TABLE IF NOT EXISTS BOOKING("
                    + "bookingId INT PRIMARY KEY AUTO_INCREMENT,"
                    + "passengerId INT,"
                    + "scheduleId INT,"
                    + "seatNo INT," +
                    "fare DOUBLE," +
                    "bookingDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP," +
                    "FOREIGN KEY (passengerId) REFERENCES passenger(pId)," +
                    "FOREIGN KEY (scheduleId) REFERENCES schedule(sId))";


            statement.executeUpdate(tablePassenger);
            statement.executeUpdate(tableBus);
            statement.executeUpdate(tableRoute);
            statement.executeUpdate(tableSchedule);
            statement.executeUpdate(tableBooking);

        } catch (ClassNotFoundException | SQLException ex) {       //  HANDLE EXCEPTION IF OCCURS
            ex.printStackTrace();
        }
    }
}
