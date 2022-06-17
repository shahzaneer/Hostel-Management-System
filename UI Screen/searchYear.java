import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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
        if(e.getSource() == search) {
            this.dispose();
            new searchYear();
        }
        else if(e.getSource() == back) {
            this.dispose();
            new SearchHostelite();
        }
    }
    
}