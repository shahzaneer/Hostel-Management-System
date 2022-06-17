package UIScreen; 

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import ConcreteClasses.*;
import FileOperations.*;

public class ChangePassword extends JFrame implements ActionListener {

    private JLabel lHostelID , password;
    private JTextField tHostelID , passwordText;
    private JButton update, back;

    public ChangePassword() {
        super("Change Password");
        this.setSize(600, 600);
        this.setForeground(Color.BLACK);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(3, 2));

        lHostelID = new JLabel("Hostel ID");
        tHostelID = new JTextField();

        password = new JLabel("Password");
        passwordText = new JTextField();

        update = new JButton("Update");
        back = new JButton("Back");

        this.add(lHostelID);
        this.add(tHostelID);
        this.add(password);
        this.add(passwordText);
        this.add(update);
        this.add(back);

        
        
        update.addActionListener(this);
        back.addActionListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == update) {
            HosteliteOperations ho = new HosteliteOperations();
            String hostelID = tHostelID.getText();
            String password = passwordText.getText();

            boolean updated = ho.changePassword(hostelID, password);

            if (updated) {
                JOptionPane.showMessageDialog(null, "Password Updated");
            } else {
                JOptionPane.showMessageDialog(null, "Password Not Updated");
            }
        }
        else if(e.getSource() == back) {
            this.dispose();
            new Hostelite();

        }
        
    }
    
}
