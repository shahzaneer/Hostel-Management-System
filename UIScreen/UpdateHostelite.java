import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UpdateHostelite extends JFrame implements ActionListener {
    private JButton updateName, updateParking, updateRoom, messOffDays;
    private JButton back;

    public UpdateHostelite() {
        super("Update Hostelite");
        this.setSize(600, 600);
        this.setForeground(Color.BLACK);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(5, 1));

        updateName = new JButton("Update Name");
        updateParking = new JButton("Update Parking");
        updateRoom = new JButton("Update Room");
        messOffDays = new JButton("Add Mess Off Days");
        back = new JButton("Back");

        this.add(updateName);
        this.add(updateParking);
        this.add(updateRoom);
        this.add(messOffDays);
        this.add(back);

        updateName.addActionListener(this);
        updateParking.addActionListener(this);
        updateRoom.addActionListener(this);
        messOffDays.addActionListener(this);
        back.addActionListener(this);



    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == updateName) {
            this.dispose();
            new updateName();
        }
        else if(e.getSource() == updateParking) {
            this.dispose();
            new UpdateParking();
        }
        else if(e.getSource() == updateRoom) {
            this.dispose();
            new UpdateRoom();
        }
        else if(e.getSource() == messOffDays) {
            this.dispose();
            new setOffDaysInMess();
        }
        else if(e.getSource() == back) {
            this.dispose();
            new Admin();
        }
    }
    
}
