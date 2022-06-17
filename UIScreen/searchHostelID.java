package UIScreen; 

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import FileOperations.*;

public class searchHostelID extends JFrame implements ActionListener {
    private JLabel hostelID;
    private JTextField hostelIDText;
    private JButton search;
    private JButton back;

    public searchHostelID() {
        super("Search Hostelite");
        this.setSize(600, 600);
        this.setForeground(Color.BLACK);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(3, 2));

        hostelID = new JLabel("Hostel ID");
        hostelIDText = new JTextField();
        search = new JButton("Search");
        back = new JButton("Back");

        this.add(hostelID);
        this.add(hostelIDText);
        this.add(search);
        this.add(back);

        search.addActionListener(this);
        back.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == search) {
            AdminOperations ao = new AdminOperations();
            String hostelID = hostelIDText.getText();

            String details = ao.searchByHostelID(hostelID);

            JOptionPane.showMessageDialog(null, details);
        }
        else if(e.getSource() == back) {
            this.dispose();
            new SearchHostelite();
        }
    }
    
}
