package com.hotelmanagementsystem;
import java.awt.event.ActionListener;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener{
    HotelManagementSystem(){
        setBounds(10,15,1360,700);//x and y which is 10 and 10 are the location of the frame and width 1320 and height 700 is the size of the frame according to the size of image.
        ImageIcon i1=new ImageIcon("C:/Users/ADMIN/IdeaProjects/Hotelms/src/com/icons/wp1846070-3785376209.jpg");// it passes the loaction of the img and pass it to the obj.
        JLabel image = new JLabel(i1);//jlable is used to place the img in the label and text as well.
        add(image);
        JLabel text = new JLabel("WELCOME  TO");
        text.setBounds(400,20,600,400);
        text.setFont(new Font("serif",Font.BOLD,50));
        text.setForeground(Color.WHITE);
        image.add(text);
        JLabel text1 = new JLabel("HOTEL MANAGEMENT SYSTEM");
        text1.setBounds(250,30,800,500);
        text1.setFont(new Font("serif",Font.BOLD,50));
        text1.setForeground(Color.WHITE);
        image.add(text1);
        JButton Login = new JButton("LOGIN");
        Login.setBounds(550,350,150,50);
        Login.setBackground(Color.green);
        Login.addActionListener(this);
        Login.setFont(new Font("serif",Font.PLAIN,25));
        Login.setForeground(Color.WHITE);
        image.add(Login);// image.add is used to place the login button outside the image.

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new LOGIN();
    }

    public static void main(String[] args) {
        // write your code here
        new HotelManagementSystem();
    }

}

