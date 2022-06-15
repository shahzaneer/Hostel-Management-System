import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BillInfo extends JFrame implements ActionListener {

    private JButton totalBills , searchHosteliteBill;
    private JButton adminScreen, homeScreen;

    public BillInfo() {

        super("Bill Info");
        this.setSize(600, 600);
        this.setForeground(Color.BLACK);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(2, 2));

        totalBills = new JButton("Total Bills");
        searchHosteliteBill = new JButton("Search Hostelite Bill");
        adminScreen = new JButton("Admin Screen");
        homeScreen = new JButton("Home Screen ");

        this.add(totalBills);
        this.add(searchHosteliteBill);
        this.add(adminScreen);
        this.add(homeScreen);

        totalBills.addActionListener(this);
        searchHosteliteBill.addActionListener(this);
        adminScreen.addActionListener(this);
        homeScreen.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == totalBills) {
            this.dispose();
            JOptionPane.showMessageDialog(null, "Total Bills: " + 8000);
        }
        else if(e.getSource() == searchHosteliteBill) {
            this.dispose();
            new SearchHosteliteBill();
        }
        else if(e.getSource() == adminScreen) {
            this.dispose();
            new Admin();
        }
        else if(e.getSource() == homeScreen) {
            this.dispose();
            new Main();
        }
    }
    
}
