import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DeleteHostelite extends JFrame implements ActionListener {
    
    private JButton deleteByName, deleteByID, back;

    public DeleteHostelite() {
        super("Delete Hostelite");
        this.setSize(600, 600);
        this.setForeground(Color.BLACK);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(3, 1));

        deleteByName = new JButton("Delete By Name");
        deleteByID = new JButton("Delete By Hostel ID");
        back = new JButton("Back");

        this.add(deleteByName);
        this.add(deleteByID);
        this.add(back);

        deleteByName.addActionListener(this);
        deleteByID.addActionListener(this);
        back.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == deleteByName) {
            this.dispose();
            new DeleteByName();
        }
        else if(e.getSource() == deleteByID) {
            this.dispose();
            new DeleteByID();
        }
        else if(e.getSource() == back) {
            this.dispose();
            new Admin();
        }
    }
    
}
