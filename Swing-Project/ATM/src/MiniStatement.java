import java.awt.Font;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MiniStatement extends JFrame {
    int pin;
    long balance;
    JLabel labelCardNumber;

    MiniStatement(int pin) {
        this.pin = pin;

        this.setTitle("Receipt");
        this.setSize(230, 400);
        this.setLocation(820, 200);
        this.setResizable(false);
        this.setLayout(null);

        JLabel labelBankName = new JLabel("Viracharya Bank");
        labelBankName.setBounds(50, 20, 300, 30);
        labelBankName.setFont(new Font("Raileway", Font.BOLD, 15));
        this.add(labelBankName);

        labelCardNumber = new JLabel();
        labelCardNumber.setBounds(10, 70, 300, 30);
        labelCardNumber.setFont(new Font("Raileway", Font.BOLD, 10));

        JLabel labelBalance = new JLabel();
        labelBalance.setBounds(10, 300, 200, 30);

        try {
            Database db = new Database();
            PreparedStatement preparedStatement = db.connection
                    .prepareStatement("select * from user where pin='" + pin + "' ");
            ResultSet result = preparedStatement.executeQuery();
            if (result.next()) {
                labelCardNumber.setText("Card Number : " + result.getString("cardnumber").substring(0, 4) + "xxxxxxxxxx"
                        + result.getString("cardnumber").substring(12));
                labelBalance.setText("Current Balance : "+result.getString("balance"));

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        this.add(labelCardNumber);
        this.add(labelBalance);

        JLabel labelMiniStat = new JLabel();
        labelMiniStat.setBounds(10, 40, 400, 330);
        labelMiniStat.setFont(new Font("Raileway", Font.PLAIN, 10));
        try {
            Database db = new Database();
            PreparedStatement preparedStatement = db.connection
                    .prepareStatement("select * from transaction where pin='" + pin + "' limit 6");
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {

                labelMiniStat.setText(labelMiniStat.getText() + "<html>" + result.getString("AMOUNT")
                        + "&nbsp;&nbsp;&nbsp;" + result.getString("TRANSACTION_TYPE")
                        + "&nbsp;&nbsp;&nbsp;" + result.getString("date") + "<br><br>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.add(labelMiniStat);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new MiniStatement(2222);
    }
}
