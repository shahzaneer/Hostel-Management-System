package UIScreen; 

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import ConcreteClasses.*;
import FileOperations.*;

public class GetProfile extends JFrame implements ActionListener {

    JLabel hostelIDl;
    JTextField hostelIDt;
    JButton profileInfo, back;

    public GetProfile() {
        super("Profile");
        this.setSize(600, 600);
        this.setForeground(Color.BLACK);
        this.setVisible(true);
        this.setLayout(new GridLayout(2, 2));

        hostelIDl = new JLabel("Hostel ID");
        hostelIDt = new JTextField();
        profileInfo = new JButton("Profile Info");
        back = new JButton("Back");

        this.add(hostelIDl);
        this.add(hostelIDt);
        this.add(profileInfo);
        this.add(back);

        back.addActionListener(this);
        profileInfo.addActionListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == back) {
            this.dispose();
            new Hostelite();
        }
        else if (e.getSource() == profileInfo) {
            HosteliteOperations h = new HosteliteOperations();
            String hostelID = hostelIDt.getText();
            String profile = h.getProfileInfo(hostelID);
            JOptionPane.showMessageDialog(null,profile);
        }
        
    }

}
