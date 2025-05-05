import java.awt.Font;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MiniStatement extends JFrame {
    int pin;

    MiniStatement(int pin) {
        this.pin = pin;

        this.setTitle("Receipt");
        this.setSize(230,400);
        this.setLocation(820, 200);
        this.setResizable(false);
        this.setLayout(null);



        JLabel labelBankName=new JLabel("Viracharya Bank");
       labelBankName.setBounds(50,20,300,30);
       labelBankName.setFont(new Font("Raileway",Font.BOLD,15));
        this.add(labelBankName);


        DefaultTableModel model=new DefaultTableModel(new String[]{"Amount","Transaction","Date"},0);
        JTable table=new JTable(model);
        table.setBounds(0, 0, 230, 400);
        this.add(table);
        try {
            Database db=new Database();
            ResultSet result=db.preparedStatement.executeQuery("select amount,transaction_type,data from transaction where pin='"+pin +"'");
            while (result.next()) {
                long amount=result.getLong("amount");
                String type=result.getString("transaction_type");
                String date=result.getString("date");

                model.addRow(new Object[]{amount,type,date});
                
            }
        } catch (Exception e) {
            // TODO: handle exception
        }

       
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new MiniStatement(2222);
    }
}
