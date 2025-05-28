import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class Home extends Frame implements ActionListener {

    JButton buttonLogin;
    JPasswordField textField;

    Home() {

        JLabel labelPassword = new JLabel("Password : ");
        labelPassword.setBounds(260, 250, 200, 30);
        labelPassword.setFont(new Font("Raileway", Font.BOLD, 30));
        this.add(labelPassword);

        textField = new JPasswordField();
        textField.setBounds(450, 250, 300, 50);
        textField.setFont(new Font("Raileway", Font.BOLD, 20));
        this.add(textField);

        buttonLogin = new JButton("Login");
        buttonLogin.setBounds(400, 320, 200, 50);
        buttonLogin.setFocusable(false);
        buttonLogin.addActionListener(this);
        this.add(buttonLogin);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Home();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String password = new String(textField.getPassword());
        if (e.getSource() == buttonLogin) {
            if (textField.getPassword().length == 0) {
                JOptionPane.showMessageDialog(null, "Enter password..!", "Missing", JOptionPane.OK_OPTION);
            } else if (!(password == "Sandesh@2004")) {
                dispose();
                new Menu().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Enter valid password..!", "Incorrect", JOptionPane.OK_OPTION);
                textField.setText("");
            }

        }
    }

}
