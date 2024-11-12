import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Transaction extends JFrame implements ActionListener {

    // FOR WITHDRAW , DIPOSIT CLASSES
    JButton btnDone, btnClear, btnCancel;
    JTextField textFieldAmount;

    JButton btnDiposit, btnWithdraw, btnBalance, btnFastCash, btnMiniStatement, btnEnquiry, btnPinChange, btnExit;
    JLabel background;
    static int pin;

    Transaction(int pin) {
        this.pin = pin;
        this.setSize(800, 700);
        this.setLocation(250, 10);
        this.setResizable(false);
        this.setLayout(new BorderLayout());

        background = new JLabel(new ImageIcon("src/atm.jpg"));
        background.setLayout(null);
        this.add(background);

        // ImageIcon imageIcon=new ImageIcon("src/card.png");
        // Image image=imageIcon.getImage().getScaledInstance(170, 140,
        // Image.SCALE_DEFAULT);
        // ImageIcon finalImage=new ImageIcon(image);
        // JLabel imageLabel=new JLabel(finalImage);
        // imageLabel.setBounds(180, 140, 170, 140);
        // background.add(imageLabel);

        btnWithdraw = new JButton("WITHDRAW");
        btnWithdraw.setBounds(70, 295, 130, 30);
        btnWithdraw.setFocusable(false);
        btnWithdraw.setBorderPainted(false);
        btnWithdraw.setOpaque(false);
        btnWithdraw.setContentAreaFilled(false);
        btnWithdraw.setForeground(Color.WHITE);
        btnWithdraw.setFont(new Font("railway", Font.BOLD, 15));
        btnWithdraw.addActionListener(this);
        background.add(btnWithdraw);

        btnDiposit = new JButton("DIPOSIT");
        btnDiposit.setBounds(70, 335, 110, 30);
        btnDiposit.setFocusable(false);
        btnDiposit.setBorderPainted(false);
        btnDiposit.setOpaque(false);
        btnDiposit.setContentAreaFilled(false);
        btnDiposit.setForeground(Color.WHITE);
        btnDiposit.setFont(new Font("railway", Font.BOLD, 15));
        btnDiposit.addActionListener(this);
        background.add(btnDiposit);

        btnBalance = new JButton("CHECK BALANCE");
        btnBalance.setBounds(70, 375, 180, 30);
        btnBalance.setFocusable(false);
        btnBalance.setBorderPainted(false);
        btnBalance.setOpaque(false);
        btnBalance.setContentAreaFilled(false);
        btnBalance.setForeground(Color.WHITE);
        btnBalance.setFont(new Font("railway", Font.BOLD, 15));
        btnBalance.addActionListener(this);
        background.add(btnBalance);

        btnFastCash = new JButton("FAST CASH");
        btnFastCash.setBounds(70, 415, 140, 30);
        btnFastCash.setFocusable(false);
        btnFastCash.setBorderPainted(false);
        btnFastCash.setOpaque(false);
        btnFastCash.setContentAreaFilled(false);
        btnFastCash.setForeground(Color.WHITE);
        btnFastCash.setFont(new Font("railway", Font.BOLD, 15));
        btnFastCash.addActionListener(this);
        background.add(btnFastCash);

        btnEnquiry = new JButton("BALANCE ENQUIRY");
        btnEnquiry.setBounds(280, 295, 190, 30);
        btnEnquiry.setFocusable(false);
        btnEnquiry.setBorderPainted(false);
        btnEnquiry.setOpaque(false);
        btnEnquiry.setContentAreaFilled(false);
        btnEnquiry.setForeground(Color.WHITE);
        btnEnquiry.setFont(new Font("railway", Font.BOLD, 15));
        btnEnquiry.addActionListener(this);
        background.add(btnEnquiry);

        btnMiniStatement = new JButton("MINI  STATEMENT");
        btnMiniStatement.setBounds(280, 335, 200, 30);
        btnMiniStatement.setFocusable(false);
        btnMiniStatement.setBorderPainted(false);
        btnMiniStatement.setOpaque(false);
        btnMiniStatement.setContentAreaFilled(false);
        btnMiniStatement.setForeground(Color.WHITE);
        btnMiniStatement.setFont(new Font("railway", Font.BOLD, 15));
        btnMiniStatement.addActionListener(this);
        background.add(btnMiniStatement);

        btnPinChange = new JButton("PIN CHANGE");
        btnPinChange.setBounds(300, 375, 200, 30);
        btnPinChange.setFocusable(false);
        btnPinChange.setBorderPainted(false);
        btnPinChange.setOpaque(false);
        btnPinChange.setContentAreaFilled(false);
        btnPinChange.setForeground(Color.WHITE);
        btnPinChange.setFont(new Font("railway", Font.BOLD, 15));
        btnPinChange.addActionListener(this);
        background.add(btnPinChange);

        btnExit = new JButton("Exit");
        btnExit.setBounds(330, 415, 200, 30);
        btnExit.setFocusable(false);
        btnExit.setBorderPainted(false);
        btnExit.setOpaque(false);
        btnExit.setContentAreaFilled(false);
        btnExit.setForeground(Color.WHITE);
        btnExit.setFont(new Font("railway", Font.BOLD, 15));
        btnExit.addActionListener(this);
        background.add(btnExit);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnExit) {
            System.exit(0);
        } else if (e.getSource() == btnWithdraw) {
            this.dispose();
            new Withdraw(pin);
        } else if (e.getSource() == btnDiposit) {
            this.dispose();
            new Diposit(pin);

        } else if (e.getSource() == btnBalance) {
            this.dispose();
            new BalanceCheck(pin);
        } else if (e.getSource() == btnFastCash) {
            this.dispose();
            new FastCash(pin);
        } else if (e.getSource() == btnPinChange) {
            this.dispose();
            new PinChange(pin);
        } else if (e.getSource() == btnMiniStatement) {
            new MiniStatement(pin);
        }
        // }else if (e.getSource()==btnEnquiry) {
        // this.dispose();
        // new Enquiry();
        // }
    }
}
