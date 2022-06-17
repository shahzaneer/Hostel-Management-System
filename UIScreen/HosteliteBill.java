import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HosteliteBill extends JFrame implements ActionListener {
    private JLabel hostelID;
    private JTextField hostelIDText;
    private JButton search;
    private JButton back;

    public HosteliteBill() {
        super("Search Hostelite Bill");
        this.setSize(600, 600);
        this.setForeground(Color.BLACK);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(2, 2));

        hostelID = new JLabel("Hostel ID");
        hostelIDText = new JTextField();
        search = new JButton("Search");
        back = new JButton("Back");

        this.add(hostelID);
        this.add(hostelIDText);
        this.add(search);
        this.add(back);

        search.addActionListener(this);
        back.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == search) {
            JOptionPane.showMessageDialog(null, "Bill is: ");
            
        }
        else if(e.getSource() == back) {
            this.dispose();
            new BillInfo();
        }
    }
    
}
