package UIScreen; 

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import FileOperations.*;

public class searchVehicleType extends JFrame implements ActionListener {
    private JLabel vehiclel;
    private JTextField vehicleText;
    private JButton search;
    private JButton back;

    public searchVehicleType() {
        super("Search Vehicle Type");
        this.setSize(600, 600);
        this.setForeground(Color.BLACK);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(2, 2));

        vehiclel = new JLabel("Vehicle Type");
        vehicleText = new JTextField();
        search = new JButton("Search");
        back = new JButton("Back");

        this.add(vehiclel);
        this.add(vehicleText);
        this.add(search);
        this.add(back);

        search.addActionListener(this);
        back.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == search) {
            String vehicleType = vehicleText.getText();

            AdminOperations ao = new AdminOperations();

            ArrayList<ConcreteClasses.Hostelite> arr = ao.searchByVehicleType(vehicleType);

            if (arr.size() == 0) {
                JOptionPane.showMessageDialog(null, "No Such Vehicle Type Found!");
            } else {
                StringBuilder s = new StringBuilder();
                for (int i = 0; i < arr.size(); i++) {
                    String details = arr.get(i).getFirstName() + " " + arr.get(i).getLastName() + "\n" + "Hostel-ID :" + arr.get(i).getHostelID() + "\n";
                    s.append(details);
                }
                JOptionPane.showMessageDialog(null, s);

            }
        }
        
        else if(e.getSource() == back) {
            this.dispose();
            new SearchHostelite();
        }
    }
    
}
