import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Conn {

    final String db_url = "jdbc:mysql://localhost:3306";
    final String user = "root";
    final String pass = "";
    public Connection conn;

    String formattedDate;

    Conn() {

        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
        formattedDate = currentDate.format(formatter);


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(db_url, user, pass);

            String queryDatabase = "CREATE DATABASE IF NOT EXISTS PIGMI";
            try (PreparedStatement createDatabase = conn.prepareStatement(queryDatabase)) {
                createDatabase.execute();
            }

            conn = DriverManager.getConnection(db_url + "/PIGMI", user, pass); // Connect to PIGMI database

            String queryTable = "CREATE TABLE IF NOT EXISTS ACCOUNTS (" +
                    "ID INT AUTO_INCREMENT PRIMARY KEY," +
                    "NAME VARCHAR(255) NOT NULL," +
                    "ACCOUNT_NO VARCHAR(50)," +
                    "DATE datetime DEFAULT current_timestamp)";

            try (PreparedStatement createTable = conn.prepareStatement(queryTable)) {
                createTable.execute();
            }

            conn = DriverManager.getConnection(db_url + "/PIGMI", user, pass); // Connect to PIGMI database

            String queryTableDailyPigmi = "CREATE TABLE IF NOT EXISTS TodaysPigmi (" +
                    "ID INT AUTO_INCREMENT PRIMARY KEY," +
                    "NAME VARCHAR(255) NOT NULL," +
                    "ACCOUNT_NO VARCHAR(50)," +
                    "Amount bigint ,"+
                    "DATE datetime DEFAULT current_timestamp)";

            try (PreparedStatement createTabledailyPigmi = conn.prepareStatement(queryTableDailyPigmi)) {
                createTabledailyPigmi.execute();
            }

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Conn();
    }
}
