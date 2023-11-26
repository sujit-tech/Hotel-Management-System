package com.hotelmanagementsystem;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class PickUp extends JFrame {
    PreparedStatement pst = null;
    ResultSet rs = null;
    private JPanel contentPane;
    private JTable table;
    Choice c1;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PickUp frame = new PickUp();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public void close()
    {
        this.dispose();
    }

    /**
     * Create the frame.
     * @throws SQLException
     */
    public PickUp() throws SQLException {
        //conn = Javaconnect.getDBConnection();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(250,150,900,570);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(9, 9, 9, 9));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblPickUpService = new JLabel("Pick Up Service");
        lblPickUpService.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblPickUpService.setBounds(90, 11, 158, 25);
        contentPane.add(lblPickUpService);

        JLabel lblTypeOfCar = new JLabel("Type of Car");
        lblTypeOfCar.setBounds(32, 97, 89, 14);
        contentPane.add(lblTypeOfCar);


        c1 = new Choice();
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from driver");
            while(rs.next()){
                c1.add(rs.getString("cType"));
            }
        }catch(Exception e){ }
        c1.setBounds(123, 94, 150, 25);
        contentPane.add(c1);



        JLabel lblInfo = new JLabel("Name");
        lblInfo.setBounds(24, 208, 46, 14);
        contentPane.add(lblInfo);

        JButton btnRegister = new JButton("Display");
        btnRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String SQL = "select * from driver where cType = '"+c1.getSelectedItem()+"'";
                try{

                    Conn c = new Conn();
                    rs = c.s.executeQuery(SQL);
                    table.setModel(DbUtils.resultSetToTableModel(rs));



                }catch (SQLException ss)
                {
                    ss.printStackTrace();
                }


            }
        });
        btnRegister.setBounds(200, 500, 120, 30);
        btnRegister.setBackground(Color.BLACK);
        btnRegister.setForeground(Color.WHITE);
        contentPane.add(btnRegister);

        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                new Reception().setVisible(true);
                setVisible(false);
            }
        });
        btnExit.setBounds(420, 500, 120, 30);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        contentPane.add(btnExit);

        table = new JTable();
        table.setBounds(0, 233, 900, 250);
        contentPane.add(table);

        JLabel lblNewLabel = new JLabel("Age");
        lblNewLabel.setBounds(165, 208, 46, 14);
        contentPane.add(lblNewLabel);

        JLabel lblGender = new JLabel("Gender");
        lblGender.setBounds(264, 208, 46, 14);
        contentPane.add(lblGender);

        JLabel lblTypeOfDriver = new JLabel("Car type");
        lblTypeOfDriver.setBounds(366, 208, 80, 14);
        contentPane.add(lblTypeOfDriver);

        JLabel lblDateOfThe = new JLabel("driver licence");
        lblDateOfThe.setBounds(486, 208, 105, 14);
        contentPane.add(lblDateOfThe);

        JLabel lblAvailable = new JLabel("Available");
        lblAvailable.setBounds(600, 208, 86, 14);
        contentPane.add(lblAvailable);

        JLabel lbllocation = new JLabel("Location");
        lbllocation.setBounds(700, 208, 73, 14);
        contentPane.add(lbllocation);

        JLabel lblsalary = new JLabel("Salary");
        lblsalary.setBounds(786, 208, 73, 14);
        contentPane.add(lblsalary);



        getContentPane().setBackground(Color.GRAY);
    }
}