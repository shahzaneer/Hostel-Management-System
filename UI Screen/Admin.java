import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Admin extends JFrame implements ActionListener {
    private JButton addHostelite, searchHostelite, updateHostelite, deleteHostelite, billInfo, complaints;
    private JButton back;

    public Admin() {
        super("Admin Screen");
        this.setSize(600, 600);
        this.setForeground(Color.BLACK);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(7, 1));

        addHostelite = new JButton("Add Profile");
        searchHostelite = new JButton("Search Info");
        updateHostelite = new JButton("Update Info");
        deleteHostelite = new JButton("Delete Profile");
        billInfo = new JButton("Bill Info");
        complaints = new JButton("See Complaints");
        back = new JButton("Back");

        this.add(addHostelite);
        this.add(searchHostelite);
        this.add(updateHostelite);
        this.add(deleteHostelite);
        this.add(billInfo);
        this.add(complaints);
        this.add(back);

        addHostelite.addActionListener(this);
        searchHostelite.addActionListener(this);
        updateHostelite.addActionListener(this);
        deleteHostelite.addActionListener(this);
        billInfo.addActionListener(this);
        complaints.addActionListener(this);
        back.addActionListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == addHostelite) {
            this.dispose();
            new AddHostelite();
        }
        else if(e.getSource() == searchHostelite) {
            this.dispose();
            new SearchHostelite();
        }
        else if(e.getSource() == updateHostelite) {
            this.dispose();
            new UpdateHostelite();
        }
        else if(e.getSource() == deleteHostelite) {
            this.dispose();
            new DeleteHostelite();
        }
        else if(e.getSource() == billInfo) {
            this.dispose();
            new BillInfo();
        }
        else if (e.getSource() == complaints) {
            this.dispose();
            new Complaints();
        }
        
        else if(e.getSource() == back) {
            this.dispose();
            new Main();
        }
        
    } 
    
}
