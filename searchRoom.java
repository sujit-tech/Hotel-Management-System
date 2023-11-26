package com.hotelmanagementsystem;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import net.proteanit.sql.DbUtils;
import java.awt.*;
import java.awt.event.*;

public class searchRoom extends JFrame{
    PreparedStatement pst = null;
    ResultSet rs = null;
    private JPanel contentPane;
    private JTextField txt_Type;
    private JTable table;
    Choice c1;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    searchRoom frame = new searchRoom();
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
    public searchRoom() throws SQLException {
        //conn = Javaconnect.getDBConnection();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 150, 700, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblSearchForRoom = new JLabel("Search For Room");
        lblSearchForRoom.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblSearchForRoom.setBounds(250, 11, 186, 31);
        contentPane.add(lblSearchForRoom);

        JLabel lblRoomAvailable = new JLabel("Room Bed Type:");
        lblRoomAvailable.setBounds(50, 73, 96, 14);
        contentPane.add(lblRoomAvailable);

        JLabel lblRoomType = new JLabel("Room Number");
        lblRoomType.setBounds(23, 162, 96, 14);
        contentPane.add(lblRoomType);

        JLabel lblRoomAvailable_1 = new JLabel("Availability");
        lblRoomAvailable_1.setBounds(175, 162, 120, 14);
        contentPane.add(lblRoomAvailable_1);

        JLabel lblPrice_1 = new JLabel("Bed Type");
        lblPrice_1.setBounds(458, 162, 46, 14);
        contentPane.add(lblPrice_1);

        JLabel l1 = new JLabel("Price");
        l1.setBounds(580, 162, 96, 14);
        contentPane.add(l1);

        JCheckBox checkRoom = new JCheckBox("Only display Available");
        checkRoom.setBounds(400, 69, 205, 23);
        checkRoom.setBackground(Color.WHITE);
        contentPane.add(checkRoom);


        c1 = new Choice();
        c1.add("Single Bed without Ac");
        c1.add("Double Bed Without Ac");
        c1.add("Single Bed with Ac");
        c1.add("Double Bed with Ac");
        c1.setBounds(153, 70, 120, 20);
        contentPane.add(c1);

        JButton btnSearch = new JButton("Search");
        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String SQL = "select * from addroom where btype = '"+c1.getSelectedItem()+"'";
                String SQL2 = "select * from addroom where rstatus = 'Available' AND btype = '"+c1.getSelectedItem()+"'";
                try{
                    Conn c = new Conn();
                    rs = c.s.executeQuery(SQL);
                    table.setModel(DbUtils.resultSetToTableModel(rs));

                    if(checkRoom.isSelected())
                    {
                        rs = c.s.executeQuery(SQL2);
                        table.setModel(DbUtils.resultSetToTableModel(rs));
                    }


                }catch (SQLException ss)
                {
                    ss.printStackTrace();
                }

            }
        });
        btnSearch.setBounds(200, 400, 120, 30);
        btnSearch.setBackground(Color.BLACK);
        btnSearch.setForeground(Color.WHITE);
        contentPane.add(btnSearch);

        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Reception().setVisible(true);
                setVisible(false);
            }
        });
        btnExit.setBounds(380, 400, 120, 30);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        contentPane.add(btnExit);

        table = new JTable();
        table.setBounds(0, 180, 700, 300);
        contentPane.add(table);

        JLabel lblCleanStatus = new JLabel("Clean Status");
        lblCleanStatus.setBounds(306, 162, 96, 14);
        contentPane.add(lblCleanStatus);

        getContentPane().setBackground(Color.GRAY);
    }
}
