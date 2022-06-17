package UIScreen; 

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import FileOperations.*;

public class HosteliteBill extends JFrame implements ActionListener {
    private JButton search;
    private JButton back;

    public HosteliteBill() {
        super("Search Hostelite Bill");
        this.setSize(600, 600);
        this.setForeground(Color.BLACK);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(2, 2));

        search = new JButton("Search");
        back = new JButton("Back");

        this.add(search);
        this.add(back);

        search.addActionListener(this);
        back.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == search) {
            AdminInsightsAndBills ad = new AdminInsightsAndBills();
            String details = ad.totalIncomeOfHostel();
            JOptionPane.showMessageDialog(null, details);
        }
        else if(e.getSource() == back) {
            this.dispose();
            new BillInfo();
        }
    }
    
}
