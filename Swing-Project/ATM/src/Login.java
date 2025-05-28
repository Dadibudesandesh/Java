import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener {

    JButton btnClear, btnLogin, buttonBack;
    JTextField cardNumber;
    JPasswordField pinNumber;

    Login() {

        this.setSize(800, 400);
        this.setLocation(250, 150);
        this.setTitle("Viracharya Bank ATM");
        this.setLayout(null);
        this.setResizable(false);
        // this.getContentPane().setBackground(Color.WHITE);

        JLabel labelTitle = new JLabel("User Login");
        labelTitle.setBounds(330, 40, 200, 50);
        labelTitle.setFont(new Font("Reilway", Font.BOLD, 30));
        this.add(labelTitle);

        JLabel labelCardNumber = new JLabel("Card Number  : ");
        labelCardNumber.setBounds(150, 130, 200, 40);
        labelCardNumber.setFont(new Font("Reilway", Font.BOLD, 25));
        this.add(labelCardNumber);

        JLabel labelPinNumber = new JLabel("Pin Number    : ");
        labelPinNumber.setBounds(150, 200, 200, 40);
        labelPinNumber.setFont(new Font("Reilway", Font.BOLD, 25));
        this.add(labelPinNumber);

        cardNumber = new JTextField();
        cardNumber.setBounds(350, 130, 250, 40);
        cardNumber.setFont(new Font("Reilway", Font.BOLD, 20));
        this.add(cardNumber);

        pinNumber = new JPasswordField();
        pinNumber.setBounds(350, 200, 250, 40);
        pinNumber.setFont(new Font("Reilway", Font.BOLD, 20));
        this.add(pinNumber);

        btnLogin = new JButton("Login");
        btnLogin.setBounds(200, 270, 150, 40);
        btnLogin.setFocusable(false);
        btnLogin.setFont(new Font("Reilway", Font.BOLD, 20));
        btnLogin.setBackground(new Color(0, 100, 0));
        btnLogin.setForeground(Color.white);
        btnLogin.setBorderPainted(false);
        btnLogin.addActionListener(this);
        this.add(btnLogin);

        btnClear = new JButton("Clear");
        btnClear.setBounds(390, 270, 150, 40);
        btnClear.setFocusable(false);
        btnClear.setFont(new Font("Reilway", Font.BOLD, 20));
        btnClear.setBackground(new Color(150, 0, 0));
        btnClear.setForeground(Color.white);
        btnClear.setBorderPainted(false);
        btnClear.addActionListener(this);
        this.add(btnClear);

        buttonBack = new JButton("⬅️");
        buttonBack.setBounds(0, 10, 70, 30);
        buttonBack.setFont(new Font("Railway", Font.BOLD, 20));
        buttonBack.addActionListener(this);
        buttonBack.setFocusable(false);
        buttonBack.setBackground(Color.white);
        buttonBack.setBorderPainted(false);
        ;
        this.add(buttonBack);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnClear) {
            cardNumber.setText("");
            pinNumber.setText("");
        } else if (e.getSource() == btnLogin) {

            if (pinNumber.getPassword().length == 0) {
                JOptionPane.showMessageDialog(null, "Enter pin", "Warning",
                        JOptionPane.WARNING_MESSAGE);
            } else {
                Database db = new Database();
                String query = "SELECT * FROM USER WHERE pin=? and cardnumber=?";
                String pinString = new String(pinNumber.getPassword());
                int pin = Integer.parseInt(pinString);
                String cardNumberString = new String(cardNumber.getText());
                long  cardNumber = Long.parseLong(cardNumberString);
                try {
                    PreparedStatement getData = db.connection.prepareStatement(query);
                    getData.setInt(1, pin);
                    getData.setLong(2, cardNumber);
                    ResultSet data = getData.executeQuery();
                    if (data.next()) {
                        this.dispose();
                        new Transaction(pin);
                    }else{
                        JOptionPane.showMessageDialog(null, "Incorrect credientials , Please Re-Enter Card Number and Pin","Error",JOptionPane.OK_OPTION);
                    }

                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } else if (e.getSource() == buttonBack) {
            this.dispose();
            new Home();
        }
    }
}