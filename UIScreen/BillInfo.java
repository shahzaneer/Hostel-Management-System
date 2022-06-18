package UIScreen; 

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import FileOperations.*;

public class BillInfo extends JFrame implements ActionListener {
    private JLabel hostelIDLabel;
    private JTextField hostelIDText;
    private JButton searchHosteliteBill;
    private JButton back;

    public BillInfo() {

        super("Bill Information");
        this.setSize(600, 600);
        this.setForeground(Color.BLACK);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(2, 2));


        hostelIDLabel = new JLabel("Hostel ID");
        hostelIDText = new JTextField();
        searchHosteliteBill = new JButton("Search Hostelite Bill");
        back = new JButton("Back");
        
        this.add(hostelIDLabel);
        this.add(hostelIDText);
        this.add(searchHosteliteBill);
        this.add(back);

        searchHosteliteBill.addActionListener(this);
        back.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == searchHosteliteBill) {
            
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
