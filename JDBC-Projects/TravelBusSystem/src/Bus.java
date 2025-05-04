import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Bus {

    DB db =new DB();
    Connection connection;
    PreparedStatement preparedStatement;
    Scanner scanner;

    final String RED = "\u001B[31m";
    final String GREEN = "\u001B[32m";
    final String YELLOW = "\u001B[33m";
    final String CYAN = "\u001B[36m";
    final String PURPLE = "\u001B[35m";
    final String RESET = "\u001B[0m";

    public Bus() {
        db.createConnection();
        connection=db.connection;
        scanner=new Scanner(System.in);
    }

    String busNumber;
    String busType;
    long totalSeat;

    public void addBus(){
        System.out.print("Enter Bus Number : ");
        busNumber=scanner.next();
        System.out.println("Select Bus Type:");
        System.out.println("1. AC");
        System.out.println("2. Non-AC");
        System.out.println("3. Sleeper");
        System.out.println("4. Seater");

        System.out.print("Chose Type : ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> busType = "AC";
            case 2 -> busType = "Non-AC";
            case 3 -> busType = "Sleeper";
            case 4 -> busType = "Seater";
            default -> {
                System.out.println("Invalid choice, setting default as 'Ordinary'");
                busType = "Ordinary";
            }
        }

        System.out.print("Enter Total Seats : ");
        totalSeat=scanner.nextLong();

        try{
            String haveBus="SELECT * FROM BUS WHERE busNo=?";
            preparedStatement=connection.prepareStatement(haveBus);
            preparedStatement.setString(1,busNumber.toUpperCase());
            ResultSet isAvailable=preparedStatement.executeQuery();
            if (isAvailable.next()){
                System.out.println(YELLOW+"Bus have Added Already.......!"+RESET);
            }else {
                String addBus="INSERT INTO BUS(busNo,busType,totalSeats) VALUES(?,?,?)";
                preparedStatement=connection.prepareStatement(addBus);
                preparedStatement.setString(1,busNumber.toUpperCase());
                preparedStatement.setString(2,busType);
                preparedStatement.setLong(3,totalSeat);
                int rowAffected=preparedStatement.executeUpdate();
                if (rowAffected>0){
                    System.out.println(GREEN+"Bus Added Successfully....! "+RESET);
                }else {
                    System.out.println(RED+"Bus Not Added ....! "+RESET);
                }
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    public void getAllBuses() {
        try{
            String getPassengers="SELECT * FROM BUS";
            preparedStatement=connection.prepareStatement(getPassengers);
            ResultSet allPassengers=preparedStatement.executeQuery();
            System.out.println("\n--------------- All BUSES ---------------");
            System.out.printf(PURPLE+"%-5s %-10s %-10s %-10s%n"+RESET, "SR", "BusNumber", "BusType", "Seats");
            int id=1;
            while (allPassengers.next()){
                busNumber=allPassengers.getString("busNo");
                busType=allPassengers.getString("busType");
                totalSeat=allPassengers.getLong("totalSeats");
                System.out.printf(CYAN+"%-5d %-10s %-10s %-10d%n"+RESET, id, busNumber, busType, totalSeat);
                id++;
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }

    }

    public void updateBus() {
        System.out.print("Enter Bus Id : ");
        int busId = scanner.nextInt();

        try {

            String busExist="SELECT * FROM BUS WHERE busId=?";
            preparedStatement=connection.prepareStatement(busExist);
            preparedStatement.setInt(1,busId);
            ResultSet isAvailable=preparedStatement.executeQuery();
            if (isAvailable.next()){

                System.out.print("Enter Bus Number : ");
                busNumber=scanner.next().toUpperCase();
                System.out.println("Select Bus Type:");
                System.out.println("1. AC");
                System.out.println("2. Non-AC");
                System.out.println("3. Sleeper");
                System.out.println("4. Seater");

                System.out.print("Chose Type : ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1 -> busType = "AC";
                    case 2 -> busType = "Non-AC";
                    case 3 -> busType = "Sleeper";
                    case 4 -> busType = "Seater";
                    default -> {
                        System.out.println("Invalid choice, setting default as 'Ordinary'");
                        busType = "Ordinary";
                    }
                }

                System.out.print("Enter Total Seats : ");
                totalSeat=scanner.nextLong();

                String updateBus="UPDATE BUS SET busNo=?,busType=?,totalSeats=? WHERE busId=? ";
                preparedStatement=connection.prepareStatement(updateBus);
                preparedStatement.setString(1,busNumber);
                preparedStatement.setString(2,busType);
                preparedStatement.setDouble(3,totalSeat);
                preparedStatement.setDouble(4,busId);
                int execute=preparedStatement.executeUpdate();
                if (execute>0){
                    System.out.println(GREEN+"Bus Updated Successfully....!"+RESET);
                }else {
                    System.out.println(RED+"Bus Not Updated.......!"+RESET);
                }
            }else{
                System.out.println(RED+"Bus Not Available......!"+RESET);
            }
        }catch (SQLException ex){
            System.out.println("Error : "+ex.getMessage());
        }

    }

}
