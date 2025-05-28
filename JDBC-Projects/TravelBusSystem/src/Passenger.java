import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Passenger {

    DB db=new DB();

    Scanner scanner=new Scanner(System.in);
    Connection connection= db.connection;
    PreparedStatement preparedStatement;

    final String RED = "\u001B[31m";
    final String GREEN = "\u001B[32m";
    final String YELLOW = "\u001B[33m";
    final String CYAN = "\u001B[36m";
    final String PURPLE = "\u001B[35m";
    final String RESET = "\u001B[0m";

    public Passenger() {
        db.createConnection();
        connection=db.connection;
    }

    private String name;
    private String gender;
    private long number;


    public void addPassenger(){
        System.out.print("Enter Passenger Name : ");
        name=scanner.next();
        System.out.print("Enter Passenger Gender : ");
        gender=scanner.next();
        System.out.print("Enter Passenger Mobile Number : ");
        number=scanner.nextLong();

        try{
            String addPassenger="INSERT INTO PASSENGER(pName,pGender,pNumber) VALUES(?,?,?)";
            preparedStatement=connection.prepareStatement(addPassenger);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,gender);
            preparedStatement.setLong(3,number);
            int rowAffected=preparedStatement.executeUpdate();
            if (rowAffected>0){
                System.out.println(GREEN+"Passenger Added Successfully....! "+RESET);
            }else {
                System.out.println(RED+"Passenger Not Added ....! "+RESET);
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    public void getAllPassengers() {
        try{
            String getPassengers="SELECT * FROM PASSENGER";
            preparedStatement=connection.prepareStatement(getPassengers);
            ResultSet allPassengers=preparedStatement.executeQuery();
            System.out.println("\n----------- All Passengers -----------");
            System.out.printf(PURPLE+"%-5s %-10s %-10s %-10s%n"+RESET, "SR", "Name", "Gender", "Mobile");
            int id=1;
            while (allPassengers.next()){
                name=allPassengers.getString("pName");
                gender=allPassengers.getString("pGender");
                number=allPassengers.getLong("pNumber");
                System.out.printf(CYAN+"%-5d %-10s %-10s %-10d%n"+RESET, id, name, gender, number);
                id++;
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }

    }

    public void updatePassenger() {
        System.out.print("Enter Passenger Id : ");
        int passengerId = scanner.nextInt();

        try {
            String passengerExist="SELECT * FROM PASSENGER WHERE pid=?";
            preparedStatement=connection.prepareStatement(passengerExist);
            preparedStatement.setInt(1,passengerId);
            ResultSet isAvailable=preparedStatement.executeQuery();
            if (isAvailable.next()){
                System.out.print("Enter Passenger Name : ");
                name=scanner.next().toUpperCase();
                System.out.print("Enter Passenger Gender : ");
                gender=scanner.next().toUpperCase();
                System.out.print("Enter Passenger Mobile Number : ");
                number=scanner.nextLong();
                int length=String.valueOf(number).length();
                if (length==10){
                    String updateRoute="UPDATE PASSENGER SET pNAME=?,pGENDER=?,pNUMBER=? WHERE pid=? ";
                    preparedStatement=connection.prepareStatement(updateRoute);
                    preparedStatement.setString(1,name);
                    preparedStatement.setString(2,gender);
                    preparedStatement.setLong(3,number);
                    preparedStatement.setInt(4,passengerId);
                    int execute=preparedStatement.executeUpdate();
                    if (execute>0){
                        System.out.println(GREEN+"Passenger Updated Successfully....!"+RESET);
                    }
                }else {
                    System.out.println(YELLOW+"Mobile Number Must Have 10 Digits...!"+RESET);
                }
            }else{
                System.out.println(YELLOW+"Passenger Not Exist......!"+RESET);
            }
        }catch (SQLException ex){
            System.out.println("Error : "+ex.getMessage());
        }
    }

}
