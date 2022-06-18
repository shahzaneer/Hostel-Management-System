package UIScreen; 

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import FileOperations.*;

public class setOffDaysInMess extends JFrame implements ActionListener {

    private JLabel lHostelID , offdays;
    private JTextField tHostelID, offdaysText;
    private JButton update, back;

    public setOffDaysInMess() {
        super("Update Hostelite");
        this.setSize(600, 600);
        this.setForeground(Color.BLACK);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(3, 2));

        lHostelID = new JLabel("Hostel ID");
        offdays = new JLabel("No of off days");

        tHostelID = new JTextField();
        offdaysText = new JTextField();

        update = new JButton("Update");
        back = new JButton("Back");

        this.add(lHostelID);
        this.add(tHostelID);
        this.add(offdays);
        this.add(offdaysText);
        this.add(update);
        this.add(back);

        update.addActionListener(this);
        back.addActionListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == update) {
            
            String hostelID = tHostelID.getText();
            int offdays = Integer.parseInt(offdaysText.getText());
            AdminOperations ao = new AdminOperations();
            boolean found = ao.setOffDaysInMess(hostelID, offdays);

            if (found) {
                JOptionPane.showMessageDialog(null, "Off days updated successfully");
            } else {
                JOptionPane.showMessageDialog(null, "no such Hostel ID Found");
            }

        }
        else if(e.getSource() == back) {
            this.dispose();
            new UpdateHostelite();
        }
        
    }
    
}
