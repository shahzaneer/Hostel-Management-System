package UIScreen; 

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import FileOperations.*;

public class DeleteByName extends JFrame implements ActionListener {


    private JLabel firstName, lastName;
    private JTextField firstNameText, lastNameText;
    private JButton delete , back;

    public DeleteByName() {
        super("Delete By Name");
        this.setSize(600, 600);
        this.setForeground(Color.BLACK);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(3, 2));

        firstName = new JLabel("First Name");
        lastName = new JLabel("Last Name");
        firstNameText = new JTextField();
        lastNameText = new JTextField();
        delete = new JButton("Delete");
        back = new JButton("Back");
        
        this.add(firstName);
        this.add(firstNameText);
        this.add(lastName);
        this.add(lastNameText);
        this.add(delete);
        this.add(back);

        delete.addActionListener(this);
        back.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == delete) {
            String firstName = firstNameText.getText();
            String lastName = lastNameText.getText();

            AdminOperations ao = new AdminOperations();

            boolean deleted = ao.removeHostelite(firstName, lastName);
            
            if(deleted) {
                JOptionPane.showMessageDialog(null, "Hostelite deleted successfully");
            }
            else {
                JOptionPane.showMessageDialog(null, "Hostelite not found");
            }

        }
        else if(e.getSource() == back) {
            this.dispose();
            new DeleteHostelite();
        }

    }
    
}
