import java.awt.Font;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JLabel;

public class TodayReport extends Frame {

    String formattedDate;
    long total_amount;
    long total_payable;
    long total_unpayable;
    JButton buttonBack;
    Conn db = new Conn();

    TodayReport() {

        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        formattedDate = currentDate.format(formatter);

        JLabel labelDate = new JLabel("Date : " + formattedDate);
        labelDate.setBounds(40, 150, 200, 40);
        labelDate.setFont(new Font("Railway", Font.BOLD, 20));
        this.add(labelDate);

        JLabel labelTotal = new JLabel();
        labelTotal.setBounds(100, 200, 600, 40);
        labelTotal.setFont(new Font("RaileWay", Font.BOLD, 15));
        this.add(labelTotal);

        JLabel labelPayable = new JLabel();
        labelPayable.setBounds(100, 300, 600, 40);
        labelPayable.setFont(new Font("RaileWay", Font.BOLD, 15));
        this.add(labelPayable);
        
        JLabel labelUnpayable = new JLabel();
        labelUnpayable.setBounds(100, 300, 600, 40);
        labelUnpayable.setFont(new Font("RaileWay", Font.BOLD, 15));
        this.add(labelUnpayable);


        buttonBack = new JButton("Back");
        buttonBack.setBounds(450, 550, 100, 40);
        buttonBack.setFont(new Font("Raileway", Font.BOLD, 18));
        buttonBack.setFocusable(false);
        buttonBack.addActionListener(e -> goBack());
        this.add(buttonBack);

        // GETTING THE TOTAL SUM OF THE ALL AMOUNT

        try {
            String querySelect = "SELECT sum(Amount) as Total_Amount FROM `todayspigmi` WHERE date=CURRENT_DATE";
            PreparedStatement selectStatement = db.conn.prepareStatement(querySelect);
            ResultSet selectResult = selectStatement.executeQuery();
            if (selectResult.next()) {
                total_amount = selectResult.getLong("Total_Amount");
                labelTotal.setText("Total Collection Of The Day : " + total_amount);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        // GETTING THE TOTAL COUNT OF PIGMI PAYBLES

        try {
            String querySelect = "SELECT count(Amount) as total_payable FROM `todayspigmi` WHERE date=CURRENT_DATE and amount>0";
            PreparedStatement selectStatement = db.conn.prepareStatement(querySelect);
            ResultSet selectResult = selectStatement.executeQuery();
            if (selectResult.next()) {
                total_payable = selectResult.getLong("total_payable");
                labelPayable.setText("Total Pigmi Payable : " + total_payable);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        // GETTING THE TOTAL COUNT OF PIGMI UNPAYBLES

        try {
            String querySelect = "SELECT count(Amount) as total_unpayable FROM `todayspigmi` WHERE date=CURRENT_DATE and amount=0";
            PreparedStatement selectStatement = db.conn.prepareStatement(querySelect);
            ResultSet selectResult = selectStatement.executeQuery();
            if (selectResult.next()) {
                total_unpayable = selectResult.getLong("total_unpayable");
                labelUnpayable.setText("Total Pigmi Payable : " + total_unpayable);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void goBack() {
        this.dispose();
        new Menu().setVisible(true);
        ;
    }
}
