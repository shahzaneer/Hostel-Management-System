package UIScreen; 

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import FileOperations.*;

public class UpdateEmail extends JFrame implements ActionListener {

    private JLabel email;
    private JTextField emailText;
    private JButton update, back;
    private String hostelID;

    public UpdateEmail(String hostelID) {
        super("Update Email");
        this.hostelID = hostelID;
        this.setSize(600, 600);
        this.setForeground(Color.BLACK);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(2, 2));

        
        email = new JLabel("Email");
        emailText = new JTextField();

        update = new JButton("Update");
        back = new JButton("Back");

        this.add(email);
        this.add(emailText);
        this.add(update);
        this.add(back);

        
        
        update.addActionListener(this);
        back.addActionListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == update) {
            String email = emailText.getText();

            HosteliteOperations ho = new HosteliteOperations();
            boolean updated = ho.updateEmail(hostelID, email);

            if (updated) {
                JOptionPane.showMessageDialog(null, "Email Updated");
            } else {
                JOptionPane.showMessageDialog(null, "Email Not Updated");
            }
        }
        else if(e.getSource() == back) {
            this.dispose();
            new Hostelite(hostelID);

        }
        
    }

    
    
}
