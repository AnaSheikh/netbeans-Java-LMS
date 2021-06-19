/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testdb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author anasheikh
 */
public class accountcontroller {
    String aname,username,password;
     Connection con;
        ResultSet rs;
        PreparedStatement pst;
    
    accountcontroller()
    {
        con=dbconnectivity.connect();
    }
    
    boolean checkaccount(String a,String b)
    {
         String sql="select * from accounts where username=? and apassword=?";
        try {
            pst=con.prepareStatement(sql);
            pst.setString(1, a);
            pst.setString(2,b);
            rs=pst.executeQuery();
            if (rs.next()) 
            {
                rs.close();
                pst.close();
                return true;
               
                
                
                
                
            } else {
                JOptionPane.showMessageDialog(null, "Incorrect Username Or Password.");
                
            }
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
        return false;
    }
    
    boolean addnewaccount(String a,String b,String c)
    {
         try {
            String sql="Insert into Accounts(aname,username,apassword) values(?,?,?)";
            pst=con.prepareStatement(sql);
            pst.setString(1, a);
            pst.setString(2,b);
            pst.setString(3, c);
            pst.execute();
              JOptionPane.showMessageDialog(null, "New Account is Created.");
          return true;
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
         return false;
    }
    
    
}
