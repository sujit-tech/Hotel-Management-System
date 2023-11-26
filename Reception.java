package com.hotelmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Reception extends JFrame{
 JButton newCustomer;
    Reception(){
     newCustomer = new JButton("new Customer");
     newCustomer.setBounds(10,30,200,30);
     newCustomer.setBackground(Color.BLACK);
     newCustomer.setForeground(Color.white);
     newCustomer.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
       try{
        AddCustomer custom = new AddCustomer();
        custom.setVisible(true);
        setVisible(false);
       }catch(Exception e1){
        e1.printStackTrace();
       }
      }
     });
     add(newCustomer);


     JButton rooms = new JButton("Rooms");
     rooms.setBounds(10,70,200,30);
     rooms.setBackground(Color.BLACK);
     rooms.setForeground(Color.white);
     rooms.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
       try{
        Room room = new Room();
        room.setVisible(true);
        setVisible(false);
       }catch(Exception e1){
        e1.printStackTrace();
       }
      }
     });
     add(rooms);

     JButton Department1 = new JButton("Department");
     Department1.setBounds(10,110,200,30);
     Department1.setBackground(Color.BLACK);
     Department1.setForeground(Color.white);
     Department1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
       try{
        Department dept = new Department();
        dept.setVisible(true);
        setVisible(false);
       }catch(Exception e1){
        e1.printStackTrace();
       }
      }
     });
     add(Department1);

     JButton allEmployee = new JButton("Employee");
     allEmployee.setBounds(10,150,200,30);
     allEmployee.setBackground(Color.BLACK);
     allEmployee.setForeground(Color.white);
     allEmployee.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
       try{
        employeeInfo emp = new employeeInfo();
        emp.setVisible(true);
        setVisible(false);
       }catch(Exception e1){
        e1.printStackTrace();
       }
      }
     });
     add(allEmployee);

     JButton customerInfo1 = new JButton("Customer Info");
     customerInfo1.setBounds(10,190,200,30);
     customerInfo1.setBackground(Color.BLACK);
     customerInfo1.setForeground(Color.white);
     customerInfo1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
       try{
        customerInfo cust = new customerInfo();
        cust.setVisible(true);
        setVisible(false);
       }catch(Exception e1){
        e1.printStackTrace();
       }
      }
     });
     add(customerInfo1);

     JButton managerInfo1 = new JButton("Manager Info");
     managerInfo1.setBounds(10,230,200,30);
     managerInfo1.setBackground(Color.BLACK);
     managerInfo1.setForeground(Color.white);
     managerInfo1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
       try{
        managerInfo manager = new managerInfo();
        manager.setVisible(true);
        setVisible(false);
       }catch(Exception e1){
        e1.printStackTrace();
       }
      }
     });
     add(managerInfo1);

     JButton checkout = new JButton("Checkout");
     checkout.setBounds(10,270,200,30);
     checkout.setBackground(Color.BLACK);
     checkout.setForeground(Color.white);
     checkout.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
       try{
        checkOut co = new checkOut();
        co.setVisible(true);
        setVisible(false);
       }catch(Exception e1){
        e1.printStackTrace();
       }
      }
     });
     add(checkout);

     JButton updateStatus = new JButton("update status");
     updateStatus.setBounds(10,310,200,30);
     updateStatus.setBackground(Color.BLACK);
     updateStatus.setForeground(Color.white);
     updateStatus.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
       try{
        UpdateCheck uc = new UpdateCheck();
        uc.setVisible(true);
        setVisible(false);
       }catch(Exception e1){
        e1.printStackTrace();
       }
      }
     });
     add(updateStatus);

     JButton roomStatus = new JButton("Update Room Status");
     roomStatus.setBounds(10,350,200,30);
     roomStatus.setBackground(Color.BLACK);
     roomStatus.setForeground(Color.white);
     roomStatus.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
       try{
        UpdateRoom UR = new UpdateRoom();
        UR.setVisible(true);
        setVisible(false);
       }catch(Exception e1){
        e1.printStackTrace();
       }
      }
     });
     add(roomStatus);

     JButton pickupService = new JButton("Pickup Service");
     pickupService.setBounds(10,390,200,30);
     pickupService.setBackground(Color.BLACK);
     pickupService.setForeground(Color.white);
     pickupService.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
       try{
        PickUp pu = new PickUp();
        pu.setVisible(true);
        setVisible(false);
       }catch(Exception e1){
        e1.printStackTrace();
       }
      }
     });
     add(pickupService);

     JButton searchRooms1 = new JButton("Search Rooms");
     searchRooms1.setBounds(10,430,200,30);
     searchRooms1.setBackground(Color.BLACK);
     searchRooms1.setForeground(Color.white);
     searchRooms1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
       try{
        searchRoom sr = new searchRoom();
        sr.setVisible(true);
        setVisible(false);
       }catch(Exception e1){
        e1.printStackTrace();
       }
      }
     });
     add(searchRooms1);

     JButton logout = new JButton("Logout");
     logout.setBounds(10,470,200,30);
     logout.setBackground(Color.BLACK);
     logout.setForeground(Color.white);
     logout.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
       try {
        new HotelManagementSystem().setVisible(true);
        new DashBoard().setVisible(false);
        setVisible(false);
       } catch (Exception e) {
        e.printStackTrace();
       }
      }
     });
     add(logout);

     ImageIcon img = new ImageIcon("C:/Users/ADMIN/IdeaProjects/Hotelms/src/com/icons/fourth.jpg");
     JLabel image = new JLabel(img);
     image.setBounds(250,30,500,470);//image boundary
     add(image);

     setLayout(null);
        getContentPane().setBackground(Color.gray);
        setBounds(250,150,850,570);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Reception();
    }
}
