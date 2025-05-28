import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Report extends Frame implements Printable {
    String Date;
    long total_amount;
    long total_payable;
    long total_unpayable;
    Conn db = new Conn();
    Report(String Date) {
        this.Date = Date;

        // Create a JTable and a DefaultTableModel
        DefaultTableModel tableModel = new DefaultTableModel();
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 120, 900, 300); // Adjust size and position as needed
        this.add(scrollPane);

        try {
            // Database connection
           
            PreparedStatement preparedStatement = db.conn
                    .prepareStatement("SELECT * FROM todayspigmi WHERE date = ?");
            preparedStatement.setString(1, Date);
            ResultSet result = preparedStatement.executeQuery();

            // Populate table columns
            int columnCount = result.getMetaData().getColumnCount();
            String[] columnNames = new String[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                columnNames[i - 1] = result.getMetaData().getColumnName(i);
            }
            tableModel.setColumnIdentifiers(columnNames);

            // Populate table rows
            while (result.next()) {
                String[] rowData = new String[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    rowData[i - 1] = result.getString(i);
                }
                tableModel.addRow(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel labelTotal = new JLabel();
        labelTotal.setBounds(50, 450, 400, 40);
        labelTotal.setFont(new Font("RaileWay", Font.BOLD, 15));
        this.add(labelTotal);

        JLabel labelPayable = new JLabel();
        labelPayable.setBounds(50, 470, 400, 40);
        labelPayable.setFont(new Font("RaileWay", Font.BOLD, 15));
        this.add(labelPayable);
        
        JLabel labelUnpayable = new JLabel();
        labelUnpayable.setBounds(50, 490, 400, 40);
        labelUnpayable.setFont(new Font("RaileWay", Font.BOLD, 15));
        this.add(labelUnpayable);

         try {
            String querySelect = "SELECT sum(Amount) as Total_Amount FROM `todayspigmi` WHERE date=?";
            PreparedStatement selectStatement = db.conn.prepareStatement(querySelect);
            selectStatement.setString(1, Date);
            ResultSet selectResult = selectStatement.executeQuery();
            if (selectResult.next()) {
                total_amount = selectResult.getLong("Total_Amount");
                labelTotal.setText("Total Collection Of The Day     :  " + total_amount);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        try {
            String querySelect = "SELECT count(Amount) as total_payable FROM `todayspigmi` WHERE date=? and amount>0";
            PreparedStatement selectStatement = db.conn.prepareStatement(querySelect);
            selectStatement.setString(1, Date);
            ResultSet selectResult = selectStatement.executeQuery();

            if (selectResult.next()) {
                total_payable = selectResult.getLong("total_payable");
                labelPayable.setText("Total Pigmi Payable                    :  " + total_payable);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        // GETTING THE TOTAL COUNT OF PIGMI UNPAYBLES

        try {
            String querySelect = "SELECT count(Amount) as total_unpayable FROM `todayspigmi` WHERE date=? and amount=0";
            PreparedStatement selectStatement = db.conn.prepareStatement(querySelect);
            selectStatement.setString(1, Date);
            ResultSet selectResult = selectStatement.executeQuery();
            if (selectResult.next()) {
                total_unpayable = selectResult.getLong("total_unpayable");
                labelUnpayable.setText("Total Pigmi Unpayable               :  " + total_unpayable);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }


        // Add a print button
        JButton printButton = new JButton("Print");
        printButton.setBounds(50, 580, 200, 40); // Adjust position as needed
        printButton.addActionListener(e -> printFrame());
        this.add(printButton);

        JButton buttonBack=new JButton("Back");
        buttonBack.setBounds(750, 580, 200, 40);
        buttonBack.addActionListener(e-> goBack());
        this.add(buttonBack);
    }

    // Method to print the frame
    private void printFrame() {
        PrinterJob printerJob = PrinterJob.getPrinterJob();
        printerJob.setPrintable(this);
        boolean doPrint = printerJob.printDialog(); // Display print dialog
        if (doPrint) {
            try {
                printerJob.print(); // Send the job to the printer
            } catch (PrinterException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if (pageIndex > 0) {
            return NO_SUCH_PAGE; // No more pages to print
        }

        // Translate graphics to print the entire frame
        Graphics2D g2d = (Graphics2D) graphics;
        g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
        this.printAll(graphics); // Prints the entire frame content

        return PAGE_EXISTS; // Page exists and is rendered
    }


    public void goBack(){
        this.dispose();
        new Menu().setVisible(true);;
    }

}
