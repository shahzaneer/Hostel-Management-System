import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GetProfile extends JFrame implements ActionListener {
    
    JButton profileInfo, back;

    public GetProfile() {
        super("Profile");
        this.setSize(600, 600);
        this.setForeground(Color.BLACK);
        this.setVisible(true);
        this.setLayout(new GridLayout(2, 1));

        profileInfo = new JButton("Profile Info");
        back = new JButton("Back");

        this.add(profileInfo);
        this.add(back);

        back.addActionListener(this);
        profileInfo.addActionListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == back) {
            this.dispose();
            new Hostelite();
        }
        else if(e.getSource() == profileInfo) {
            
            JOptionPane.showMessageDialog(null, "Shahzaneer AHMED");
        }
        
    }

}
