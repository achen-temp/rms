package com.login.loginsys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;

@SpringBootApplication
//@ImportResource("classpath:app-config.xml")
public class LoginsysApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoginsysApplication.class, args);
/*        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/dbo","root","root");
//here sonoo is database name, root is username and password
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from userlogin");
            while(rs.next())
                System.out.println(rs.getInt(1)+"  "+rs.getString(4)+"  "+rs.getString(6));
            con.close();
        }catch(Exception e){ System.out.println(e);}*/
    }

}

