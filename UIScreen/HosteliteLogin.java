package UIScreen; 

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import ConcreteClasses.*;
import FileOperations.*;

public class HosteliteLogin extends JFrame implements ActionListener {
    private JLabel hostelID, Password;
    private JTextField hostelIDText, passwordText;
    private JButton LoginButton, backButton;


    public HosteliteLogin() {

        super("Hostelite Login ");
        this.setSize(600, 600);
        this.setForeground(Color.BLACK);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(3, 2));

        hostelID = new JLabel("Hostelite ID");
        Password = new JLabel("Password");
        hostelIDText = new JTextField();
        passwordText = new JTextField();
        LoginButton = new JButton("Login");
        backButton = new JButton("Back");

        this.add(hostelID);
        this.add(hostelIDText);
        this.add(Password);
        this.add(passwordText);
        this.add(LoginButton);
        this.add(backButton);

        LoginButton.addActionListener(this);
        backButton.addActionListener(this);





    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // System.out.println("IN hostelite ActionFunction");
        if (e.getSource() == LoginButton) {
            // System.out.println("Login triggered");
            String hostelID = hostelIDText.getText();
            String password = passwordText.getText();

            if (hostelID.equals("123") && password.equals("123")) {
                JOptionPane.showMessageDialog(null, "Login Successful");
                this.dispose();
                new Hostelite();
            } 
            else {
                JOptionPane.showMessageDialog(null, "Login Failed Try Again!");
            }
        }
        
        else if(e.getSource() == backButton) {
            this.dispose();
            new Main();
        }
    }
}
