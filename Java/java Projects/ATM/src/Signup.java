import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Signup extends JFrame implements ActionListener {

    JTextField textFieldName, textFieldMobile, textFieldEmail, textFieldPassword, textFieldDOB;
    JRadioButton radioButtonMale, radioButtonFemale, radioButtonMarried, radioButtonUnmarried, radioButtonOther;
    JButton buttonSignup, buttonClear,buttonBack;
    ButtonGroup buttonGroupMarriedStatus, buttonGroupGender;

   

    JOptionPane optionPane = new JOptionPane();

    Signup() {

        this.setSize(700, 650);
        this.setTitle("Viracharya Bank ATM");
        this.setLocation(300, 60);
        this.setLayout(null);
        // this.getContentPane().setBackground(Color.WHITE);
        this.setResizable(false);

        JLabel labelTitle = new JLabel("User SignUp");
        labelTitle.setBounds(270, 40, 200, 40);
        labelTitle.setFont(new Font("Railway", Font.BOLD, 30));
        this.add(labelTitle);

        JLabel labelName = new JLabel("Name               :");
        labelName.setBounds(120, 120, 150, 30);
        labelName.setFont(new Font("Railway", Font.BOLD, 18));
        this.add(labelName);

        textFieldName = new JTextField();
        textFieldName.setBounds(280, 120, 350, 30);
        this.add(textFieldName);

        JLabel labelEmail = new JLabel("Email               :");
        labelEmail.setBounds(120, 170, 150, 30);
        labelEmail.setFont(new Font("Railway", Font.BOLD, 18));
        this.add(labelEmail);

        textFieldEmail = new JTextField();
        textFieldEmail.setBounds(280, 170, 350, 30);
        this.add(textFieldEmail);

        JLabel labelPassword = new JLabel("Password         :");
        labelPassword.setBounds(120, 220, 150, 30);
        labelPassword.setFont(new Font("Railway", Font.BOLD, 18));
        this.add(labelPassword);

        textFieldPassword = new JTextField();
        textFieldPassword.setBounds(280, 220, 350, 30);
        this.add(textFieldPassword);

        JLabel labelMobile = new JLabel("Mobile              :");
        labelMobile.setBounds(120, 270, 150, 30);
        labelMobile.setFont(new Font("Railway", Font.BOLD, 18));
        this.add(labelMobile);

        textFieldMobile = new JTextField();
        textFieldMobile.setBounds(280, 270, 350, 30);
        this.add(textFieldMobile);

        JLabel labelDOB = new JLabel("DOB                  :");
        labelDOB.setBounds(120, 320, 150, 30);
        labelDOB.setFont(new Font("Railway", Font.BOLD, 18));
        this.add(labelDOB);

        textFieldDOB = new JTextField();
        textFieldDOB.setBounds(280, 320, 350, 30);
        this.add(textFieldDOB);

        JLabel labelGender = new JLabel("Gender             :");
        labelGender.setBounds(120, 370, 150, 30);
        labelGender.setFont(new Font("Railway", Font.BOLD, 18));
        this.add(labelGender);

        radioButtonMale = new JRadioButton("Male");
        radioButtonMale.setBounds(290, 370, 100, 30);
        radioButtonMale.setFocusable(false);
        radioButtonMale.setFont(new Font("Railway", Font.CENTER_BASELINE, 15));
        radioButtonMale.addActionListener(this);
        this.add(radioButtonMale);

        radioButtonFemale = new JRadioButton("Female");
        radioButtonFemale.setBounds(420, 370, 100, 30);
        radioButtonFemale.setFocusable(false);
        radioButtonFemale.setFont(new Font("Railway", Font.CENTER_BASELINE, 15));
        radioButtonFemale.addActionListener(this);
        this.add(radioButtonFemale);

        radioButtonOther = new JRadioButton("Other");
        radioButtonOther.setBounds(560, 370, 100, 30);
        radioButtonOther.setFocusable(false);
        radioButtonOther.setFont(new Font("Railway", Font.CENTER_BASELINE, 15));
        radioButtonOther.addActionListener(this);
        this.add(radioButtonOther);

        buttonGroupGender = new ButtonGroup();
        buttonGroupGender.add(radioButtonMale);
        buttonGroupGender.add(radioButtonFemale);
        buttonGroupGender.add(radioButtonOther);

        JLabel labelMarriedStatus = new JLabel("Married Satus   :");
        labelMarriedStatus.setBounds(120, 420, 150, 30);
        labelMarriedStatus.setFont(new Font("Railway", Font.BOLD, 18));
        this.add(labelMarriedStatus);

        radioButtonMarried = new JRadioButton("Married");
        radioButtonMarried.setBounds(290, 420, 100, 30);
        radioButtonMarried.setFocusable(false);
        radioButtonMarried.setFont(new Font("Railway", Font.CENTER_BASELINE, 15));
        radioButtonMarried.addActionListener(this);
        this.add(radioButtonMarried);

        radioButtonUnmarried = new JRadioButton("Unmarried");
        radioButtonUnmarried.setBounds(420, 420, 150, 30);
        radioButtonUnmarried.setFocusable(false);
        radioButtonUnmarried.setFont(new Font("Railway", Font.CENTER_BASELINE, 15));
        radioButtonUnmarried.addActionListener(this);
        this.add(radioButtonUnmarried);

        buttonGroupMarriedStatus = new ButtonGroup();
        buttonGroupMarriedStatus.add(radioButtonMarried);
        buttonGroupMarriedStatus.add(radioButtonUnmarried);

        buttonSignup = new JButton("SignUp");
        buttonSignup.setFont(new Font("Railway", Font.BOLD, 20));
        buttonSignup.setBounds(200, 500, 150, 40);
        buttonSignup.setFocusable(false);
        buttonSignup.setBackground(new Color(200, 150, 0));
        buttonSignup.setForeground(Color.white);
        buttonSignup.setBorderPainted(false);
        buttonSignup.addActionListener(this);
        this.add(buttonSignup);

        buttonClear = new JButton("Clear");
        buttonClear.setBounds(380, 500, 150, 40);
        buttonClear.setFocusable(false);
        buttonClear.setFont(new Font("Reilway", Font.BOLD, 20));
        buttonClear.setBackground(new Color(150, 0, 0));
        buttonClear.setForeground(Color.white);
        buttonClear.setBorderPainted(false);
        buttonClear.addActionListener(this);
        this.add(buttonClear);

        buttonBack=new JButton("⬅️");
        buttonBack.setBounds(0, 10, 70, 30);
        buttonBack.setFont(new Font("Railway",Font.BOLD,20));
        buttonBack.addActionListener(this);
        buttonBack.setFocusable(false);
        buttonBack.setBackground(Color.white);
        buttonBack.setBorderPainted(false);;
        this.add(buttonBack);


        
        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonSignup) {
            String name = textFieldName.getText();
            String email = textFieldEmail.getText();
            String phone = textFieldMobile.getText();
            String password = textFieldPassword.getText();
            String dob = textFieldDOB.getText();
            boolean male = radioButtonMale.isSelected();
            boolean female = radioButtonFemale.isSelected();
            boolean other = radioButtonOther.isSelected();
            boolean married = radioButtonMarried.isSelected();
            boolean unmarried = radioButtonUnmarried.isSelected();
            // System.out.println(textFieldName.getText()!="");
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Name Field can not be blank!", "Warning",
                        JOptionPane.WARNING_MESSAGE);
            } else if (email.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Email Field can not be blank!", "Warning",
                        JOptionPane.WARNING_MESSAGE);
            } else if (phone.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Phone Field can not be blank!", "Warning",
                        JOptionPane.WARNING_MESSAGE);
            } else if (dob.isEmpty()) {
                JOptionPane.showMessageDialog(null, "DOB Field can not be blank!", "Warning",
                        JOptionPane.WARNING_MESSAGE);
            } else if (password.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Password Field can not be blank", "Warning",
                JOptionPane.WARNING_MESSAGE);
            } else if (!male && !female && !other) {
                JOptionPane.showMessageDialog(null, "Please select gender!", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (!unmarried && !married) {
                JOptionPane.showMessageDialog(null, "Please select married status!", "Warning",
                        JOptionPane.WARNING_MESSAGE);
            }else{
                
                Database db=new Database();

                String gender=selectedGender();
                String marriedStatus=selectMarriedStatus();

                Random random=new Random();
                int pin=random.nextInt(8999)+1000;
                long accountNumber=Math.abs(random.nextLong()% 9999999999999999L)+1000000000000000L;
            
                try {
                    String query="Insert into user(name,email,password,phone,dob,gender,marriedstatus,pin,cardnumber) values(?,?,?,?,?,?,?,?,?)";
                    PreparedStatement preparedStatement=db.connection.prepareStatement(query);
                    preparedStatement.setString(1, name);
                    preparedStatement.setString(2, email);
                    preparedStatement.setString(3, password);
                    preparedStatement.setString(4, phone);
                    preparedStatement.setString(5, dob);
                    preparedStatement.setString(6, gender);
                    preparedStatement.setString(7, marriedStatus);
                    preparedStatement.setLong(8, pin);
                    preparedStatement.setLong(9, accountNumber);
                    boolean result = preparedStatement.execute();
                    if (!result) {
                        JOptionPane.showMessageDialog(null, "SignUp Successfully....✅", "SignUp👤", JOptionPane.PLAIN_MESSAGE);
                        JOptionPane.showMessageDialog(null, "Your Pin "+ pin +" and  Card No "+accountNumber, "SignUp👤", JOptionPane.PLAIN_MESSAGE);
                        buttonClear.doClick();
                    }else{
                        JOptionPane.showMessageDialog(null, "SignUp Failed....❌", "SignUp👤", JOptionPane.ERROR_MESSAGE);

                    }
                } catch (SQLException ex) {
                   System.out.println(ex.getMessage());
                }
                
            }

        } else if (e.getSource() == buttonClear) {

            // CLEAR SELECTED RADIO BUTTONS
            buttonGroupGender.clearSelection();
            buttonGroupMarriedStatus.clearSelection();

            // CLEAR ALL TEXT FIELDS
            textFieldName.setText("");
            textFieldEmail.setText("");
            textFieldPassword.setText("");
            textFieldMobile.setText("");
            textFieldDOB.setText("");
        }else if (e.getSource()==buttonBack) {
            this.dispose();
            new Home();
        }
    }

    public String selectedGender(){
        if (radioButtonFemale.isSelected()) {
            return "female";
        }else if (radioButtonMale.isSelected()) {
            return "male";
        }
        return "other";

    }

    public String selectMarriedStatus(){
        if (radioButtonMarried.isSelected()) {
            return "married";
        }
        return "unmarried";
    }

}