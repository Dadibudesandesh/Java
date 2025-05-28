import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class PinChange extends JFrame implements ActionListener {
    int pin;
    JButton btnCancel, btnDone;
    JPasswordField PasswordFieldPin, PasswordFieldReEnter;

    String strinPin;
    int newPin;
    String stringRePin;
    int newRePin;

    PinChange(int pin) {
        this.pin = pin;
        
        this.setSize(800, 700);
        this.setLocation(250, 10);
        this.setResizable(false);
        this.setLayout(new BorderLayout());

        JLabel background = new JLabel(new ImageIcon("src/atm.jpg"));
        background.setLayout(null);
        this.add(background);

        JLabel labelNewPin = new JLabel("New Pin : ");
        labelNewPin.setBounds(100, 200, 200, 40);
        labelNewPin.setFont(new Font("Raleway", Font.BOLD, 20));
        labelNewPin.setForeground(Color.WHITE);
        background.add(labelNewPin);

        PasswordFieldPin = new JPasswordField(4);
        PasswordFieldPin.setBounds(250, 200, 190, 40);
        PasswordFieldPin.setFont(new Font("Raleway", Font.PLAIN, 20));
        PasswordFieldPin.setOpaque(false);
        PasswordFieldPin.setForeground(Color.WHITE);
        PasswordFieldPin.setBorder(new CompoundBorder(new LineBorder(Color.WHITE), new EmptyBorder(10, 10, 10, 10)));
        PasswordFieldPin.setCaretColor(Color.WHITE);

        PlainDocument docNewPin = (PlainDocument) PasswordFieldPin.getDocument();
        docNewPin.setDocumentFilter(new LimitDocumentFilter(4));
        background.add(PasswordFieldPin);

        JLabel labelReEnterPin = new JLabel("Re-Enter Pin : ");
        labelReEnterPin.setBounds(100, 250, 250, 40);
        labelReEnterPin.setFont(new Font("Raleway", Font.BOLD, 20));
        labelReEnterPin.setForeground(Color.WHITE);
        background.add(labelReEnterPin);

        PasswordFieldReEnter = new JPasswordField(4);
        PasswordFieldReEnter.setBounds(250, 250, 190, 40);
        PasswordFieldReEnter.setFont(new Font("Raleway", Font.PLAIN, 20));
        PasswordFieldReEnter.setOpaque(false);
        PasswordFieldReEnter.setForeground(Color.WHITE);
        PasswordFieldReEnter
                .setBorder(new CompoundBorder(new LineBorder(Color.WHITE), new EmptyBorder(10, 10, 10, 10)));
        PasswordFieldReEnter.setCaretColor(Color.WHITE);

        PlainDocument docReEnter = (PlainDocument) PasswordFieldReEnter.getDocument();
        docReEnter.setDocumentFilter(new LimitDocumentFilter(4));
        background.add(PasswordFieldReEnter);

        btnDone = new JButton("Change");
        btnDone.setBounds(70, 335, 100, 30);
        btnDone.setFocusable(false);
        btnDone.setBorderPainted(false);
        btnDone.setOpaque(false);
        btnDone.addActionListener(this);
        btnDone.setContentAreaFilled(false);
        btnDone.setForeground(Color.WHITE);
        btnDone.setFont(new Font("railway", Font.BOLD, 17));
        background.add(btnDone);

        btnCancel = new JButton("Cancel");
        btnCancel.setBounds(370, 335, 100, 30);
        btnCancel.setFocusable(false);
        btnCancel.setBorderPainted(false);
        btnCancel.addActionListener(this);
        btnCancel.setOpaque(false);
        btnCancel.setContentAreaFilled(false);
        btnCancel.setForeground(Color.WHITE);
        btnCancel.setFont(new Font("railway", Font.BOLD, 17));
        background.add(btnCancel);

        this.setVisible(true);

        System.out.println(PasswordFieldPin.getPassword().length);
    }

    // Document filter to limit input length
    static class LimitDocumentFilter extends javax.swing.text.DocumentFilter {
        private final int limit;

        LimitDocumentFilter(int limit) {
            this.limit = limit;
        }

        @Override
        public void insertString(FilterBypass fb, int offset, String str, javax.swing.text.AttributeSet attr)
                throws BadLocationException {
            if (str == null || (fb.getDocument().getLength() + str.length()) > limit) {
                return;
            }
            super.insertString(fb, offset, str, attr);
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String str, javax.swing.text.AttributeSet attrs)
                throws BadLocationException {
            if (str == null || (fb.getDocument().getLength() + str.length() - length) > limit) {
                return;
            }
            super.replace(fb, offset, length, str, attrs);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            strinPin = new String(PasswordFieldPin.getPassword());
            newPin = Integer.parseInt(strinPin);
            stringRePin = new String(PasswordFieldReEnter.getPassword());
            newRePin = Integer.parseInt(stringRePin);
        } catch (NumberFormatException ex) {
            System.out.println(ex.getMessage());
        }

        if (e.getSource() == btnDone) {
            if (PasswordFieldPin.getPassword().length == 0
                    && PasswordFieldReEnter.getPassword().length == 0) {
                JOptionPane.showMessageDialog(null, "Enter pin ", "Warning",
                        JOptionPane.WARNING_MESSAGE);
            } else if (PasswordFieldPin.getPassword().length < 4 && PasswordFieldPin.getPassword().length < 4) {
                JOptionPane.showMessageDialog(null, "In pin must have 4 digits ", "Warning",
                        JOptionPane.WARNING_MESSAGE);
            } else if (newPin != newRePin) {
                JOptionPane.showMessageDialog(null, "pin must be same", "Warning",
                        JOptionPane.WARNING_MESSAGE);
            } else {

                try {
                    Database db = new Database();
                    ResultSet selectResult=db.connection.prepareStatement("SELECT * FROM USER WHERE pin='"+pin+"'").executeQuery();
                    if (selectResult.next()) {
                        long cardNumber=selectResult.getLong("cardnumber");
                    }
                    PreparedStatement preparedStatement = db.connection
                            .prepareStatement("update user set pin='" + newPin + "' where pin='" + pin + "'");
                    int updateResult = preparedStatement.executeUpdate();
                    int answer=0;
                    if (pin == newPin) {
                        answer = JOptionPane.showConfirmDialog(null, "This pin in use, You continue with this pin? ",
                                "Confirmation", JOptionPane.YES_NO_CANCEL_OPTION);
                    } 
                    
                     if (answer==0 ) {
                        JOptionPane.showMessageDialog(null, "Pin updated Successfully....", "Success",
                                JOptionPane.INFORMATION_MESSAGE);
                                PasswordFieldPin.setText("");
                                PasswordFieldReEnter.setText("");
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } else if (e.getSource() == btnCancel) {
            this.dispose();
            new Transaction(pin);
        }
    }
}
