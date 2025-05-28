import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Withdraw extends Transaction {
    int pin;
    long balance;

    Withdraw(int pin) {
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

        JLabel labelMsg = new JLabel("Enter Amount You Have To Withdraw");
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
        btnDone.setOpaque(false);
        btnDone.setContentAreaFilled(false);
        btnDone.setForeground(Color.WHITE);
        btnDone.setFont(new Font("railway", Font.BOLD, 17));
        btnDone.addActionListener(this);
        background.add(btnDone);

        btnClear = new JButton("Clear");
        btnClear.setBounds(70, 375, 100, 30);
        btnClear.setFocusable(false);
        btnClear.setBorderPainted(false);
        btnClear.setOpaque(false);
        btnClear.setContentAreaFilled(false);
        btnClear.setForeground(Color.WHITE);
        btnClear.setFont(new Font("railway", Font.BOLD, 17));
        btnClear.addActionListener(this);
        background.add(btnClear);

        btnCancel = new JButton("Cancel");
        btnCancel.setBounds(370, 335, 100, 30);
        btnCancel.setFocusable(false);
        btnCancel.setBorderPainted(false);
        btnCancel.setOpaque(false);
        btnCancel.setContentAreaFilled(false);
        btnCancel.setForeground(Color.WHITE);
        btnCancel.setFont(new Font("railway", Font.BOLD, 17));
        btnCancel.addActionListener(this);
        background.add(btnCancel);

        btnExit = new JButton("Exit");
        btnExit.setBounds(380, 375, 100, 30);
        btnExit.setFocusable(false);
        btnExit.setBorderPainted(false);
        btnExit.setOpaque(false);
        btnExit.setContentAreaFilled(false);
        btnExit.setForeground(Color.WHITE);
        btnExit.setFont(new Font("railway", Font.BOLD, 17));
        btnExit.addActionListener(this);
        background.add(btnExit);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCancel) {
            this.dispose();
            new Transaction(pin);
        } else if (e.getSource() == btnClear) {
            textFieldAmount.setText("");
        } else if (e.getSource() == btnDone) {
            // String amt=textFieldAmount.getText();
            if (textFieldAmount.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Enter Amount", "Warning",
                        JOptionPane.WARNING_MESSAGE);
            } else {

                long amount = Long.valueOf(textFieldAmount.getText());
                String query = "insert into transaction (pin,AMOUNT,TRANSACTION_TYPE) values(?,?,?)";
                String newQuery = "select * from user where pin=?";
                String updateQuery = "update user set balance=? where pin=?";
                try {

                    Database db = new Database();
                    PreparedStatement checkBalance = db.connection.prepareStatement(newQuery);
                    checkBalance.setInt(1, pin);
                    ResultSet exists = checkBalance.executeQuery();
                    while (exists.next()) {
                        balance = exists.getLong("balance");
                    }

                    if (balance < amount) {
                        JOptionPane.showMessageDialog(null, "Insuffisient Balance....!",
                                "Error",
                                JOptionPane.ERROR_MESSAGE);
                    } else {
                        PreparedStatement addTransaction = db.connection.prepareStatement(query);
                        addTransaction.setInt(1, pin);
                        addTransaction.setLong(2, -amount);
                        addTransaction.setString(3, "Withdraw");
                        int result = addTransaction.executeUpdate();
                        if (result > 0) {
                            JOptionPane.showMessageDialog(null, "Transaction Successful You Withdraw " + amount,
                                    "Warning",
                                    JOptionPane.INFORMATION_MESSAGE);
                        }

                        PreparedStatement update = db.connection.prepareStatement(updateQuery);
                        update.setLong(1, (balance - amount));
                        update.setInt(2, pin);
                        int updateResult = update.executeUpdate();

                    }

                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }

            }

        }
    }
}
