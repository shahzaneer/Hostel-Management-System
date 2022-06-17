package UIScreen; 

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import FileOperations.*;

public class BillInfo extends JFrame implements ActionListener {
    private JLabel hostelIDLabel;
    private JTextField hostelIDText;
    private JButton totalIncome , searchHosteliteBill;
    private JButton back;

    public BillInfo() {

        super("Bill Information");
        this.setSize(600, 600);
        this.setForeground(Color.BLACK);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(4, 1));


        hostelIDLabel = new JLabel("Hostel ID");
        hostelIDText = new JTextField();
        totalIncome = new JButton("Total Income of Hostel");
        searchHosteliteBill = new JButton("Search Hostelite Bill");
        back = new JButton("Back");
        
        this.add(hostelIDLabel);
        this.add(hostelIDText);
        this.add(totalIncome);
        this.add(searchHosteliteBill);
        this.add(back);

        totalIncome.addActionListener(this);
        searchHosteliteBill.addActionListener(this);
        back.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == totalIncome) {
            AdminInsightsAndBills ad = new AdminInsightsAndBills();
            String total = ad.totalIncomeOfHostel();
            JOptionPane.showMessageDialog(null,total);
        }
        else if (e.getSource() == searchHosteliteBill) {
            
            AdminInsightsAndBills ad = new AdminInsightsAndBills();
            String hostelID = hostelIDText.getText();
            String details = ad.viewBillOfAHostelite(hostelID);
            JOptionPane.showMessageDialog(null, details);
            
        }

    else if (e.getSource() == back) {
        this.dispose();
        new Admin();
    }
    
    }
    
}
