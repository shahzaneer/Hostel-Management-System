import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class searchRoomType extends JFrame implements ActionListener {
    private JLabel roomType;
    private JTextField roomTypeText;
    private JButton search;
    private JButton back;

    public searchRoomType() {
        super("Search Hostelite");
        this.setSize(600, 600);
        this.setForeground(Color.BLACK);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(3, 2));

        roomType = new JLabel("Room Type");
        roomTypeText = new JTextField();
        search = new JButton("Search");
        back = new JButton("Back");

        this.add(roomType);
        this.add(roomTypeText);
        this.add(search);
        this.add(back);

        search.addActionListener(this);
        back.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == search) {
            this.dispose();
            new searchRoomType();
        }
        else if(e.getSource() == back) {
            this.dispose();
            new SearchHostelite();
        }
    }
    
}
