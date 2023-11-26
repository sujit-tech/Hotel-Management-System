package com.hotelmanagementsystem;

import net.proteanit.sql.DbUtils;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class managerInfo extends JFrame{
    private JPanel contentPane;
    private JTable table;
    private JLabel lblNewLabel;
    private JLabel lblJob;
    private JLabel lblName;
    private JLabel lblDepartment;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    managerInfo frame = new managerInfo();
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
    public managerInfo() throws SQLException {
        //conn = Javaconnect.getDBConnection();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 150, 1000, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        table = new JTable();
        table.setBounds(0, 34, 1000, 450);
        contentPane.add(table);

        JButton btnLoadData = new JButton("Load Data");
        btnLoadData.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    Conn c = new Conn();
                    String displayCustomersql = "select * from employee where job='Manager'";
                    ResultSet rs = c.s.executeQuery(displayCustomersql);
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                }
                catch(Exception e1){
                    e1.printStackTrace();
                }
            }

        });
        btnLoadData.setBounds(350, 500, 120, 30);
        btnLoadData.setBackground(Color.BLACK);
        btnLoadData.setForeground(Color.WHITE);
        contentPane.add(btnLoadData);

        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Reception().setVisible(true);
                setVisible(false);
            }
        });
        btnExit.setBounds(510, 500, 120, 30);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        contentPane.add(btnExit);

        lblNewLabel = new JLabel("Name");
        lblNewLabel.setBounds(41, 11, 46, 14);
        contentPane.add(lblNewLabel);

        lblJob = new JLabel("Age");
        lblJob.setBounds(159, 11, 46, 14);
        contentPane.add(lblJob);

        lblName = new JLabel("Gender");
        lblName.setBounds(273, 11, 46, 14);
        contentPane.add(lblName);

        lblDepartment = new JLabel("Job");
        lblDepartment.setBounds(416, 11, 86, 14);
        contentPane.add(lblDepartment);

        JLabel l1 = new JLabel("Salary");
        l1.setBounds(536, 11, 86, 14);
        contentPane.add(l1);

        JLabel l2 = new JLabel("Phone");
        l2.setBounds(656, 11, 86, 14);
        contentPane.add(l2);

        JLabel l3 = new JLabel("Gmail");
        l3.setBounds(786, 11, 86, 14);
        contentPane.add(l3);

        JLabel l4 = new JLabel("Adhaar");
        l4.setBounds(896, 11, 86, 14);
        contentPane.add(l4);

        getContentPane().setBackground(Color.GRAY);
    }
}
