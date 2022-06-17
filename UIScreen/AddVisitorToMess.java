import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddVisitorToMess extends JFrame implements ActionListener {

    private JLabel lHostelID , visitors , days;
    private JTextField tHostelID , visitorsText , daysText;
    private JButton update, back;

    public AddVisitorToMess() {

        super("Add Visitors to Mess");
        this.setSize(600, 600);
        this.setForeground(Color.BLACK);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(4, 2));

        lHostelID = new JLabel("Hostel ID");
        tHostelID = new JTextField();

        visitors = new JLabel("No of Visitors");
        visitorsText = new JTextField();

        days = new JLabel("No of days");
        daysText = new JTextField();


        update = new JButton("Update");
        back = new JButton("Back");

        this.add(lHostelID);
        this.add(tHostelID);
        this.add(visitors);
        this.add(visitorsText);
        this.add(days);
        this.add(daysText);
        this.add(update);
        this.add(back);

        update.addActionListener(this);
        back.addActionListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == update) {
            JOptionPane.showMessageDialog(null, "Visitors Added to Mess !");
            this.dispose();
        }
        else if(e.getSource() == back) {
            this.dispose();
            new Hostelite();

        }
        
    }
    
}
