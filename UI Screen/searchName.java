import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class searchName extends JFrame implements ActionListener {
    private JLabel firstName, lastName;
    private JTextField firstNameText, lastNameText;
    private JButton search;
    private JButton back;

    public searchName() {
        super("Search Hostelite");
        this.setSize(600, 600);
        this.setForeground(Color.BLACK);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(3, 2));

        firstName = new JLabel("First Name");
        lastName = new JLabel("Last Name");
        firstNameText = new JTextField();
        lastNameText = new JTextField();
        search = new JButton("Search");
        back = new JButton("Back");

        this.add(firstName);
        this.add(firstNameText);
        this.add(lastName);
        this.add(lastNameText);
        this.add(search);
        this.add(back);

        search.addActionListener(this);
        back.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == search) {
            this.dispose();
            new searchName();
        }
        else if(e.getSource() == back) {
            this.dispose();
            new SearchHostelite();
        }
    }
    
}
