import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame implements ActionListener {
    private JLabel heading;
    private JButton Admin;
    private JButton Hostelite;

    public Main() {
        super("Hostel Management System");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);

        heading = new JLabel("Weclome to Hostel Management System");
        heading.setBounds(90, 50, 300, 50);
        add(heading);

        Admin = new JButton("Admin");
        Admin.setBounds(50, 150, 100, 50);
        add(Admin);

        Hostelite = new JButton("Hostelite");
        Hostelite.setBounds(200, 150, 100, 50);
        add(Hostelite);

        Admin.addActionListener(this);
        Hostelite.addActionListener(this);




    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Admin) {

        }

        else if (e.getSource() == Hostelite) {

        }     
    }

}