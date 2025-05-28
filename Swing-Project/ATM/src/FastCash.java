import java.awt.Font;
import java.awt.event.ActionEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class FastCash extends Transaction {

    long balance;
    JButton btn100, btn200, btn500, btn2000, btn5000, btn10000;

    FastCash(int pin) {
        super(pin);
        btnBalance.setVisible(false);
        btnDiposit.setVisible(false);
        btnEnquiry.setVisible(false);
        btnExit.setVisible(false);
        btnFastCash.setVisible(false);
        btnMiniStatement.setVisible(false);
        btnPinChange.setVisible(false);
        btnWithdraw.setVisible(false);

        // JLabel labelMsg = new JLabel("Enter Amount You Have To Withdraw");
        // labelMsg.setBounds(110, 190, 330, 40);
        // labelMsg.setFont(new Font("Raleway", Font.BOLD, 18));
        // labelMsg.setForeground(Color.WHITE);
        // background.add(labelMsg);

        JLabel label = new JLabel("Get Instant Cash");
        label.setBounds(150, 210, 400, 40);
        label.setFont(new Font("Raleway", Font.BOLD, 30));
        label.setForeground(Color.WHITE);
        background.add(label);

        // textFieldAmount = new JTextField();
        // textFieldAmount.setBounds(170, 210, 250, 40);
        // textFieldAmount.setFont(new Font("Raleway", Font.PLAIN, 30));
        // textFieldAmount.setOpaque(false);
        // textFieldAmount.setForeground(Color.WHITE);
        // textFieldAmount.setBorder(null);
        // textFieldAmount.setCaretColor(Color.WHITE);
        // background.add(textFieldAmount);

        btn100 = new JButton("₹100");
        btn100.setBounds(65, 290, 100, 30);
        btn100.setFocusable(false);
        btn100.setBorderPainted(false);
        btn100.setOpaque(false);
        btn100.setContentAreaFilled(false);
        btn100.setForeground(Color.WHITE);
        btn100.setFont(new Font("railway", Font.BOLD, 20));
        btn100.addActionListener(this);
        background.add(btn100);

        btn200 = new JButton("₹200");
        btn200.setBounds(65, 335, 100, 30);
        btn200.setFocusable(false);
        btn200.setBorderPainted(false);
        btn200.setOpaque(false);
        btn200.setContentAreaFilled(false);
        btn200.setForeground(Color.WHITE);
        btn200.setFont(new Font("railway", Font.BOLD, 20));
        btn200.addActionListener(this);
        background.add(btn200);

        btn500 = new JButton("₹500");
        btn500.setBounds(65, 375, 100, 30);
        btn500.setFocusable(false);
        btn500.setBorderPainted(false);
        btn500.setOpaque(false);
        btn500.setContentAreaFilled(false);
        btn500.setForeground(Color.WHITE);
        btn500.setFont(new Font("railway", Font.BOLD, 20));
        btn500.addActionListener(this);
        background.add(btn500);

        btnCancel = new JButton("Cancel");
        btnCancel.setBounds(75, 415, 100, 30);
        btnCancel.setFocusable(false);
        btnCancel.setBorderPainted(false);
        btnCancel.setOpaque(false);
        btnCancel.setContentAreaFilled(false);
        btnCancel.setForeground(Color.WHITE);
        btnCancel.setFont(new Font("railway", Font.BOLD, 20));
        btnCancel.addActionListener(this);
        background.add(btnCancel);

        btn2000 = new JButton("₹2000");
        btn2000.setBounds(365, 290, 120, 30);
        btn2000.setFocusable(false);
        btn2000.setBorderPainted(false);
        btn2000.setOpaque(false);
        btn2000.setContentAreaFilled(false);
        btn2000.setForeground(Color.WHITE);
        btn2000.setFont(new Font("railway", Font.BOLD, 20));
        btn2000.addActionListener(this);
        background.add(btn2000);

        btn5000 = new JButton("₹5000");
        btn5000.setBounds(365, 335, 120, 30);
        btn5000.setFocusable(false);
        btn5000.setBorderPainted(false);
        btn5000.setOpaque(false);
        btn5000.setContentAreaFilled(false);
        btn5000.setForeground(Color.WHITE);
        btn5000.setFont(new Font("railway", Font.BOLD, 20));
        btn5000.addActionListener(this);
        background.add(btn5000);

        btn10000 = new JButton("₹10000");
        btn10000.setBounds(360, 375, 120, 30);
        btn10000.setFocusable(false);
        btn10000.setBorderPainted(false);
        btn10000.setOpaque(false);
        btn10000.setContentAreaFilled(false);
        btn10000.setForeground(Color.WHITE);
        btn10000.setFont(new Font("railway", Font.BOLD, 20));
        btn10000.addActionListener(this);
        background.add(btn10000);

        btnExit = new JButton("Exit");
        btnExit.setBounds(380, 415, 90, 30);
        btnExit.setFocusable(false);
        btnExit.setBorderPainted(false);
        btnExit.setOpaque(false);
        btnExit.setContentAreaFilled(false);
        btnExit.setForeground(Color.WHITE);
        btnExit.setFont(new Font("railway", Font.BOLD, 20));
        btnExit.addActionListener(this);
        background.add(btnExit);

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnExit) {
            System.exit(0);
        } else if (e.getSource() == btnCancel) {
            this.dispose();
            new Transaction(pin);
        } else {
            Database db = new Database();

            long amount = Integer.parseInt(((JButton) e.getSource()).getText().substring(1));
            String query = "insert into transaction (pin,AMOUNT,TRANSACTION_TYPE) values(?,?,?)";
            String newQuery = "select * from user where pin=?";
            String updateQuery = "update user set balance=? where pin=?";
            try {

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

            }
        }

    }
}
