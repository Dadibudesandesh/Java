import java.awt.Font;
import java.awt.event.ActionEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Diposit extends Transaction {

    int pin;
    long balance;

    Diposit(int pin) {
        super(pin);
        this.pin = pin;
        btnBalance.setVisible(false);
        btnDiposit.setVisible(false);
        btnEnquiry.setVisible(false);
        btnExit.setVisible(false);
        btnFastCash.setVisible(false);
        btnMiniStatement.setVisible(false);
        btnPinChange.setVisible(false);
        btnWithdraw.setVisible(false);

        JLabel labelMsg = new JLabel("Enter Amount You Have To Diposit");
        labelMsg.setBounds(110, 190, 330, 40);
        labelMsg.setFont(new Font("Raleway", Font.BOLD, 18));
        labelMsg.setForeground(Color.WHITE);
        background.add(labelMsg);

        JLabel labelRuppe = new JLabel("₹");
        labelRuppe.setBounds(130, 250, 300, 40);
        labelRuppe.setFont(new Font("Raleway", Font.BOLD, 30));
        labelRuppe.setForeground(Color.WHITE);
        background.add(labelRuppe);

        textFieldAmount = new JTextField();
        textFieldAmount.setBounds(170, 250, 250, 40);
        textFieldAmount.setFont(new Font("Raleway", Font.PLAIN, 30));
        textFieldAmount.setOpaque(false);
        textFieldAmount.setForeground(Color.WHITE);
        textFieldAmount.setBorder(null);
        textFieldAmount.setCaretColor(Color.WHITE);
        background.add(textFieldAmount);

        btnDone = new JButton("Done");
        btnDone.setBounds(70, 335, 100, 30);
        btnDone.setFocusable(false);
        btnDone.setBorderPainted(false);
        btnDone.addActionListener(this);
        btnDone.setOpaque(false);
        btnDone.setFont(new Font("railway", Font.BOLD, 17));
        btnDone.setContentAreaFilled(false);
        btnDone.setForeground(Color.WHITE);
        background.add(btnDone);

        btnClear = new JButton("Clear");
        btnClear.setBounds(70, 375, 100, 30);
        btnClear.setFocusable(false);
        btnClear.setBorderPainted(false);
        btnClear.setOpaque(false);
        btnClear.addActionListener(this);
        btnClear.setContentAreaFilled(false);
        btnClear.setForeground(Color.WHITE);
        btnClear.setFont(new Font("railway", Font.BOLD, 17));
        background.add(btnClear);

        btnCancel = new JButton("Cancel");
        btnCancel.setBounds(370, 335, 100, 30);
        btnCancel.setFocusable(false);
        btnCancel.setBorderPainted(false);
        btnCancel.addActionListener(this);
        btnCancel.setOpaque(false);
        btnCancel.setContentAreaFilled(false);
        btnCancel.setForeground(Color.WHITE);
        btnCancel.setFont(new Font("railway", Font.BOLD, 17));
        background.add(btnCancel);

        btnExit = new JButton("Exit");
        btnExit.setBounds(380, 375, 100, 30);
        btnExit.setFocusable(false);
        btnExit.setBorderPainted(false);
        btnExit.setOpaque(false);
        btnExit.addActionListener(this);
        btnExit.setContentAreaFilled(false);
        btnExit.setForeground(Color.WHITE);
        btnExit.setFont(new Font("railway", Font.BOLD, 17));
        background.add(btnExit);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnClear) {
            textFieldAmount.setText("");
        } else if (e.getSource() == btnCancel) {
            this.dispose();
            new Transaction(pin);
        } else if (e.getSource() == btnDone) {
            if (textFieldAmount.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Enter Amount", "Warning",
                        JOptionPane.WARNING_MESSAGE);
            } else {

                long amount = Long.valueOf(textFieldAmount.getText());
                String query = "insert into transaction (PIN,AMOUNT,TRANSACTION_TYPE) values(?,?,?)";
                String newQuery = "select * from user where pin=?";
                String updateQuery = "update user set balance=? where pin=?";
                try {

                    Database db = new Database();

                    // GETTING ALL DATA IN USER TABLE
                    PreparedStatement checkBalance = db.connection.prepareStatement(newQuery);
                    checkBalance.setInt(1, pin);
                    ResultSet exists = checkBalance.executeQuery();

                    // GETTING BALANCE IN THE USER DATA
                    while (exists.next()) {
                        balance = exists.getLong("balance");
                    }

                    // ADD TRANSACTION IN THE TRANSACTION TABLE
                    PreparedStatement insert = db.connection.prepareStatement(query);
                    insert.setLong(1, pin);
                    insert.setLong(2, amount);
                    insert.setString(3, "Diposit");
                    int insertResult = insert.executeUpdate();

                    if (insertResult > 0) {
                        JOptionPane.showMessageDialog(null, "Transaction Successful You Diposit " + amount,
                                "Successful",
                                JOptionPane.INFORMATION_MESSAGE);

                        // UPDATE THE BALANCE WHEN USER DIPOSIT AMOUNT
                        PreparedStatement update = db.connection.prepareStatement(updateQuery);
                        update.setLong(1, (balance + amount));
                        update.setLong(2, pin);
                        int updateResult = update.executeUpdate();

                    } else {
                        JOptionPane.showMessageDialog(null, "Diposit Failed....!",
                                "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }

                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }
}
