package UIScreen; 

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import ConcreteClasses.*;
import FileOperations.*;

public class UpdateParking extends JFrame implements ActionListener {

    private JLabel lHostelID, vehicleType, vehicleNumber;
    private JTextField tHostelID, vehicleTypeText, vehicleNumberText;
    private JButton update, back;

    public UpdateParking() {
        super("Update Hostelite");
        this.setSize(600, 600);
        this.setForeground(Color.BLACK);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(4, 2));

        lHostelID = new JLabel("Hostel ID");
        vehicleType = new JLabel("Vehicle Type");
        vehicleNumber = new JLabel("Vehicle Number");

        tHostelID = new JTextField();
        vehicleTypeText = new JTextField();
        vehicleNumberText = new JTextField();

        update = new JButton("Update");
        back = new JButton("Back");

        this.add(lHostelID);
        this.add(tHostelID);
        this.add(vehicleType);
        this.add(vehicleTypeText);
        this.add(vehicleNumber);
        this.add(vehicleNumberText);
        this.add(update);
        this.add(back);

        update.addActionListener(this);
        back.addActionListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == update) {
            String hostelId = tHostelID.getText();
            String vehicleType = vehicleTypeText.getText();
            String vehicleNumber = vehicleNumberText.getText();

            AdminOperations ao = new AdminOperations();
            boolean found = ao.updateParking(hostelId, vehicleType, vehicleNumber);

            if (found) {
                JOptionPane.showMessageDialog(null, "Parking updated successfully");
            } else {
                JOptionPane.showMessageDialog(null, "No Hostel ID not found");
            }
            
        }
        else if(e.getSource() == back) {
            this.dispose();
            new UpdateHostelite();
        }
        
    }
    
}
