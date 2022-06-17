package UIScreen; 

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BillInfo extends JFrame implements ActionListener {

    private JButton totalIncome , searchHosteliteBill;
    private JButton back;

    public BillInfo() {

        super("Bill Information");
        this.setSize(600, 600);
        this.setForeground(Color.BLACK);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(3, 1));

        totalIncome = new JButton("Total Income of Hostel");
        searchHosteliteBill = new JButton("Search Hostelite Bill");
        back = new JButton("Back");
        
        this.add(totalIncome);
        this.add(searchHosteliteBill);
        this.add(back);

        totalIncome.addActionListener(this);
        searchHosteliteBill.addActionListener(this);
        back.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == totalIncome) {
            JOptionPane.showMessageDialog(null, "Total Bills: " + 8000);
        }
        else if (e.getSource() == searchHosteliteBill) {
            this.dispose();
            new HosteliteBill();
        }

    else if (e.getSource() == back) {
        this.dispose();
        new Admin();
    }
    
    }
    
}
