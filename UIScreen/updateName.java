package UIScreen; 

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import ConcreteClasses.*;
import FileOperations.*;

public class updateName extends JFrame implements ActionListener {

    private JLabel lHostelID, lFirstName, lSecondName;
    private JTextField tHostelID, tFirstName, tSecondName;
    private JButton update, back;

    public updateName() {
        super("Update Hostelite");
        this.setSize(600, 600);
        this.setForeground(Color.BLACK);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(4, 2));

        lHostelID = new JLabel("Hostel ID");
        lFirstName = new JLabel("First Name");
        lSecondName = new JLabel("Second Name");

        tHostelID = new JTextField();
        tFirstName = new JTextField();
        tSecondName = new JTextField();

        update = new JButton("Update");
        back = new JButton("Back");

        this.add(lHostelID);
        this.add(tHostelID);
        this.add(lFirstName);
        this.add(tFirstName);
        this.add(lSecondName);
        this.add(tSecondName);
        this.add(update);
        this.add(back);

        update.addActionListener(this);
        back.addActionListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == update) {
            this.dispose();
            
        }
        else if(e.getSource() == back) {
            this.dispose();
            new UpdateHostelite();
        }
        
    }
    
}
