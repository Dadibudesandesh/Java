import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Frame extends JFrame {
    Frame() {
        
        JLabel labelTitle=new JLabel("भगवानबाबा ग्रामिण पथ संस्था , बेडग ");
        labelTitle.setBounds(170, 50, 1000, 50);
        labelTitle.setFont(new Font("gsgs",Font.BOLD,40));
        this.add(labelTitle);
        
        this.setTitle("Pigmi Management System");
        this.setSize(1000,700);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);
       
    }
}