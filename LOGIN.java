package com.hotelmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class LOGIN extends JFrame implements ActionListener{
    JTextField username;JPasswordField Password;
    JButton Login,cancel;
    LOGIN(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JLabel user = new JLabel("Username");
        user.setBounds(40,20,150,60);
        add(user);

        username = new JTextField();
        username.setBounds(120,37,150,25);
        add(username);

        JLabel Pass = new JLabel("Password");
        Pass.setBounds(40,80,150,60);
        add(Pass);
        Password = new JPasswordField();
        Password.setBounds(120,97,150,25);
        add(Password);
        Login = new JButton("LOGIN");
        Login.setBounds(40,170,120,25);
        Login.setBackground(Color.BLACK);
        Login.setForeground(Color.WHITE);
        Login.addActionListener(this);
        add(Login);

        cancel = new JButton("Cancel");
        cancel.setBounds(175,170,120,25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon img = new ImageIcon("C:/Users/ADMIN/IdeaProjects/Hotelms/src/com/icons/download.png");
        Image img1 = img.getImage().getScaledInstance(200,157,Image.SCALE_DEFAULT);// this is used to make image size small
        ImageIcon img2 = new ImageIcon(img1);//we cant add image directly to jlabel thats why imageicon class is used once again.
        JLabel image = new JLabel(img2);
        image.setBounds(350,10,200,200);//image boundary
        add(image);
        setBounds(400,180,650,400);// outer layer
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==Login){
        String user =username.getText();
        String pass =Password.getText();
        try{
            Conn c= new Conn();//creating the connection with sql login table
            String query= "select * from login where username='"+user+ "'and password='"+pass+"'";//query to run with sql
            ResultSet r= c.s.executeQuery(query);//running the query with the help of conn file createstatement
            if(r.next()){//checks the content from the database.
                setVisible(false);
                new DashBoard();
            }else{
                JOptionPane.showMessageDialog(null,"Invalid user and Password");
                setVisible(false);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        }else if (ae.getSource()==cancel){
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new LOGIN();
    }
}
