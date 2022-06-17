import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Complaints extends JFrame implements ActionListener {
    JButton seeComplain;
    JButton back;

    public Complaints() {
        super("Complaints");
        this.setSize(600, 600);
        this.setForeground(Color.BLACK);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(2, 1));

        seeComplain = new JButton("See Complaints");
        back = new JButton("Back");

        this.add(seeComplain);
        this.add(back);

        seeComplain.addActionListener(this);
        back.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == seeComplain) {
            JOptionPane.showMessageDialog(null, "Boss bht mushkil horhi hai yahan per");

        }
        else if(e.getSource() == back) {
            this.dispose();
            new Admin();
        }
    }
    
}
