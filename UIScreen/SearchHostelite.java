package UIScreen; 

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SearchHostelite extends JFrame implements ActionListener {
    private JButton searchName, searchHostelID, searchYear, searchRoomType;
    private JButton back;

    public SearchHostelite() {
        super("Search Hostelite");
        this.setSize(600, 600);
        this.setForeground(Color.BLACK);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(5, 1));

        searchName = new JButton("Search by Name");
        searchHostelID = new JButton("Search by Hostel ID");
        searchYear = new JButton("Search by Year");
        searchRoomType = new JButton("Search by Room Type");
        back = new JButton("Back");

        this.add(searchName);
        this.add(searchHostelID);
        this.add(searchYear);
        this.add(searchRoomType);
        this.add(back);

        searchName.addActionListener(this);
        searchHostelID.addActionListener(this);
        searchYear.addActionListener(this);
        searchRoomType.addActionListener(this);
        back.addActionListener(this);





    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == searchName) {
            this.dispose();
            new searchName();
        }
        else if(e.getSource() == searchHostelID) {
            this.dispose();
            new searchHostelID();
        }
        else if(e.getSource() == searchYear) {
            this.dispose();
            new searchYear();
        }
        else if(e.getSource() == searchRoomType) {
            this.dispose();
            new searchRoomType();
        }
        else if(e.getSource() == back) {
            this.dispose();
            new Admin();
        }
    }
    
}
