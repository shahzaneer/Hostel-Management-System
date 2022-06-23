package UIScreen; 

import javax.swing.*;
import FileOperations.HosteliteOperations;
import java.awt.*;
import java.awt.event.*;

public class HosteliteLogin extends JFrame implements ActionListener {
    private JLabel hostelID, Password;
    private JTextField hostelIDText, passwordText;
    private JButton LoginButton, backButton;
    private JButton forgotPassword;



    public HosteliteLogin() {

        super("Hostelite Login ");
        this.setSize(600, 600);
        this.setForeground(Color.BLACK);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(4, 2));

        hostelID = new JLabel("Hostelite ID");
        Password = new JLabel("Password");
        hostelIDText = new JTextField();
        passwordText = new JTextField();
        LoginButton = new JButton("Login");
        forgotPassword = new JButton("forgot Password");
        backButton = new JButton("Back");

        this.add(hostelID);
        this.add(hostelIDText);
        this.add(Password);
        this.add(passwordText);
        this.add(LoginButton);
        this.add(backButton);
        this.add(forgotPassword);

        LoginButton.addActionListener(this);
        backButton.addActionListener(this);
        forgotPassword.addActionListener(this);





    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == LoginButton) {
            HosteliteOperations ho = new HosteliteOperations();
            
            String hostelID = hostelIDText.getText();
            String password = passwordText.getText();
            boolean login = ho.credentialsFound(hostelID, password);

            if (login) {
                JOptionPane.showMessageDialog(null, "Login Successful");
                this.dispose();
                new Hostelite(hostelID);
            } 
            else {
                JOptionPane.showMessageDialog(null, "Login Failed Try Again!");
            }
        }
        
        else if (e.getSource() == backButton) {
            this.dispose();
            new Main();
        }
        
        else if (e.getSource() == forgotPassword) {
            this.dispose();
            new AdminLogin();

        }
    }
}
