import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminLogin extends JFrame implements ActionListener {
    private JLabel Username, Password;
    private JTextField UsernameText, passwordText;
    private JButton LoginButton, backButton;

    // did it private for security reasons
    private String adminPassword = "admin";
    private String adminUsername = "admin";

    public AdminLogin() {

        super("Admin Login ");
        this.setSize(600, 600);
        this.setForeground(Color.BLACK);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(3, 2));

        Username = new JLabel("Username");
        Password = new JLabel("Password");
        UsernameText = new JTextField();
        passwordText = new JTextField();
        LoginButton = new JButton("Login");
        backButton = new JButton("Back");

        this.add(Username);
        this.add(UsernameText);
        this.add(Password);
        this.add(passwordText);
        this.add(LoginButton);
        this.add(backButton);




    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == LoginButton) {
            String username = UsernameText.getText();
            String password = passwordText.getText();
            if(username.equals(adminUsername) && password.equals(adminPassword)) {
                JOptionPane.showMessageDialog(null, "Login Successful");
                this.dispose();
                new Admin();
            }
            else {
                JOptionPane.showMessageDialog(null, "Login Failed");
            }
        }
        else if(e.getSource() == backButton) {
            this.dispose();
            new Main();
        }
    }
}
