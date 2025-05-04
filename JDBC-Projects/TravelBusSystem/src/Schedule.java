import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Schedule {

    DB db=new DB();
    Connection connection;
    Scanner scanner;
    PreparedStatement preparedStatement;


    final String RED = "\u001B[31m";
    final String GREEN = "\u001B[32m";
    final String YELLOW = "\u001B[33m";
    final String CYAN = "\u001B[36m";
    final String PURPLE = "\u001B[35m";
    final String RESET = "\u001B[0m";

    int busId;
    int routeId;
    String travelDate;
    String departureTime;


    public Schedule() {
        db.createConnection();
        connection= db.connection;
        scanner=new Scanner(System.in);
    }

    public void addSchedule(){
        System.out.print("Enter Bus Id : ");
        busId=scanner.nextInt();
        System.out.print("Enter Route Id  : ");
        routeId=scanner.nextInt();
        System.out.print("Enter Travel Date (YYYY/MM/DD) : ");
        travelDate=scanner.next();
        System.out.print("Enter Departure Time (HH:MM:SS) : ");
        departureTime=scanner.next();

        try{
            String addSchedule="INSERT INTO SCHEDULE(busId,routeId,travelDate,departureTime) VALUES(?,?,?,?)";
            preparedStatement=connection.prepareStatement(addSchedule);
            preparedStatement.setInt(1,busId);
            preparedStatement.setInt(2,routeId);
            preparedStatement.setString(3,travelDate);
            preparedStatement.setString(4,departureTime);
            int rowAffected=preparedStatement.executeUpdate();
            if (rowAffected>0){
                System.out.println(GREEN+"Schedule Added Successfully....! "+RESET);
            }else {
                System.out.println(RED+"Schedule Not Added ....! "+RESET);
            }
        }catch (SQLException ex){
            System.out.println("Error : "+ex.getMessage());
        }
    }


    public void getAllSchedules() {
        try{
            String getPassengers="SELECT * FROM SCHEDULE";
            preparedStatement=connection.prepareStatement(getPassengers);
            ResultSet allPassengers=preparedStatement.executeQuery();
            System.out.println("\n----------- All SCHEDULES -----------");
            System.out.printf(PURPLE+"%-5s %-10s %-10s %-15s %-10s%n", "SR", "BusId", "RouteId", "TravelDate" ,"DepartureTime"+RESET);
            int id=1;
            while (allPassengers.next()){
                busId=allPassengers.getInt("busId");
                routeId=allPassengers.getInt("routeId");
                travelDate=allPassengers.getString("travelDate");
                departureTime=allPassengers.getString("departureTime");
                System.out.printf(CYAN+"%-5d %-10s %-10s %-15s %-10s%n"+RESET, id, busId, routeId, travelDate,departureTime);
                id++;
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }


    public void updateSchedules() {
        System.out.print("Enter Schedule Id : ");
        int scheduleId = scanner.nextInt();
        try {
            String scheduleExist="SELECT * FROM SCHEDULE WHERE sId=?";
            preparedStatement=connection.prepareStatement(scheduleExist);
            preparedStatement.setInt(1,scheduleId);
            ResultSet isAvailable=preparedStatement.executeQuery();
            if (isAvailable.next()){
                System.out.print("Enter Bus Id : ");
                busId=scanner.nextInt();
                System.out.print("Enter Route Id  : ");
                routeId=scanner.nextInt();
                System.out.print("Enter Travel Date (YYYY/MM/DD) : ");
                travelDate=scanner.next();
                System.out.print("Enter Departure Time (HH:MM:SS) : ");
                departureTime=scanner.next();
                String updateRoute="UPDATE SCHEDULE SET busId=?,routeId=?,travelDate=?,departureTime=? WHERE routeId=? ";
                preparedStatement=connection.prepareStatement(updateRoute);
                preparedStatement.setInt(1, busId);
                preparedStatement.setInt(2,routeId);
                preparedStatement.setString(3,travelDate);
                preparedStatement.setString(4,departureTime);
                preparedStatement.setInt(5,busId);
                int execute=preparedStatement.executeUpdate();
                if (execute>0){
                    System.out.println(GREEN+"Schedule Updated Successfully....!"+RESET);
                }
            }else{
                System.out.println(RED+"Schedule Not Available......!"+RESET);
            }
        }catch (SQLException ex){
            System.out.println("Error : "+ex.getMessage());
        }
    }
}
