package UIScreen; 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import ConcreteClasses.*;
import ConcreteClasses.Hostelite;
import FileOperations.*;


public class AddHostelite extends JFrame implements ActionListener {
    private JLabel lHostelID, lpassword, lFirstName, lSecondName, lEmail, lPhoneNumber,
            lRoomNo, lRoomType, lVehicleType, lVehicleNumber;

    private JTextField tHostelID, tpassword, tFirstName, tSecondName, tEmail, tPhoneNumber,
            tRoomNo, tRoomType, tVehicleType, tVehicleNumber;

    private JButton Add, Back;

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
            // now checking if the input HostelID exists or not
            String password = tpassword.getText();
            String firstName = tFirstName.getText();
            String secondName = tSecondName.getText();
            String hostelID = tHostelID.getText();
            String email = tEmail.getText();
            String phoneNumber = tPhoneNumber.getText();
            String roomNo = tRoomNo.getText();
            String roomType = tRoomType.getText();
            String vehicleType = tVehicleType.getText();
            String vehicleNumber = tVehicleNumber.getText();
            AdminOperations a = new AdminOperations();

            
            // getting input from the user for hostelite

            if(hostelID.equals("")||password.equalsIgnoreCase("") || firstName.equalsIgnoreCase("") || secondName.equalsIgnoreCase("") || email.equalsIgnoreCase("") || phoneNumber.equalsIgnoreCase("") || roomNo.equalsIgnoreCase("") || roomType.equalsIgnoreCase("") || vehicleNumber.equalsIgnoreCase("") || vehicleType.equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "Kindly Fill all text fields to add the Hostelite");
            }

            else if (a.hostelIDExists(hostelID)) {
                JOptionPane.showMessageDialog(null, "This Hostel Id already Exists !");
            }


            else if (!(roomType.equalsIgnoreCase("singleseator") || roomType.equalsIgnoreCase("biseator")
                    || roomType.equalsIgnoreCase("triseator"))) {
                JOptionPane.showMessageDialog(null, "Room Should be SingleSeator , Biseator or triseator");
            }

            else if(!(vehicleType.equalsIgnoreCase("car") || vehicleType.equalsIgnoreCase("bike") || vehicleType.equalsIgnoreCase("bicycle") || vehicleType.equalsIgnoreCase("null"))){
                JOptionPane.showMessageDialog(null, "Enter Correct Vehicle Type. Car , Bike or Bicycle");
            }
            else{
            
            // making Objects
            Mess m = new Mess();
            Parking p = new Parking(vehicleType, vehicleNumber);
            Room r = new Room(roomNo, roomType);
            Laundry l = new Laundry();
            RegistrationDateAndTime rdt = new RegistrationDateAndTime();

            // making Hostelite
            Hostelite h = new Hostelite(firstName, secondName, email, phoneNumber, hostelID, password, r, l, p, m, rdt);

            // making AdminFile Operations Object
            AdminOperations ao = new AdminOperations();
            ao.addHostelite(h);
            JOptionPane.showMessageDialog(null, "Hostelite Added Successfully");

        }

    }

        else if (e.getSource() == Back) {
            dispose();
            new Admin();
        }
    }

}
    
