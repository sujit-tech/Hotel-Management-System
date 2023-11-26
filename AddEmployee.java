package com.hotelmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AddEmployee extends JFrame implements ActionListener {
    JTextField tfeName,tfeAge,tfeSalary,tfePhone,tfeEmail,tfeadhaar;
    JRadioButton erbmale,erbfemale;
    JComboBox cbejob;
    JButton submit;

    AddEmployee(){
        setLayout(null);
        JLabel eName = new JLabel("NAME :");
        eName.setBounds(60,30,120,30);
        eName.setFont(new Font("ALGERIAN",Font.ITALIC,17));
        add(eName);
        tfeName=new JTextField();
        tfeName.setBounds(180,35,150,20);
        add(tfeName);

        JLabel eAge = new JLabel("AGE :");
        eAge.setBounds(60,80,120,30);
        eAge.setFont(new Font("ALGERIAN",Font.ITALIC,17));
        add(eAge);
         tfeAge=new JTextField();
        tfeAge.setBounds(180,85,150,20);
        add(tfeAge);

        JLabel eGender = new JLabel("GENDER :");
        eGender.setBounds(60,130,120,30);
        eGender.setFont(new Font("ALGERIAN",Font.ITALIC,17));
        add(eGender);
        ButtonGroup b = new ButtonGroup();//button group is used to make a group of button to select any 1 option
         erbmale=new JRadioButton("Male");
        erbmale.setBounds(180,130,70,30);
        erbmale.setFont(new Font("ALGERIAN",Font.ITALIC,17));
        erbmale.setBackground(Color.gray);
        b.add(erbmale);add(erbmale);//first add the option in button group then add into the panel.
         erbfemale=new JRadioButton("Female");
        erbfemale.setBounds(250,130,90,30);
        erbfemale.setFont(new Font("ALGERIAN",Font.ITALIC,17));
        erbfemale.setBackground(Color.gray);
        b.add(erbfemale);add(erbfemale);

        JLabel ejob = new JLabel("JOB :");
        ejob.setBounds(60,180,120,30);
        ejob.setFont(new Font("ALGERIAN",Font.ITALIC,17));
        add(ejob);
        String jobs[]={"Manager","Accountant","Front Desk Clerk","Porters","Housekeeping","Kitchen Staff","Room Service","Chefs","waiter/Waitress"};
         cbejob = new JComboBox(jobs);
        cbejob.setBounds(185,185,150,30);
        cbejob.setBackground(Color.WHITE);
        add(cbejob);

        JLabel eSalary = new JLabel("SALARY :");
        eSalary.setBounds(60,230,120,30);
        eSalary.setFont(new Font("ALGERIAN",Font.ITALIC,17));
        add(eSalary);
         tfeSalary=new JTextField();
        tfeSalary.setBounds(180,235,150,20);
        add(tfeSalary);

        JLabel ePhoneno = new JLabel("Phone no:");
        ePhoneno.setBounds(60,280,120,30);
        ePhoneno.setFont(new Font("ALGERIAN",Font.ITALIC,17));
        add(ePhoneno);
         tfePhone=new JTextField();
        tfePhone.setBounds(180,285,150,20);
        add(tfePhone);

        JLabel eEmail = new JLabel("E-mail :");
        eEmail.setBounds(60,320,120,30);
        eEmail.setFont(new Font("ALGERIAN",Font.ITALIC,17));
        add(eEmail);
         tfeEmail=new JTextField();
        tfeEmail.setBounds(180,325,150,20);
        add(tfeEmail);

        JLabel eadhaar = new JLabel("Aadhaar No :");
        eadhaar.setBounds(40,360,140,30);
        eadhaar.setFont(new Font("ALGERIAN",Font.ITALIC,17));
        add(eadhaar);
        tfeadhaar=new JTextField();
        tfeadhaar.setBounds(180,365,150,20);
        add(tfeadhaar);
         submit = new JButton("SUBMIT");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.gray);
        submit.setBounds(185,410,150,30);
        submit.addActionListener(this);
        add(submit);

        ImageIcon img = new ImageIcon("C:/Users/ADMIN/IdeaProjects/Hotelms/src/com/icons/logo.jpg");
        Image img1 = img.getImage().getScaledInstance(200,157,Image.SCALE_DEFAULT);// this is used to make image size small
        ImageIcon img2 = new ImageIcon(img1);//we cant add image directly to jlabel thats why imageicon class is used once again.
        JLabel image = new JLabel(img2);
        image.setBounds(400,10,400,400);//image boundary
        add(image);
        setBounds(400,150,650,450);// outer layer
        setVisible(true);

        getContentPane().setBackground(Color.gray);
        setBounds(250,150,850,540);
        setVisible(true);
    }
    public  void actionPerformed(ActionEvent ae){
    String name=tfeName.getText();
    String age = tfeAge.getText();
    String salary = tfeSalary.getText();
    String phone = tfePhone.getText();
    String Aadhaar = tfeadhaar.getText();
    String Email=tfeEmail.getText();
    String gender=null;

    if(name.equals("")){
        JOptionPane.showMessageDialog(null,"please enter Name");
        return;
    }
    if(Email.equals("")&&Email.contentEquals("@")&&Email.contentEquals(".com")){
        JOptionPane.showMessageDialog(null,"please enter valid E-mail id");
        return;
    }

    if(erbmale.isSelected()){
        gender="Male";
    }else if(erbfemale.isSelected()){
        gender="Female";
        }
    String job = (String) cbejob.getSelectedItem();
    try{
    Conn conn=new Conn();
    String query="insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+Email+"','"+Aadhaar+"')";
    conn.s.executeUpdate(query);
    JOptionPane.showMessageDialog(null,"Data entered successfully");
    }catch (Exception e){
        e.printStackTrace();
    }
    }

    public static void main(String[] args) {
        new AddEmployee();
    }
}
