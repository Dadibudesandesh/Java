import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ViewAccount extends Frame implements ActionListener {

    JTextField textFieldAccountNumber;
    JButton buttonGetAccount, buttonBack;

    ViewAccount() {

        JLabel labelAcountNumber = new JLabel("Acount No   : ");
        labelAcountNumber.setBounds(300, 250, 200, 40);
        labelAcountNumber.setFont(new Font("Raileway", Font.BOLD, 30));
        this.add(labelAcountNumber);

        textFieldAccountNumber = new JTextField();
        textFieldAccountNumber.setBounds(550, 250, 100, 40);
        textFieldAccountNumber.setFont(new Font("Raileway", Font.BOLD, 20));
        this.add(textFieldAccountNumber);

        buttonBack = new JButton("Back");
        buttonBack.setBounds(300, 350, 100, 40);
        buttonBack.setFont(new Font("Raileway", Font.BOLD, 18));
        buttonBack.setFocusable(false);
        buttonBack.addActionListener(this);
        this.add(buttonBack);

        buttonGetAccount = new JButton("Get Account");
        buttonGetAccount.setBounds(500, 350, 150, 40);
        buttonGetAccount.setFont(new Font("Raileway", Font.BOLD, 18));
        buttonGetAccount.setFocusable(false);
        buttonGetAccount.addActionListener(this);
        this.add(buttonGetAccount);

    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==buttonBack) {
            this.dispose();
            new Menu().setVisible(true);;
        }else if (e.getSource()==buttonGetAccount) {
            this.dispose();
            try{

                int AcNumber=Integer.parseInt(textFieldAccountNumber.getText());
                new AccountDetails(AcNumber).setVisible(true);
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null,
                 "Enter Valid Account Number...!","Invalid",JOptionPane.ERROR_MESSAGE);
                new ViewAccount().setVisible(true);
            }
        }
    }
}
