package UIScreen; 

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Hostelite extends JFrame implements ActionListener {

    JButton getProfile , changePassword, updateEmail , updatePhone,
            addvisitorToMess, addGarments, recordComplain, back;
            
    private String hostelID;        

    public Hostelite(String hostelID) {
        super("Hostelite Portal");
        this.hostelID = hostelID;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 600);
        this.setForeground(Color.BLACK);
        this.setVisible(true);
        this.setLayout(new GridLayout(8, 1));

        getProfile = new JButton("Get Profile");
        changePassword = new JButton("Change Password");
        updateEmail = new JButton("Update Email");
        updatePhone = new JButton("Update Phone");
        addvisitorToMess = new JButton("Add Visitor To Mess");
        addGarments = new JButton("Add Garments to Laundry");
        recordComplain = new JButton("Record Complain");
        back = new JButton("Back");

        this.add(getProfile);
        this.add(changePassword);
        this.add(updateEmail);
        this.add(updatePhone);
        this.add(addvisitorToMess);
        this.add(addGarments);
        this.add(recordComplain);
        this.add(back);

        getProfile.addActionListener(this);
        changePassword.addActionListener(this);
        updateEmail.addActionListener(this);
        updatePhone.addActionListener(this);
        addvisitorToMess.addActionListener(this);
        addGarments.addActionListener(this);
        recordComplain.addActionListener(this);
        back.addActionListener(this);

    }        

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == getProfile) {
            this.dispose();
            new GetProfile(hostelID);
        }
        else if (e.getSource() == changePassword) {
            this.dispose();
            new ChangePassword(hostelID);
        }
        else if (e.getSource() == updateEmail) {
            this.dispose();
            new UpdateEmail(hostelID);
        }
        else if (e.getSource() == updatePhone) {
            this.dispose();
            new UpdatePhone(hostelID);
        }
        else if (e.getSource() == addvisitorToMess) {
            this.dispose();
            new AddVisitorToMess(hostelID);
        }
        else if (e.getSource() == addGarments) {
            this.dispose();
            new AddGarments(hostelID);
        }
        else if (e.getSource() == recordComplain) {
            this.dispose();
            new RecordComplain(hostelID);
        }
        else if(e.getSource() == back) {
            this.dispose();
            new Main();
        }
    }
    

    
}
