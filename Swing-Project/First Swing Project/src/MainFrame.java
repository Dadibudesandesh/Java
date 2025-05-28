import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MainFrame extends JFrame {
    final private Font mainFont = new Font("Segoe print", Font.BOLD, 18);
    JTextField TextName, TextEmail, TextPassword;
    JLabel LabelWelcome;

    public void initialize() {
        // From Panel
        JLabel LabelName = new JLabel("Enter Name : ");
        LabelName.setFont(mainFont);
        TextName = new JTextField();
        TextName.setFont(mainFont);
        JLabel LabelEmail = new JLabel("Enter Email : ");
        LabelEmail.setFont(mainFont);
        TextEmail = new JTextField();
        TextEmail.setFont(mainFont);
        JLabel LabelPass = new JLabel("Enter Password : ");
        LabelPass.setFont(mainFont);
        TextPassword = new JTextField();
        TextPassword.setFont(mainFont);
        JPanel maiPanel = new JPanel();
        maiPanel.setLayout(new BorderLayout());

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(4, 1, 5, 5));
        formPanel.add(LabelName);
        formPanel.add(TextName);
        formPanel.add(LabelEmail);
        formPanel.add(TextEmail);

        // Welcome Label

        LabelWelcome = new JLabel();
        LabelWelcome.setFont(mainFont);

        // Button Panel

        JButton btnOk = new JButton("OK");
        btnOk.setFont(mainFont);
        btnOk.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String name = TextName.getText();
                String email = TextEmail.getText();
                String pass = TextPassword.getText();
                LabelWelcome.setText("Name : " + name + " Email : " + email + " Password : " + pass);
            }
        });

        JButton btnClear = new JButton("Clear");
        btnClear.setFont(mainFont);
        btnClear.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                TextName.setText(" ");
                TextEmail.setText(" ");
                TextPassword.setText(" ");
                LabelWelcome.setText("");
            }
        });

        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new GridLayout(1, 2, 5, 5));
        btnPanel.add(btnOk);
        btnPanel.add(btnClear);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        maiPanel.setBackground(new Color(128, 128, 155));
        maiPanel.add(formPanel, BorderLayout.NORTH);
        mainPanel.add(LabelWelcome, BorderLayout.CENTER);
        mainPanel.add(btnPanel, BorderLayout.SOUTH);

        add(mainPanel);

        setTitle("Login Page");
        setSize(500, 600);
        setMinimumSize(new Dimension(300, 400));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) {
        MainFrame myFrame = new MainFrame();
        myFrame.initialize();
    }

}