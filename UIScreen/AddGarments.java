
package UIScreen; 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import FileOperations.*;

public class AddGarments extends JFrame implements ActionListener {

    private JLabel newGarments;
    private JTextField newGarmentsText;
    private JButton update, back;
    private String hostelID;

    public AddGarments(String hostelID) {
        super("Add Extra Garments to Laundry");
        this.hostelID = hostelID;
        this.setSize(600, 600);
        this.setForeground(Color.BLACK);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(2, 2));

    
        newGarments = new JLabel("new Garments");
        newGarmentsText = new JTextField();

        update = new JButton("Update");
        back = new JButton("Back");

        this.add(newGarments);
        this.add(newGarmentsText);
        this.add(update);
        this.add(back);
        
        update.addActionListener(this);
        back.addActionListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == update) {
            HosteliteOperations ho = new HosteliteOperations();
            double newGarments = Double.parseDouble( newGarmentsText.getText());
            boolean updated = ho.addExtraGarmetsToLaundry(hostelID, newGarments);
            if(updated) {
                JOptionPane.showMessageDialog(null, "Garments Limit updated!");
                this.dispose();
            }
            else {
                JOptionPane.showMessageDialog(null, "Hostel ID was not found!");
                this.dispose();
            }
        }
        else if(e.getSource() == back) {
            this.dispose();
            new Hostelite(hostelID);

        }
        
    }
    
}
