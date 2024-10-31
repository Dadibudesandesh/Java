import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Doctor {
        private Connection conn;
   
    public Doctor(Connection conn) {
        this.conn = conn;
    }


    public void viewDoctors() {
        System.out.println();
        System.out.println("        +---------------------------+ ");
        System.out.println("        |       D O C T O R' S      | ");
        System.out.println("        +---------------------------+ ");

        String query = "select * from doctors";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet RS = ps.executeQuery();
            System.out.println("+-----------+-------------+-----------------------+");
            System.out.println("| Doctor Id | Doctor Name | Doctor Specialization |");
            System.out.println("+-----------+-------------+-----------------------+");
            while (RS.next()) {
                int id = RS.getInt("id");
                String name = RS.getString("name");
                String specialization = RS.getString("specialization");
                System.out.printf("| %-9s | %-11s | %-21s |\n", id, name, specialization);
                System.out.println("+-----------+-------------+-----------------------+");

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public boolean checkDoctor(int id){
        String query="select * from doctors where id=?";
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
