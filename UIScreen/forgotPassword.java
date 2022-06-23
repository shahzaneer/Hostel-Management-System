package UIScreen;

import javax.swing.*;

import FileOperations.AdminOperations;

import java.awt.*;
import java.awt.event.*;

public class forgotPassword extends JFrame implements ActionListener {
    
    private JLabel HostelID;
    private JTextField HostelIDTextField;
    private JButton search, back;

    public forgotPassword() {
        
        this.setSize(600, 600);
        this.setForeground(Color.BLACK);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(2, 2));

        HostelID = new JLabel("Hostel ID");
        HostelIDTextField = new JTextField();
        search = new JButton("Search");
        back = new JButton("Back");

        this.add(HostelID);
        this.add(HostelIDTextField);
        this.add(search);
        this.add(back);

        search.addActionListener(this);
        back.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == search) {
            AdminOperations ao = new AdminOperations();
            String hostelID = HostelIDTextField.getText();
            String details = ao.getPass(hostelID);
            
            JOptionPane.showMessageDialog(null, details);
        }
        else if(e.getSource() == back) {
            this.dispose();
            new Admin();            
        }
    }
    
}
