package UIScreen;

import javax.swing.*;

import FileOperations.AdminInsightsAndBills;

import java.awt.*;
import java.awt.event.*;

public class TotalIncome extends JFrame implements ActionListener {
    private JButton totalIncome;
    private JButton back;

    public TotalIncome() {
        super("Total Income");
        this.setSize(600, 600);
        this.setForeground(Color.BLACK);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(2, 1));

        totalIncome = new JButton("Total Income of Hostel");
        back = new JButton("Back");

        this.add(totalIncome);
        this.add(back);

        totalIncome.addActionListener(this);
        back.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == totalIncome) {
            AdminInsightsAndBills adt = new AdminInsightsAndBills();
            String totalIncome = adt.totalIncomeOfHostel();
            JOptionPane.showMessageDialog(null, totalIncome);
        }
        else if(e.getSource() == back) {
            this.dispose();
            new Admin();
        }


        
    }
    
}
