/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testdb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author anasheikh
 */
public class newbookcontroller {
    int id;
    String name;
    String edition;
    String publisher;
    int price;
    Connection con;
        ResultSet rs;
        PreparedStatement pst;
    
    newbookcontroller()
    {
     con=dbconnectivity.connect();
       
    }
    
    boolean addbook(int a,String b,String c,String d,int e)
    {
        
        String sql="Insert into books(bookid,bookname,Edition,publisher,Price) values(?,?,?,?,?)";
        try {
            pst=con.prepareStatement(sql);
             pst.setInt(1, a);
            pst.setString(2,b);
            pst.setString(3, c);
            pst.setString(4, d);
            pst.setInt(5, e);
            pst.execute();
            return true;
            
           
        } catch (Exception f) {
            System.out.println("e");
            
        }
        return false;
    }
    void displayall()
    {
        String sql="select * from books";
        try {
            pst=con.prepareStatement(sql);
            
        } catch (Exception e) {
            System.out.println("e");
        }
    }
    
}
