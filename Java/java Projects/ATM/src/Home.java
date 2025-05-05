import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Home extends JFrame implements ActionListener {

    JLabel label;
    JButton signupButton;
    JButton loginButton;
    ImageIcon imageIcon,finalImage;

    Home() {
        this.setSize(800,400);
        this.setLocation(250, 150);
        this.setTitle("Viracharya Bank ATM");
        this.setLayout(null);
        this.getContentPane().setBackground(Color.WHITE);
        this.setResizable(false);

        imageIcon=new ImageIcon("src/bank.jpg");
        Image image=imageIcon.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        finalImage=new ImageIcon(image);
        JLabel imageLabel=new JLabel(finalImage);
        imageLabel.setBounds(20, 100, 200, 230);
        this.add(imageLabel);


        label = new JLabel("Welcome to Viracharya Bank ATM");
        label.setFont(new Font("Railway", Font.BOLD, 39));
        label.setBounds(70, 30, 700, 60);
        this.add(label);

        signupButton = new JButton("SignUp");
        signupButton.setFont(new Font("Railway", Font.BOLD, 20));
        signupButton.setBounds(300, 180, 150, 40);
        signupButton.setFocusable(false);
        signupButton.setBackground(new Color(200, 50, 0));
        signupButton.setForeground(Color.white);
        signupButton.setBorderPainted(false);
        signupButton.addActionListener(this);
        this.add(signupButton);

        loginButton = new JButton("Login");
        loginButton.setFont(new Font("Railway", Font.BOLD, 20));
        loginButton.setBounds(500, 180, 150, 40);
        loginButton.setFocusable(false);
        loginButton.setBackground(new Color(0, 100, 0));
        loginButton.setForeground(Color.white);
        loginButton.addActionListener(this);
        loginButton.setBorderPainted(false);

        this.add(loginButton);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Home();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==loginButton) {
            this.dispose();
            new Login();
        }else if (e.getSource()==signupButton) {
            this.dispose();
            new Signup();
        }
    }
}
