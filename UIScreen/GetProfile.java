package UIScreen; 

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import FileOperations.*;

public class GetProfile extends JFrame implements ActionListener {

    JButton profileInfo, back;
    private String hostelID;

    public GetProfile(String hostelID) {
        super("Profile");
        this.hostelID = hostelID;
        this.setSize(600, 600);
        this.setForeground(Color.BLACK);
        this.setVisible(true);
        this.setLayout(new GridLayout(2, 1));

        profileInfo = new JButton("Profile Info");
        back = new JButton("Back");

        this.add(profileInfo);
        this.add(back);

        back.addActionListener(this);
        profileInfo.addActionListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == back) {
            this.dispose();
            new Hostelite(hostelID);
        }
        else if (e.getSource() == profileInfo) {
            HosteliteOperations h = new HosteliteOperations();
            String profile = h.getProfileInfo(hostelID);
            JOptionPane.showMessageDialog(null,profile);
        }
        
    }

}
