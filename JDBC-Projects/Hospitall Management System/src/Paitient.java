import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Paitient {
    private Connection conn;
    private Scanner sc;

    public Paitient(Connection conn, Scanner sc) {
        this.conn = conn;
        this.sc = sc;
    }

    public void addPaitient() {
        System.out.print("Enter patient name : ");
        String name = sc.next();
        System.out.print("Enter patient age : ");
        int age = sc.nextInt();
        System.out.print("Enter patient gender : ");
        String gender = sc.next();
        try {
            String query = "INSERT INTO patients (name,age,gender) values (?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, gender);
            int affectedRows = ps.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Paitient added successfully..");
            } else {
                System.out.println("paitient not added");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void viewPaitient() {
        System.out.println();
        System.out.println("              +-------------------------------+");
        System.out.println("              |       P A I T I E N T' S      |");
        System.out.println("              +-------------------------------+");

        String query = "select * from patients";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet RS = ps.executeQuery();
            System.out.println("+-------------+---------------+--------------+-----------------+");
            System.out.println("| Paitient Id | Paitient Name | Paitient Age | Paitient Gender |");
            System.out.println("+-------------+---------------+--------------+-----------------+");
            while (RS.next()) {
                int id = RS.getInt("id");
                String name = RS.getString("name");
                int age = RS.getInt("age");
                String gender = RS.getString("gender");
                System.out.printf("| %-11s | %-13s | %-12s | %-15s |\n", id, name, age, gender);
                System.out.println("+-------------+---------------+--------------+-----------------+");

            }
        } catch (SQLException ex) {
            // System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    public boolean checkPaitient(int id){
        String query="select * from patients where id=?";
        try{
            PreparedStatement ps=conn.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return false;
    }
}
