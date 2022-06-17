package UIScreen; 

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import FileOperations.*;

public class UpdateRoom extends JFrame implements ActionListener {

    private JLabel lHostelID, roomNo, roomType;
    private JTextField tHostelID, roomNoText, roomTypeText;
    private JButton update, back;

    public UpdateRoom() {
        super("Update Hostelite");
        this.setSize(600, 600);
        this.setForeground(Color.BLACK);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(4, 2));

        lHostelID = new JLabel("Hostel ID");
        roomNo = new JLabel("Room No");
        roomType = new JLabel("Room Type");

        tHostelID = new JTextField();
        roomNoText = new JTextField();
        roomTypeText = new JTextField();

        update = new JButton("Update");
        back = new JButton("Back");

        this.add(lHostelID);
        this.add(tHostelID);
        this.add(roomNo);
        this.add(roomNoText);
        this.add(roomType);
        this.add(roomTypeText);
        this.add(update);
        this.add(back);

        update.addActionListener(this);
        back.addActionListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == update) {
            String hostelID = tHostelID.getText();
            String roomNo = roomNoText.getText();
            String roomType = roomTypeText.getText();

            AdminOperations ao = new AdminOperations();
            boolean found = ao.updateRoom(hostelID, roomNo, roomType);

            if (found) {
                JOptionPane.showMessageDialog(null, "Room updated successfully");
            } 
            else {
                JOptionPane.showMessageDialog(null, "No such ID Found ");
            }
        }
        else if(e.getSource() == back) {
            this.dispose();
            new UpdateHostelite();
        }
        
    }
    
}
