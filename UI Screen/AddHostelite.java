import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddHostelite extends JFrame implements ActionListener {
    private JLabel lHostelID , lpassword, lFirstName , lSecondName , lEmail, lPhoneNumber ,
            lRoomNo, lRoomType, lVehicleType, lVehicleNumber;

    private JTextField tHostelID , tpassword, tFirstName , tSecondName , tEmail, tPhoneNumber ,
            tRoomNo, tRoomType, tVehicleType, tVehicleNumber;
    
    private JButton Add , Back;

    public AddHostelite() {
        super("Add Hostelite");
        this.setSize(600, 600);
        this.setForeground(Color.BLACK);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(11, 2));

        lHostelID = new JLabel("Hostelite ID");
        lpassword = new JLabel("Password");
        lFirstName = new JLabel("First Name");
        lSecondName = new JLabel("Second Name");
        lEmail = new JLabel("Email");
        lPhoneNumber = new JLabel("Phone Number");
        lRoomNo = new JLabel("Room No");
        lRoomType = new JLabel("Room Type");
        lVehicleType = new JLabel("Vehicle Type");
        lVehicleNumber = new JLabel("Vehicle Number");

        tHostelID = new JTextField();
        tpassword = new JTextField();
        tFirstName = new JTextField();
        tSecondName = new JTextField();
        tEmail = new JTextField();
        tPhoneNumber = new JTextField();
        tRoomNo = new JTextField();
        tRoomType = new JTextField();
        tVehicleType = new JTextField();
        tVehicleNumber = new JTextField();

        Add = new JButton("Add");
        Back = new JButton("Back");

        this.add(lHostelID);
        this.add(tHostelID);
        this.add(lpassword);
        this.add(tpassword);
        this.add(lFirstName);
        this.add(tFirstName);
        this.add(lSecondName);
        this.add(tSecondName);
        this.add(lEmail);
        this.add(tEmail);
        this.add(lPhoneNumber);
        this.add(tPhoneNumber);
        this.add(lRoomNo);
        this.add(tRoomNo);
        this.add(lRoomType);
        this.add(tRoomType);
        this.add(lVehicleType);
        this.add(tVehicleType);
        this.add(lVehicleNumber);
        this.add(tVehicleNumber);
        this.add(Add);
        this.add(Back);

        Add.addActionListener(this);
        Back.addActionListener(this);




    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Add) {
            String hostelID = tHostelID.getText();
            String password = tpassword.getText();
            String firstName = tFirstName.getText();
            String secondName = tSecondName.getText();
            String email = tEmail.getText();
            String phoneNumber = tPhoneNumber.getText();
            String roomNo = tRoomNo.getText();
            String roomType = tRoomType.getText();
            String vehicleType = tVehicleType.getText();
            String vehicleNumber = tVehicleNumber.getText();

            //adding logic here
            JOptionPane.showMessageDialog(null, "Hostelite Added Successfully");

        }
        
        else if (e.getSource() == Back) {
            dispose();
            new Admin();
        }
    }
    
}
