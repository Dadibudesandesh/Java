import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AddPigmi extends Frame implements ActionListener {

    JTextField textFieldAccountNumber, textFieldHolderName, textFieldAmount, textFieldDate;
    JButton buttonNext, buttonBack, button50, button100, button200, button500, button150;
    String formattedDate;
    static int id = 1;

    AddPigmi() {

        JLabel labelHolderName = new JLabel("Account Holder   : ");
        labelHolderName.setFont(new Font("Raileway", Font.BOLD, 20));
        labelHolderName.setBounds(100, 200, 300, 30);
        this.add(labelHolderName);

        textFieldHolderName = new JTextField();
        textFieldHolderName.setFont(new Font("Raileway", Font.BOLD, 20));
        textFieldHolderName.setBounds(300, 200, 500, 40);
        // textFieldHolderName.setEnabled(false);
        this.add(textFieldHolderName);

        JLabel labelAccountNumber = new JLabel("A/C Number         : ");
        labelAccountNumber.setFont(new Font("Raileway", Font.BOLD, 20));
        labelAccountNumber.setBounds(100, 280, 200, 30);
        this.add(labelAccountNumber);

        textFieldAccountNumber = new JTextField();
        textFieldAccountNumber.setFont(new Font("Raileway", Font.BOLD, 20));
        // textFieldAccountNumber.setForeground(Color.red);
        textFieldAccountNumber.setBounds(300, 280, 150, 40);
        // textFieldAccountNumber.setEnabled(false);
        this.add(textFieldAccountNumber);

        JLabel labelAmount = new JLabel("Amount                 : ");
        labelAmount.setFont(new Font("Raileway", Font.BOLD, 20));
        labelAmount.setBounds(100, 360, 200, 30);
        this.add(labelAmount);

        textFieldAmount = new JTextField("0");
        textFieldAmount.setFont(new Font("Raileway", Font.BOLD, 20));
        textFieldAmount.setBounds(300, 360, 150, 40);
        // textFieldAmount.requestFocusInWindow();
        this.add(textFieldAmount);

        button50 = new JButton("₹50");
        button50.setBounds(500, 280, 80, 40);
        button50.setFont(new Font("Raileway", Font.BOLD, 18));
        button50.addActionListener(this);
        button50.setFocusable(false);
        this.add(button50);

        button100 = new JButton("₹100");
        button100.setBounds(500, 360, 80, 40);
        button100.setFont(new Font("Raileway", Font.BOLD, 18));
        button100.addActionListener(this);
        button100.setFocusable(false);
        this.add(button100);

        button150 = new JButton("₹150");
        button150.setBounds(600, 280, 80, 40);
        button150.setFont(new Font("Raileway", Font.BOLD, 18));
        button150.addActionListener(this);
        button150.setFocusable(false);
        this.add(button150);

        button200 = new JButton("₹200");
        button200.setBounds(600, 360, 80, 40);
        button200.setFont(new Font("Raileway", Font.BOLD, 18));
        button200.addActionListener(this);
        button200.setFocusable(false);
        this.add(button200);

        button500 = new JButton("₹500");
        button500.setBounds(700, 360, 80, 40);
        button500.setFont(new Font("Raileway", Font.BOLD, 18));
        button500.addActionListener(this);
        button500.setFocusable(false);
        this.add(button500);

        JLabel labelDate = new JLabel("Date                    : ");
        labelDate.setFont(new Font("Raileway", Font.BOLD, 20));
        labelDate.setBounds(100, 440, 200, 30);
        this.add(labelDate);

        textFieldDate = new JTextField();
        textFieldDate.setFont(new Font("Raileway", Font.BOLD, 20));
        textFieldDate.setBounds(300, 440, 250, 40);
        // textFieldDate.setEnabled(false);
        this.add(textFieldDate);

        buttonNext = new JButton("Next");
        buttonNext.setBounds(800, 540, 100, 40);
        buttonNext.addActionListener(this);
        buttonNext.setFocusable(false);
        this.add(buttonNext);

        buttonBack = new JButton("Back");
        buttonBack.setBounds(100, 540, 100, 40);
        buttonBack.addActionListener(this);
        buttonBack.setFocusable(false);
        this.add(buttonBack);

        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        formattedDate = currentDate.format(formatter);

        getData();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == buttonBack) {
            this.dispose();
            new Menu().setVisible(true);
        } else if (e.getSource() == button50) {
            textFieldAmount.setText("50");
        } else if (e.getSource() == button100) {
            textFieldAmount.setText("100");
        } else if (e.getSource() == button150) {
            textFieldAmount.setText("150");
        } else if (e.getSource() == button200) {
            textFieldAmount.setText("200");
        } else if (e.getSource() == button500) {
            textFieldAmount.setText("500");
        } else if (e.getSource() == buttonNext) {

            if (textFieldAmount.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Empty Fields",
                        JOptionPane.WARNING_MESSAGE);
            } else {
                String name = textFieldHolderName.getText();
                Long accountNumber = Long.parseLong(textFieldAccountNumber.getText());
                Long amount = Long.parseLong(textFieldAmount.getText());
                try {
                    Conn db = new Conn();

                    String queryInsert = "Insert into Todayspigmi (name,account_no,amount) values(?,?,?)";
                    PreparedStatement insertStatement = db.conn.prepareStatement(queryInsert);
                    insertStatement.setString(1, name);
                    insertStatement.setLong(2, accountNumber);
                    insertStatement.setLong(3, amount);
                    int insertResult = insertStatement.executeUpdate();
                    if (insertResult > 0) {
                        textFieldAmount.setText("0");
                    }

                    getData();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null,
                    "Enter Valid Amount...!","Invalid",JOptionPane.ERROR_MESSAGE);
                   new ViewAccount().setVisible(true);
                }
            }

        }
    }

    public void getData() {
        if (id < 50) {
            try {

                Conn db = new Conn();
                String querySelect = "SELECT * FROM ACCOUNTS WHERE ID=?";
                PreparedStatement getData = db.conn.prepareStatement(querySelect);
                getData.setInt(1, id);
                ResultSet selectResult = getData.executeQuery();
                while (selectResult.next()) {
                    textFieldHolderName.setText(selectResult.getString("name"));
                    textFieldAccountNumber.setText(selectResult.getString("account_no"));
                    textFieldHolderName.setText(selectResult.getString("name"));
                    textFieldDate.setText(formattedDate);
                }
                id++;
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Add More Accounts..!", "EndTable",
                    JOptionPane.WARNING_MESSAGE);
        }

    }

    public static void main(String[] args) {
        new AddPigmi();
    }

}
