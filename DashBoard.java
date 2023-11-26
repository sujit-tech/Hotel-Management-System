package com.hotelmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DashBoard extends JFrame implements ActionListener {
    DashBoard(){
        setBounds(0,0,1950,990);
        setLayout(null);
        ImageIcon i1 = new ImageIcon("C:/Users/ADMIN/IdeaProjects/Hotelms/src/com/icons/D1.jpg");
        Image i2=i1.getImage().getScaledInstance(1950,990, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1950,990);
        add(image);
        JLabel text = new JLabel("Welcome to AAMANTRAN Hotel");
        text.setBounds(300,80,1000,45);
        text.setFont(new Font("ALGERIAN",Font.BOLD,45));
        text.setForeground(Color.BLACK);
        image.add(text);

        JMenuBar m = new JMenuBar();//JMenubar is used to add a menu bar at top header
        m.setBounds(0,0,1550,30);
        image.add(m);
        JMenu receptionist = new JMenu("RECEPTIONIST");//JMENU add the menu options on the menu bar
        receptionist.setForeground(Color.RED);
        m.add(receptionist);
        JMenuItem reception = new JMenuItem("RECEPTION");
        reception.addActionListener(this);
        receptionist.add(reception);

        JMenu admin = new JMenu("ADMIN");
        admin.setForeground(Color.BLUE);
        m.add(admin);
        JMenuItem addEmployee = new JMenuItem("ADD EMPLOYEE");
        addEmployee.addActionListener(this);
        admin.add(addEmployee);
        JMenuItem addrooms = new JMenuItem("ADD ROOMS");
        addrooms.addActionListener(this);
        admin.add(addrooms);
        setVisible(true);
        JMenuItem addDriver = new JMenuItem("ADD DRIVER");
        addDriver.addActionListener(this);
        admin.add(addDriver);
        setVisible(true);
    }
    public  void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("ADD EMPLOYEE")){
            new AddEmployee();
        }else if(ae.getActionCommand().equals("ADD ROOMS")){
            new AddRooms();
        }else if(ae.getActionCommand().equals("ADD DRIVER")){
            new AddDriver().setVisible(true);
        }else if(ae.getActionCommand().equals("RECEPTION")) {
            new Reception();
        }
}

        public static void main(String[] args) {
        new DashBoard();
    }
}
