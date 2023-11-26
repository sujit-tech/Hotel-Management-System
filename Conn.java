package com.hotelmanagementsystem;
import java.sql.*;
public class Conn {
    Connection c;
    Statement s;//creating the Statements or queries of sql
    Conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//register the driver
            c=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagementsystem","root","root12");//connecting to SQL
            s=c.createStatement();//calling the queries
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}