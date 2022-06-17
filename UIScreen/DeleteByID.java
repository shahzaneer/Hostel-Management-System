package UIScreen; 

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import FileOperations.*;

public class DeleteByID extends JFrame implements ActionListener {


    private JLabel hostelID;
    private JTextField hostelIDText;
    private JButton delete , back;

    public DeleteByID() {
        super("Delete By Hostel ID");
        this.setSize(600, 600);
        this.setForeground(Color.BLACK);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(2, 2));

        hostelID = new JLabel("Hostel ID");
        hostelIDText = new JTextField();
        delete = new JButton("Delete");
        back = new JButton("Back");

        this.add(hostelID);
        this.add(hostelIDText);
        this.add(delete);
        this.add(back);

        delete.addActionListener(this);
        back.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == delete) {
            AdminOperations ao = new AdminOperations();
            String hostelID = hostelIDText.getText();

            boolean found = ao.removeHostelite(hostelID);

            if (found) {
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
