import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Route {

    DB db = new DB();
    Connection connection;
    PreparedStatement preparedStatement;
    Scanner scanner;

    final String RED = "\u001B[31m";
    final String GREEN = "\u001B[32m";
    final String YELLOW = "\u001B[33m";
    final String CYAN = "\u001B[36m";
    final String PURPLE = "\u001B[35m";
    final String RESET = "\u001B[0m";

    public Route() {
        db.createConnection();
        connection = db.connection;
        scanner = new Scanner(System.in);
    }

    String source;
    String destination;
    long distance;

    public void addRoute() {
        System.out.print("Enter Route Source : ");
        source = scanner.next();
        System.out.print("Enter Route Destination : ");
        destination = scanner.next();
        System.out.print("Enter Route Distance : ");
        distance = scanner.nextLong();

        try {
            String addRoute = "INSERT INTO ROUTE(source,destination,distance) VALUES(?,?,?)";
            preparedStatement = connection.prepareStatement(addRoute);
            preparedStatement.setString(1, source);
            preparedStatement.setString(2, destination);
            preparedStatement.setLong(3, distance);
            int rowAffected = preparedStatement.executeUpdate();
            if (rowAffected > 0) {
                System.out.println(GREEN+"Route Added Successfully....! "+RESET);
            } else {
                System.out.println(YELLOW+"Route Not Added ....! "+RESET);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void getAllRoutes() {
        try {
            String getPassengers = "SELECT * FROM ROUTE";
            preparedStatement = connection.prepareStatement(getPassengers);
            ResultSet allPassengers = preparedStatement.executeQuery();
            System.out.println("\n--------------- All ROUTES ---------------");
            System.out.printf(PURPLE+"%-5s %-10s %-15s %-15s%n"+RESET, "SR", "Source", "Destination", "Distance");
            int id = 1;
            while (allPassengers.next()) {
                source = allPassengers.getString("source");
                destination = allPassengers.getString("destination");
                distance = allPassengers.getLong("distance");
                System.out.printf(CYAN+"%-5d %-10s %-15s %-15d%n"+RESET, id, source, destination, distance);
                id++;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updateRoute() {
        System.out.print("Enter Route Id : ");
        int routeId = scanner.nextInt();
        try {
            String routeExist="SELECT * FROM ROUTE WHERE routeId=?";
            preparedStatement=connection.prepareStatement(routeExist);
            preparedStatement.setInt(1,routeId);
            ResultSet isAvailable=preparedStatement.executeQuery();
            if (isAvailable.next()){

                System.out.print("Enter Route Source : ");
                source = scanner.next();
                System.out.print("Enter Route Destination : ");
                destination = scanner.next();
                System.out.print("Enter Route Distance : ");
                distance = scanner.nextLong();

                String updateRoute="UPDATE ROUTE SET SOURCE=?,DESTINATION=?,DISTANCE=? WHERE routeId=? ";
                preparedStatement=connection.prepareStatement(updateRoute);
                preparedStatement.setString(1,source);
                preparedStatement.setString(2,destination);
                preparedStatement.setDouble(3,distance);
                preparedStatement.setDouble(4,routeId);
                int execute=preparedStatement.executeUpdate();
                if (execute>0){
                    System.out.println(GREEN+"Route Updated Successfully....!"+RESET);
                }
            }else{
                System.out.println(RED+"Route Not Available......!"+RESET);
            }
        }catch (SQLException ex){
            System.out.println("Error : "+ex.getMessage());
        }
    }


}
