package UIScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import FileOperations.*;


public class ViewAllProfiles extends JFrame implements ActionListener {
    
    JLabel profiles;
    JButton back;

    public ViewAllProfiles() {
        super("View All Profiles");
        this.setSize(600, 600);
        this.setForeground(Color.BLACK);
        this.setVisible(true);
        this.setLayout(new GridLayout(2, 1));
        AdminOperations ao = new AdminOperations();

        String s = ao.viewAllProfiles(); 
        profiles = new JLabel(s);

        JPanel panel = new JPanel();
        panel.add(profiles);

        back = new JButton("Back");

        

        JScrollPane scrollPane = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        this.add(scrollPane);
        this.add(back);

        back.addActionListener(this);

        

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            this.dispose();
            new Admin();
        }
        
    }
}
