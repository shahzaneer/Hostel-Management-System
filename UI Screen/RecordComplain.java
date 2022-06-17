import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RecordComplain extends JFrame implements ActionListener {

    private JLabel lHostelID , complain;
    private JTextField tHostelID , complainText;
    private JButton update, back;

    public RecordComplain() {

        super("Record Complain");
        this.setSize(600, 600);
        this.setForeground(Color.BLACK);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(3, 2));

        lHostelID = new JLabel("Hostel ID");
        tHostelID = new JTextField();

        complain = new JLabel("Complain");
        complainText = new JTextField();

        update = new JButton("Update");
        back = new JButton("Back");

        this.add(lHostelID);
        this.add(tHostelID);
        this.add(complain);
        this.add(complainText);
        this.add(update);
        this.add(back);

        
        
        update.addActionListener(this);
        back.addActionListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == update) {
            JOptionPane.showMessageDialog(null, "Complain Registered !");
            this.dispose();
        }
        else if(e.getSource() == back) {
            this.dispose();
            new Hostelite();

        }
        
    }
    
}
