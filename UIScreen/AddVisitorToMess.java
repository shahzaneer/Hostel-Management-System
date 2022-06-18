package UIScreen; 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import FileOperations.*;

public class AddVisitorToMess extends JFrame implements ActionListener {

    private JLabel  visitors , days;
    private JTextField visitorsText , daysText;
    private JButton update, back;
    private String hostelID;

    public AddVisitorToMess(String hostelID) {

        super("Add Visitors to Mess");
        this.hostelID = hostelID;
        this.setSize(600, 600);
        this.setForeground(Color.BLACK);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(4, 2));

        
        visitors = new JLabel("No of Visitors");
        visitorsText = new JTextField();

        days = new JLabel("No of days");
        daysText = new JTextField();


        update = new JButton("Update");
        back = new JButton("Back");

        this.add(visitors);
        this.add(visitorsText);
        this.add(days);
        this.add(daysText);
        this.add(update);
        this.add(back);

        update.addActionListener(this);
        back.addActionListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == update) {
            HosteliteOperations ho = new HosteliteOperations();
            int visitors = Integer.parseInt(visitorsText.getText());
            int days = Integer.parseInt(daysText.getText());

            boolean updated = ho.addVisitorToMess(hostelID, visitors, days);

            if(updated) {
                JOptionPane.showMessageDialog(null, "Visitors added to Mess!");
            }
            else {
                JOptionPane.showMessageDialog(null, "Try Again !");
            }
        }
        else if(e.getSource() == back) {
            this.dispose();
            new Hostelite(hostelID);

        }
        
    }
    
}
