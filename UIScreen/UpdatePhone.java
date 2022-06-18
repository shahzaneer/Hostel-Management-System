package UIScreen; 

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import FileOperations.*;

public class UpdatePhone extends JFrame implements ActionListener {

    private JLabel phoneNumber;
    private JTextField phoneNumberText;
    private JButton update, back;
    private String hostelID;

    public UpdatePhone(String hostelID) {
        super("Update Phone Number");
        this.hostelID = hostelID;
        this.setSize(600, 600);
        this.setForeground(Color.BLACK);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(2, 2));

    
        phoneNumber = new JLabel("Phone Number");
        phoneNumberText = new JTextField();

        update = new JButton("Update");
        back = new JButton("Back");

        this.add(phoneNumber);
        this.add(phoneNumberText);
        this.add(update);
        this.add(back);

        
        
        update.addActionListener(this);
        back.addActionListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == update) {

            String phoneNumber = phoneNumberText.getText();
            HosteliteOperations ho = new HosteliteOperations();
            boolean updated = ho.updatePhoneNumber(hostelID, phoneNumber);

            if (updated) {
                JOptionPane.showMessageDialog(null, "Phone Number Updated");
            } else {
                JOptionPane.showMessageDialog(null, "Phone Number Not Updated");
            }
        }

        else if(e.getSource() == back) {
            this.dispose();
            new Hostelite(hostelID);

        }
        
    }
    
}
