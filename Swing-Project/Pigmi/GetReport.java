import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

public class GetReport extends Frame implements ActionListener {

    JTextField textFieldDate;
    JButton buttonGetReport, buttonClear, buttonBack;
    String date;
    JDateChooser dateChooser;


    GetReport() {

        JLabel labelDate = new JLabel("Eneter Date    : ");
        labelDate.setBounds(200, 250, 300, 50);
        labelDate.setFont(new Font("Raileway", Font.BOLD, 25));
        this.add(labelDate);

        // Create the JDateChooser component
        dateChooser = new JDateChooser();
        dateChooser.setBounds(400, 250, 400, 50);
        dateChooser.setFont(new Font("Raileway", Font.BOLD, 20));
        this.add(dateChooser);


        buttonBack = new JButton("Back");
        buttonBack.setBounds(200, 350, 100, 40);
        buttonBack.setFont(new Font("Raileway", Font.BOLD, 18));
        buttonBack.setFocusable(false);
        buttonBack.addActionListener(this);
        this.add(buttonBack);

        buttonClear = new JButton("Clear");
        buttonClear.setBounds(410, 350, 150, 40);
        buttonClear.setFont(new Font("Raileway", Font.BOLD, 18));
        buttonClear.setFocusable(false);
        buttonClear.addActionListener(this);
        this.add(buttonClear);

        buttonGetReport = new JButton("Get Report");
        buttonGetReport.setBounds(650, 350, 150, 40);
        buttonGetReport.setFont(new Font("Raileway", Font.BOLD, 18));
        buttonGetReport.setFocusable(false);
        buttonGetReport.addActionListener(this);
        this.add(buttonGetReport);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonClear) {
            textFieldDate.setText("");
        } else if (e.getSource() == buttonBack) {
            this.dispose();
            new Menu().setVisible(true);;
        } else if (e.getSource() == buttonGetReport) {

            Date selectedDate = dateChooser.getDate();
            if (selectedDate == null) {
                JOptionPane.showMessageDialog(null, "Please select a date!", "No Date Selected", JOptionPane.WARNING_MESSAGE);
            }else{

                Calendar calendar = Calendar.getInstance();
                calendar.setTime(selectedDate);

                // Extract day, month, and year
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH) + 1; // Calendar.MONTH is 0-based, so add 1
                int year = calendar.get(Calendar.YEAR);
                String date=(year+"-"+month+"-"+day);
                this.dispose();
                System.out.println(date);
                new Report(date).setVisible(true);
            }
        }
    }

  
}
