package com.hotelmanagementsystem;
import java.awt.font.TextAttribute;
import java.sql.*;
import javax.swing.*;
import java.lang.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.text.AttributedString;
import java.util.Map;

public class checkOut extends JFrame{
    PreparedStatement pst = null;
    private JPanel contentPane;
    private JTextField t1,t2;
    Choice c1;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    checkOut frame = new checkOut();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public void close(){
        this.dispose();
    }

    /**
     * Create the frame.
     * @throws SQLException
     */
    public checkOut() throws SQLException {
        //conn = Javaconnect.getDBConnection();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(250, 150, 800, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon i1  = new ImageIcon("C:/Users/ADMIN/IdeaProjects/Hotelms/src/com/icons/sixth.jpg");
        Image i3 = i1.getImage().getScaledInstance(400, 225,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(300,0,500,225);
        add(l1);

        JLabel lblCheckOut = new JLabel("Check Out ");
        lblCheckOut.setFont(new Font("Tahoma", Font.BOLD,27));
        Font font =lblCheckOut.getFont();
        Map a=font.getAttributes();
        a.put(TextAttribute.UNDERLINE,TextAttribute.UNDERLINE_ON);
        lblCheckOut.setFont(font.deriveFont(a));
        lblCheckOut.setBounds(70, 11, 180, 40);
        contentPane.add(lblCheckOut);

        JLabel lblName = new JLabel("Number :");
        lblName.setBounds(20, 85, 80, 14);
        contentPane.add(lblName);

        JLabel lblNewLabel_3 = new JLabel("Checked-in :");
        lblNewLabel_3.setBounds(20, 200, 107, 14);
        contentPane.add(lblNewLabel_3);

        c1 = new Choice();
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while(rs.next()){
                c1.add(rs.getString("number"));
            }
        }catch(Exception e){ }
        c1.setBounds(130, 82, 150, 20);
        contentPane.add(c1);

        ImageIcon i4 = new ImageIcon("C:/Users/ADMIN/IdeaProjects/Hotelms/src/com/icons/tick.png");
        Image i5 = i4.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JButton l2 = new JButton(i6);
        l2.setBounds(290,82,20,20);
        add(l2);

        l2.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent ae){
                System.out.println("Hi");
                try{

                    Conn c = new Conn();
                    String number = c1.getSelectedItem();
                    ResultSet rs = c.s.executeQuery("select * from customer where number = "+number);

                    if(rs.next()){
                        System.out.println("clicked");
                        t1.setText(rs.getString("room"));
                        t2.setText(rs.getString("checkintime"));
                    }
                }catch(Exception e){ }
            }
        });


        JLabel lblRoomNumber = new JLabel("Room No:");
        lblRoomNumber.setBounds(20, 132, 86, 20);
        contentPane.add(lblRoomNumber);

        t1 = new JTextField();
        t1.setBounds(130, 132, 150, 20);
        contentPane.add(t1);

        t2 = new JTextField();
        t2.setBounds(130, 200, 150, 20);
        contentPane.add(t2);

        JButton btnCheckOut = new JButton("Check Out");
        btnCheckOut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id = c1.getSelectedItem();
                String s1 = t1.getText();
                String deleteSQL = "Delete from customer where number = "+id;
                String q2 = "update addroom set rstatus = 'Available' where roomno = "+s1;


                Conn c = new Conn();

                try{
                    c.s.executeUpdate(deleteSQL);
                    c.s.executeUpdate(q2);
                    JOptionPane.showMessageDialog(null, "Check Out Successful");
                    new Reception().setVisible(true);
                    setVisible(false);
                }catch(SQLException e1){
                    System.out.println(e1.getMessage());
                }
            }
        });
        btnCheckOut.setBounds(50, 250, 100, 25);
        btnCheckOut.setBackground(Color.BLACK);
        btnCheckOut.setForeground(Color.WHITE);
        contentPane.add(btnCheckOut);

        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Reception().setVisible(true);
                setVisible(false);
            }
        });
        btnExit.setBounds(160, 250, 100, 25);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        contentPane.add(btnExit);


        getContentPane().setBackground(Color.GRAY);
    }
}
