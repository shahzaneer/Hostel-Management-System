package UIScreen; 

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import ConcreteClasses.*;
import FileOperations.*;

public class searchName extends JFrame implements ActionListener {
    private JLabel firstName;
    private JTextField firstNameText;
    private JButton search;
    private JButton back;

    public searchName() {
        super("Search Hostelite");
        this.setSize(600, 600);
        this.setForeground(Color.BLACK);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(2, 2));

        firstName = new JLabel("First Name");
        firstNameText = new JTextField();
        search = new JButton("Search");
        back = new JButton("Back");

        this.add(firstName);
        this.add(firstNameText);
        this.add(search);
        this.add(back);

        search.addActionListener(this);
        back.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == search) {
            String firstName = firstNameText.getText();

            AdminOperations ao = new AdminOperations();

            String details = ao.searchByName(firstName);

            JOptionPane.showMessageDialog(null, details);
        }
        else if(e.getSource() == back) {
            this.dispose();
            new SearchHostelite();
        }
    }
    
}
