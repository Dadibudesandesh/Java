
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Database {

    final String DB_Url = "jdbc:mysql://localhost:3306";
    final String user = "root";
    final String pass = "";

    public Connection connection;
    public Scanner sc;
    public PreparedStatement preparedStatement;

    public Database() {
        try {
            // Includes JDBC (MySql) Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Established Connection
            connection = DriverManager.getConnection(DB_Url, user, pass);
            sc = new Scanner(System.in);

            // Craete Sql statements
            String DB = "create database if not exists atm";
            String useDB = "use atm";
            String table = "create table if not exists user(" +
                    "ID INT  AUTO_INCREMENT PRIMARY KEY," +
                    "name varchar(255)," +
                    "email varchar(255)," +
                    "password varchar(255)," +
                    "phone varchar(255)," +
                    "dob varchar(255)," +
                    "gender varchar(50)," +
                    "marriedstatus varchar(50)," +
                    "pin bigint ," +
                    "cardnumber bigint," +
                    "balance bigint default 0 ," +
                    "date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP )";

            String createTansactionTable = "CREATE TABLE IF NOT EXISTS TRANSACTION (" +
                    "ID INT AUTO_INCREMENT PRIMARY KEY, " +
                    "PIN BIGINT , " +
                    "AMOUNT BIGINT, " +
                    "TRANSACTION_TYPE VARCHAR(255)," +
                    "cardnumber bigint," +
                    "date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP )";

            // Create Database
            PreparedStatement createDB = connection.prepareStatement(DB);
            int dbCreated = createDB.executeUpdate();

            // Use database
            PreparedStatement useDatabase = connection.prepareStatement(useDB);
            int DBuse = useDatabase.executeUpdate();

            // Create Table
            PreparedStatement createTable = connection.prepareStatement(table);
            int tableCreate = createTable.executeUpdate();

            // CREATE TRANSACTION TABLE
            PreparedStatement transactionTable = connection.prepareStatement(createTansactionTable);
            int createTransaction = transactionTable.executeUpdate();

        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    

    }

    public static void main(String[] args) {
        new Database();
    }

}
