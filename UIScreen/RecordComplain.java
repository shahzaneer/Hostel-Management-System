package UIScreen; 

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import FileOperations.*;

public class RecordComplain extends JFrame implements ActionListener {

    private JLabel complain;
    private JTextField complainText;
    private JButton update, back;
    private String hostelID;

    public RecordComplain(String hostelID) {

        super("Record Complain");
        this.hostelID = hostelID;
        this.setSize(600, 600);
        this.setForeground(Color.BLACK);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(2, 2));

        
        complain = new JLabel("Complain");
        complainText = new JTextField();

        update = new JButton("Update");
        back = new JButton("Back");

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
            HosteliteOperations ho = new HosteliteOperations();
            String complain = complainText.getText();

            boolean updated = ho.recordComplain(hostelID, complain);

            if (updated) {
                JOptionPane.showMessageDialog(null, "Complain Recorded !");
            } else {
                JOptionPane.showMessageDialog(null, "Complain Not Recorded");
            }
        }
        
        else if(e.getSource() == back) {
            this.dispose();
            new Hostelite(hostelID);

        }
        
    }
    
}
