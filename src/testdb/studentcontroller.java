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
public class studentcontroller {
    
    int roll;
    String name;
    String fname;
    String course;
    String branch;
    String semester;
    
      Connection con;
        ResultSet rs;
        PreparedStatement pst;
        
        studentcontroller()
        {
            con=dbconnectivity.connect();
        }
        boolean addstudent(int a,String b,String c,String d,String e,String f)
        {
            String sql="Insert into Student (studentid,studentname,fathername,course,branch,semester) values (?,?,?,?,?,?)";
            try {
                pst=con.prepareStatement(sql);
                pst.setInt(1, a);
                pst.setString(2, b);
                pst.setString(3, c);
                pst.setString(4, d);
                pst.setString(5, e);
                pst.setString(6, f);
                
               pst.execute();
               return true;
            } catch (Exception g) {
                System.out.println(g);
                return false;
            }
        }
    
    
}
