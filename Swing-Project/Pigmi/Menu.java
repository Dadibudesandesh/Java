import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Menu extends Frame implements ActionListener {
    JButton buttonAddPigmi, buttonAddHolder, buttonViewAcoount, buttonViewPigmi, buttonGetReport, buttonTodayReport;

    Menu() {

        buttonAddPigmi = new JButton("Add Today's Pigmi");
        buttonAddPigmi.setBounds(100, 300, 300, 40);
        buttonAddPigmi.setFont(new Font("Raileway", Font.BOLD, 17));
        buttonAddPigmi.addActionListener(this);
        buttonAddPigmi.setFocusable(false);
        this.add(buttonAddPigmi);

        buttonAddHolder = new JButton("Add New Account Holder");
        buttonAddHolder.setBounds(550, 300, 300, 40);
        buttonAddHolder.setFont(new Font("Raileway", Font.BOLD, 17));
        buttonAddHolder.addActionListener(this);
        buttonAddHolder.setFocusable(false);
        this.add(buttonAddHolder);

        buttonViewPigmi = new JButton("View Pigmi");
        buttonViewPigmi.setBounds(100, 400, 300, 40);
        buttonViewPigmi.setFont(new Font("Raileway", Font.BOLD, 17));
        buttonViewPigmi.addActionListener(this);
        buttonViewPigmi.setFocusable(false);
        this.add(buttonViewPigmi);

        buttonViewAcoount = new JButton("View Account");
        buttonViewAcoount.setBounds(550, 400, 300, 40);
        buttonViewAcoount.setFont(new Font("Raileway", Font.BOLD, 17));
        buttonViewAcoount.addActionListener(this);
        buttonViewAcoount.setFocusable(false);
        this.add(buttonViewAcoount);

        buttonGetReport = new JButton("Get Report");
        buttonGetReport.setBounds(100, 500, 300, 40);
        buttonGetReport.setFont(new Font("Raileway", Font.BOLD, 17));
        buttonGetReport.addActionListener(e->getReport());
        buttonGetReport.setFocusable(false);
        this.add(buttonGetReport);

        buttonTodayReport = new JButton("Todays Report");
        buttonTodayReport.setBounds(550, 500, 300, 40);
        buttonTodayReport.setFont(new Font("Raileway", Font.BOLD, 17));
        buttonTodayReport.addActionListener(this);
        buttonTodayReport.setFocusable(false);
        this.add(buttonTodayReport);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonAddPigmi) {
            this.dispose();
            new AddPigmi().setVisible(true);
            ;
        } else if (e.getSource() == buttonAddHolder) {
            this.dispose();
            new AddHolder().setVisible(true);
            ;
        } else if (e.getSource() == buttonViewAcoount) {
            this.dispose();
            new ViewAccount().setVisible(true);

        }else if (e.getSource() == buttonTodayReport) {
            this.dispose();
            new TodayReport().setVisible(true);
        }
    }

    public void getReport(){
        this.dispose();
        new GetReport().setVisible(true);
    }
}
