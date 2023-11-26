package com.hotelmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.Callable;

public class AddRooms extends JFrame implements ActionListener {
    JTextField Troomno,TPrice;
    JComboBox optioncb,optionclcb,optionclty;
    JButton save,cancel;
    AddRooms(){
        JLabel heading=new JLabel("Add Rooms");
        heading.setFont(new Font("ALGERIAN",Font.ITALIC,20));
        heading.setBounds(150,20,200,20);
        add(heading);

        JLabel roomno=new JLabel("Rooms No");
        roomno.setFont(new Font("ALGERIAN",Font.ITALIC,17));
        roomno.setBounds(50,80,120,20);
        add(roomno);
         Troomno=new JTextField();
        Troomno.setBounds(200,78,150,20);
        add(Troomno);

        JLabel roomStat=new JLabel("Rooms Status");
        roomStat.setFont(new Font("ALGERIAN",Font.ITALIC,17));
        roomStat.setBounds(50,140,120,20);
        add(roomStat);
        String option[]={"Available","Occupied","Out of Order"};
         optioncb=new JComboBox(option);
        optioncb.setBounds(200,138,150,30);
        optioncb.setBackground(Color.getColor("#808080"));
        add(optioncb);

        JLabel CleanStat=new JLabel("Clean Status");
        CleanStat.setFont(new Font("ALGERIAN",Font.ITALIC,17));
        CleanStat.setBounds(50,190,120,20);
        add(CleanStat);
        String optioncl[]={"Clean","Dirty"};
         optionclcb=new JComboBox(optioncl);
        optionclcb.setBounds(200,188,150,30);
        optionclcb.setBackground(Color.getColor("#808080"));
        add(optionclcb);

        JLabel Roomtype=new JLabel("Room Type");
        Roomtype.setFont(new Font("ALGERIAN",Font.ITALIC,17));
        Roomtype.setBounds(50,240,120,20);
        add(Roomtype);
        String optionty[]={"Single Bed without Ac","Double Bed Without Ac","Single Bed with Ac","Double Bed with Ac"};
         optionclty=new JComboBox(optionty);
        optionclty.setBounds(200,238,180,30);
        optionclty.setBackground(Color.getColor("#808080"));
        add(optionclty);

        JLabel price=new JLabel("Price");
        price.setFont(new Font("ALGERIAN",Font.ITALIC,17));
        price.setBounds(50,280,120,20);
        add(price);
         TPrice=new JTextField();
        TPrice.setBounds(200,278,150,20);
        add(TPrice);

         save = new JButton("SAVE");
        save.setBackground(Color.BLACK);
        save.setForeground(Color.gray);
        save.setBounds(50,330,120,30);
        save.addActionListener(this);
        add(save);
         cancel = new JButton("CANCEL");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.gray);
        cancel.setBounds(200,330,120,30);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon img = new ImageIcon("C:/Users/ADMIN/IdeaProjects/Hotelms/src/com/icons/giphy-1917699386.gif");
        JLabel image = new JLabel(img);
        image.setBounds(400,70,300,250);//image boundary
        add(image);

        setLayout(null);
        getContentPane().setBackground(Color.gray);
        setBounds(250,150,850,540);
        setVisible(true);
    }
    public  void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==save){
            String roomno = Troomno.getText();
            String rstatus = (String) optioncb.getSelectedItem();
            String cstatus = (String) optionclcb.getSelectedItem();
            String bType = (String) optionclty.getSelectedItem();
            String price = TPrice.getText();

            try{
                Conn c = new Conn();
                String str  = "insert into addroom values('"+roomno+"','"+rstatus+"','"+cstatus+"','"+bType+"','"+price+"');";
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"Data Saved successfully");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }

        public static void main(String[] args) {
        new AddRooms();
    }
}
