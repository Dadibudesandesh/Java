import java.awt.Font;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AccountDetails extends Frame {

    long total_amount;
    long total_payable;
    long total_unpayable;
    int AcNumber;
    String Name;

    Conn db = new Conn();

    AccountDetails(int AcNumber) {
        this.AcNumber = AcNumber;

        JLabel labelName = new JLabel();
        labelName.setBounds(50, 150, 400, 40);
        labelName.setFont(new Font("Railway", Font.BOLD, 25));
        this.add(labelName);

        try {
            String querSelect = "SELECT NAME FROM ACCOUNTS WHERE ACCOUNT_NO=?";
            PreparedStatement selectStatement = db.conn.prepareStatement(querSelect);
            selectStatement.setInt(1, AcNumber);
            ResultSet selectResult = selectStatement.executeQuery();
            if (selectResult.next()) {
                labelName.setText(selectResult.getString("name"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        // Create a JTable and a DefaultTableModel
        DefaultTableModel tableModel = new DefaultTableModel();
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 200, 900, 200); // Adjust size and position as needed
        this.add(scrollPane);

        try {
            // Database connection

            PreparedStatement preparedStatement = db.conn
                    .prepareStatement("SELECT amount,date FROM todayspigmi WHERE account_no=?");
            preparedStatement.setInt(1, AcNumber);
            ResultSet result = preparedStatement.executeQuery();

            // Populate table columns
            int columnCount = result.getMetaData().getColumnCount();
            String[] columnNames = new String[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                columnNames[i - 1] = result.getMetaData().getColumnName(i);
            }
            tableModel.setColumnIdentifiers(columnNames);

            // Populate table rows
            while (result.next()) {
                String[] rowData = new String[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    rowData[i - 1] = result.getString(i);
                }
                tableModel.addRow(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel labelTotal = new JLabel();
        labelTotal.setBounds(50, 430, 400, 40);
        labelTotal.setFont(new Font("RaileWay", Font.BOLD, 15));
        this.add(labelTotal);

        JLabel labelPayable = new JLabel();
        labelPayable.setBounds(50, 460, 400, 40);
        labelPayable.setFont(new Font("RaileWay", Font.BOLD, 15));
        this.add(labelPayable);

        JLabel labelUnpayable = new JLabel();
        labelUnpayable.setBounds(50, 490, 400, 40);
        labelUnpayable.setFont(new Font("RaileWay", Font.BOLD, 15));
        this.add(labelUnpayable);

        try {
            String querySelect = "SELECT sum(Amount) as Total_Amount FROM `todayspigmi` WHERE account_no=?";
            PreparedStatement selectStatement = db.conn.prepareStatement(querySelect);
            selectStatement.setInt(1, AcNumber);
            ResultSet selectResult = selectStatement.executeQuery();
            if (selectResult.next()) {
                total_amount = selectResult.getLong("Total_Amount");
                labelTotal.setText("Total Collection              :  " + total_amount);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        try {
            String querySelect = "SELECT count(Amount) as total_payable FROM `todayspigmi` WHERE account_no=? and amount>0";
            PreparedStatement selectStatement = db.conn.prepareStatement(querySelect);
            selectStatement.setInt(1, AcNumber);
            ResultSet selectResult = selectStatement.executeQuery();

            if (selectResult.next()) {
                total_payable = selectResult.getLong("total_payable");
                labelPayable.setText("Pigmi Given Days           :  " + total_payable);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        // GETTING THE TOTAL COUNT OF PIGMI UNPAYBLES

        try {
            String querySelect = "SELECT count(Amount) as total_unpayable FROM `todayspigmi` WHERE account_no=? and amount=0";
            PreparedStatement selectStatement = db.conn.prepareStatement(querySelect);
            selectStatement.setInt(1, AcNumber);
            ResultSet selectResult = selectStatement.executeQuery();
            if (selectResult.next()) {
                total_unpayable = selectResult.getLong("total_unpayable");
                labelUnpayable.setText("Pigmi Missing Days       :  " + total_unpayable);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        JButton buttonBack = new JButton("Back");
        buttonBack.setBounds(100, 560, 100, 40);
        buttonBack.setFont(new Font("Raileway", Font.BOLD, 18));
        buttonBack.setFocusable(false);
        buttonBack.addActionListener(e -> goBack());
        this.add(buttonBack);

        JButton buttonMenu = new JButton("Menu");
        buttonMenu.setBounds(850, 560, 100, 40);
        buttonMenu.setFont(new Font("Raileway", Font.BOLD, 18));
        buttonMenu.setFocusable(false);
        buttonMenu.addActionListener(e -> goMenu());
        this.add(buttonMenu);

    }

    public void goBack() {
        this.dispose();
        new ViewAccount().setVisible(true);
        ;
    }

    public void goMenu() {
        this.dispose();
        new Menu().setVisible(true);
        ;
    }
}
