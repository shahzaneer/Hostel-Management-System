package UIScreen; 

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import FileOperations.*;

public class UpdatePhone extends JFrame implements ActionListener {

    private JLabel lHostelID , phoneNumber;
    private JTextField tHostelID , phoneNumberText;
    private JButton update, back;

    public UpdatePhone() {
        super("Update Phone Number");
        this.setSize(600, 600);
        this.setForeground(Color.BLACK);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(3, 2));

        lHostelID = new JLabel("Hostel ID");
        tHostelID = new JTextField();

        phoneNumber = new JLabel("Phone Number");
        phoneNumberText = new JTextField();

        update = new JButton("Update");
        back = new JButton("Back");

        this.add(lHostelID);
        this.add(tHostelID);
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
            String hostelID = tHostelID.getText();
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
            new Hostelite();

        }
        
    }
    
}
