import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.*;

public class AddHolder extends Frame implements ActionListener {
    JTextField textFieldAccountNumber, textFieldHolderName;
    JButton buttonAdd, buttonClear,buttonBack;

    AddHolder() {
        this.setLayout(null);
        this.setSize(900, 600);

        JLabel labelHolderName = new JLabel("Account Holder   :");
        labelHolderName.setFont(new Font("Railway", Font.BOLD, 20));
        labelHolderName.setBounds(200, 200, 200, 30);
        this.add(labelHolderName);

        textFieldHolderName = new JTextField();
        textFieldHolderName.setFont(new Font("Railway", Font.BOLD, 20));
        textFieldHolderName.setBounds(400, 200, 300, 40);
        this.add(textFieldHolderName);

        JLabel labelAccountNumber = new JLabel("A/C Number    :");
        labelAccountNumber.setFont(new Font("Railway", Font.BOLD, 20));
        labelAccountNumber.setBounds(200, 280, 200, 30);
        this.add(labelAccountNumber);

        textFieldAccountNumber = new JTextField();
        textFieldAccountNumber.setFont(new Font("Railway", Font.BOLD, 20));
        textFieldAccountNumber.setBounds(400, 280, 300, 40);
        this.add(textFieldAccountNumber);

        buttonBack = new JButton("Back");
        buttonBack.setBounds(200, 400, 100, 40);
        buttonBack.addActionListener(this);
        buttonBack.setBackground(new Color(150, 0, 100));
        buttonBack.setFont(new Font("Railway", Font.BOLD, 18));
        buttonBack.setForeground(Color.WHITE);
        buttonBack.setFocusable(false);
        this.add(buttonBack);


        buttonClear = new JButton("Clear");
        buttonClear.setBounds(400, 400, 100, 40);
        buttonClear.addActionListener(this);
        buttonClear.setBackground(new Color(150, 0, 0));
        buttonClear.setFont(new Font("Railway", Font.BOLD, 18));
        buttonClear.setForeground(Color.WHITE);
        buttonClear.setFocusable(false);
        this.add(buttonClear);

        buttonAdd = new JButton("Add");
        buttonAdd.setBounds(600, 400, 100, 40);
        buttonAdd.addActionListener(this);
        buttonAdd.setBackground(new Color(0, 100, 22));
        buttonAdd.setFont(new Font("Railway", Font.BOLD, 18));
        buttonAdd.setForeground(Color.WHITE);
        buttonAdd.setFocusable(false);
        this.add(buttonAdd);

    }

    public static void main(String[] args) {
        new AddHolder().setVisible(true);;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonAdd) {
            if (textFieldHolderName.getText().isEmpty() || textFieldAccountNumber.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Empty Fields",
                        JOptionPane.WARNING_MESSAGE);
            } else {
                String holderName = textFieldHolderName.getText();
                String accountNumber = textFieldAccountNumber.getText();
                try {
                    Conn conn = new Conn();
                    String queryInsert = "INSERT INTO ACCOUNTS (NAME, ACCOUNT_NO) VALUES (?, ?)";
                    PreparedStatement prepareInsert = conn.conn.prepareStatement(queryInsert);
                    prepareInsert.setString(1, holderName);
                    prepareInsert.setString(2, accountNumber);
                    int insertResult = prepareInsert.executeUpdate();

                    if (insertResult > 0) {
                        JOptionPane.showMessageDialog(this, "Account Holder Added Successfully!", "Success",
                                JOptionPane.INFORMATION_MESSAGE);
                        textFieldHolderName.setText("");
                        textFieldAccountNumber.setText("");
                    }

                    prepareInsert.close();
                    conn.conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Error adding account holder.", "Database Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        } else if (e.getSource() == buttonClear) {
            textFieldHolderName.setText("");
            textFieldAccountNumber.setText("");
        }else if (e.getSource()==buttonBack) {
            this.dispose();
            new Menu().setVisible(true);
        }
    }
}
