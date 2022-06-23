package UIScreen; 

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import FileOperations.*;

public class searchYear extends JFrame implements ActionListener {
    private JLabel year;
    private JTextField yearText;
    private JButton search;
    private JButton back;

    public searchYear() {
        super("Search Hostelite");
        this.setSize(600, 600);
        this.setForeground(Color.BLACK);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(2, 2));

        year = new JLabel("Year");
        yearText = new JTextField();
        search = new JButton("Search");
        back = new JButton("Back");

        this.add(year);
        this.add(yearText);
        this.add(search);
        this.add(back);

        search.addActionListener(this);
        back.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == search) {
            AdminOperations ao = new AdminOperations();
            String year = yearText.getText();

            ArrayList<ConcreteClasses.Hostelite> arr = ao.searchByYear(year);

            if (arr.size() == 0) {
                JOptionPane.showMessageDialog(null, "No Record Found!");
            }
            else {
                for (int i = 0; i < arr.size(); i++) {
                    String details = arr.get(i).toString();
                    JOptionPane.showMessageDialog(null,details);
                }
            }
        }
        
        else if(e.getSource() == back) {
            this.dispose();
            new SearchHostelite();
        }
    }
    
}
