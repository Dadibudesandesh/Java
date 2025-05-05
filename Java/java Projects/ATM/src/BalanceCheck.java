import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class BalanceCheck extends Transaction {
    JButton btnShowbalance;
    long balance;

    BalanceCheck(int pin) {
        super(pin);
        btnBalance.setVisible(false);
        btnDiposit.setVisible(false);
        btnEnquiry.setVisible(false);
        btnExit.setVisible(false);
        btnFastCash.setVisible(false);
        btnMiniStatement.setVisible(false);
        btnPinChange.setVisible(false);
        btnWithdraw.setVisible(false);

        

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
        textFieldAmount.setEditable(false);
        textFieldAmount.setFocusable(false);
        background.add(textFieldAmount);

       


        btnShowbalance = new JButton("Show Balance");
        btnShowbalance.setBounds(70, 335, 160, 30);
        btnShowbalance.setFocusable(false);
        btnShowbalance.setBorderPainted(false);
        btnShowbalance.setOpaque(false);
        btnShowbalance.setContentAreaFilled(false);
        btnShowbalance.setForeground(Color.WHITE);
        btnShowbalance.setFont(new Font("railway", Font.BOLD, 17));
        btnShowbalance.addActionListener(this);
        background.add(btnShowbalance);

        
        btnDiposit = new JButton("Diposit");
        btnDiposit.setBounds(70, 375, 100, 30);
        btnDiposit.setFocusable(false);
        btnDiposit.setBorderPainted(false);
        btnDiposit.setOpaque(false);
        btnDiposit.setContentAreaFilled(false);
        btnDiposit.setForeground(Color.WHITE);
        btnDiposit.setFont(new Font("railway", Font.BOLD, 17));
        btnDiposit.addActionListener(this);
        background.add(btnDiposit);


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

    public void actionPerformed(ActionEvent e){
        if (e.getSource()==btnShowbalance) {
            
            Database db=new Database();

            String query="select * from user where pin=?";
            try {
                PreparedStatement userData=db.connection.prepareStatement(query);
                userData.setLong(1, pin);
                ResultSet data=userData.executeQuery();

                while (data.next()) {
                    long balance=data.getLong("balance");
                    textFieldAmount.setText(""+balance);
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

        }else if (e.getSource()==btnDiposit) {
            this.dispose();
            new Diposit(pin);
        }else if (e.getSource()==btnCancel) {
            this.dispose();
            new Transaction(pin);
        }
    }
}
