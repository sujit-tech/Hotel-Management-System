package com.hotelmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.sql.*;
import java.awt.event.*;
public class AddCustomer extends JFrame{
    JComboBox comboid;
    JTextField t1,t2,t3,t6;
    JRadioButton r1,r2;
    JLabel t5;
    Choice croom;
    AddCustomer(){
        JLabel text= new JLabel("NEW CUSTOMER FORM");
        text.setBounds(100,20,300,30);
        text.setFont(new Font("raleway",Font.PLAIN,20));
        add(text);

        JLabel lID= new JLabel("ID");
        lID.setBounds(35,80,100,14);
        lID.setFont(new Font("Raleway",Font.PLAIN,14));
        add(lID);

        String option[]={"Passport", "Aadhar Card", "Voter Id", "Driving license"};
        comboid = new JComboBox(option);
        comboid.setBounds(200,80,150,25);
        comboid.setBackground(Color.gray);
        add(comboid);

        JLabel l2 = new JLabel("Number :");
        l2.setBounds(35, 111, 200, 14);
        l2.setFont(new Font("Raleway", Font.BOLD, 14));
        add(l2);

        t1 = new JTextField();
        t1.setBounds(200, 111, 150, 20);
        add(t1);

        JLabel lblName_1 = new JLabel("Name :");
        lblName_1.setBounds(35, 151, 200, 14);
        lblName_1.setFont(new Font("Raleway", Font.BOLD, 14));
        add(lblName_1);

        t2 = new JTextField();
        t2.setBounds(200, 151, 150, 20);
        add(t2);

        JLabel lblGender = new JLabel("Gender :");
        lblGender.setBounds(35, 191, 200, 14);
        lblGender.setFont(new Font("Raleway", Font.BOLD, 14));
        add(lblGender);
        ButtonGroup b = new ButtonGroup();
        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Raleway", Font.BOLD, 14));
        r1.setBackground(Color.WHITE);
        r1.setBounds(200, 191, 80, 12);
        r1.setBackground(Color.gray);
        b.add(r1);add(r1);
        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Raleway", Font.BOLD, 14));
        r2.setBackground(Color.WHITE);
        r2.setBounds(290, 191, 100, 12);
        r2.setBackground(Color.gray);
        b.add(r2);add(r2);

        JLabel lblCountry = new JLabel("Country :");
        lblCountry.setBounds(35, 231, 200, 14);
        add(lblCountry);
        t3 = new JTextField();
        t3.setBounds(200, 231, 150, 20);
        add(t3);

        JLabel lblroom = new JLabel("Alloted Room No:");
        lblroom.setBounds(30, 281, 170, 14);
        lblroom.setFont(new Font("Raleway", Font.BOLD, 14));
        add(lblroom);

        croom = new Choice();
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from addroom");
            while(rs.next()){
                croom.add(rs.getString("roomno"));
            }
        }catch(Exception e){ }
        croom.setBounds(200, 274, 150, 20);
        add(croom);

        JLabel lblCheckInStatus = new JLabel("Checked-In :");
        lblCheckInStatus.setBounds(35, 316, 200, 14);
        add(lblCheckInStatus);
        LocalDateTime dT=LocalDateTime.now();
        DateTimeFormatter d= DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String fd =dT.format(d);

        JLabel lblDeposite = new JLabel("Deposit :");
        lblDeposite.setBounds(35, 359, 200, 14);
        add(lblDeposite);

        t5 = new JLabel(""+fd);
        t5.setBounds(200, 316, 150, 20);
        t5.setFont(new Font("Raleway", Font.BOLD, 14));
        add(t5);


        t6 = new JTextField();
        t6.setBounds(200, 359, 150, 20);
        add(t6);

        JButton btnNewButton = new JButton("Add");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Conn c = new Conn();
                String radio = null;

                if(r1.isSelected()){
                    radio = "Male";
                }
                else if(r2.isSelected()){
                    radio = "Female";
                }

                String s6 = croom.getSelectedItem();

                try{

                    String s1 = (String)comboid.getSelectedItem();
                    String s2 =  t1.getText();
                    String s3 =  t2.getText();
                    String s4 =  radio;
                    String s5 =  t3.getText();
                    String s7 =  t5.getText();
                    String s8 =  t6.getText();

                    String q1 = "insert into customer values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"')";
                    String q2 = "update addroom set rstatus = 'Occupied' where roomno = "+s6;
                    c.s.executeUpdate(q1);
                    c.s.executeUpdate(q2);


                    JOptionPane.showMessageDialog(null, "Data Inserted Successfully");
                    new Reception().setVisible(true);
                    setVisible(false);
                }catch(SQLException e1){
                    System.out.println(e1.getMessage());
                }
                catch(NumberFormatException s){
                    JOptionPane.showMessageDialog(null, "Please enter a valid Number");
                }
            }
        });
        btnNewButton.setBounds(100, 430, 120, 30);
        btnNewButton.setBackground(Color.BLACK);
        btnNewButton.setForeground(Color.WHITE);
        add(btnNewButton);

        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Reception().setVisible(true);
                setVisible(false);
            }
        });
        btnExit.setBounds(260, 430, 120, 30);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        add(btnExit);

        ImageIcon i1  = new ImageIcon("C:/Users/ADMIN/IdeaProjects/Hotelms/src/com/icons/5th.jpg");
        Image i3 = i1.getImage().getScaledInstance(300, 400,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(480,10,300,500);
        add(l1);

        setLayout(null);
        setBounds(250,150,850,570);
        setVisible(true);
        getContentPane().setBackground(Color.GRAY);


    }
    public static void main(String[] args){

        new AddCustomer();
    }
}