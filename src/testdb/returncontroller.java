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
import java.util.*;



/**
 *
 * @author anasheikh
 */
public class returncontroller {
    Connection con;
        ResultSet rs;
        PreparedStatement pst;
        java.util.Date itest=new java.util.Date();
        
        returncontroller()
        {
            con=dbconnectivity.connect();
        }
        
        
        public String [] searchforreturn(String a,String b,String r[],Date temp )
        {
        String sql="Select * from issue where studentid=? AND bookid=?";
        r=new String[10];
        try {
             pst=con.prepareStatement(sql);
             pst.setString(1,a);
             pst.setString(2,b);
             rs=pst.executeQuery();
             if(rs.next())
             {
                 String add1=rs.getString("studentname");
                 r[0]=add1;
                 String add2=rs.getString("fathername");
                 r[1]=add2;
                 String add3=rs.getString("course");
                 r[2]=add3;
                 String add4=rs.getString("branch");
                 r[3]=add4;
                 String add5=rs.getString("semester");
                 r[4]=add5;
//                 String add6=rs.getString("bookid");
//                 jTextField7.setText(add6);
                 String add7=rs.getString("bookname");
                 r[5]=add7;
                 String add8=rs.getString("Edition");
                 r[6]=add8;
                 String add9=rs.getString("publisher");
                r[7]=add9;
                 String add10=rs.getString("Price");
                 r[8]=add10;
                 java.sql.Date issuedate=rs.getDate("dateofissue");
                 java.util.Date utilDate = new java.util.Date(issuedate.getTime());
                 temp=utilDate;
                 itest=utilDate;
                 System.out.println(issuedate);
                 System.out.println(utilDate);
                 
                return r;
             }
             else
             {
                 JOptionPane.showMessageDialog(null, "Book is not Issued With this ID.");
             
             }
             
             
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        return r;
        }
        
        void insertreturn(int a,String b,String c,String d,String e,String f,int g,String h,String i,String j,String k,Date l,Date m)
        {
            
             String sql="Insert into returned(studentid,studentname,fathername,course,branch,semester,bookid,bookname,Edition,publisher,Price,dateofissue,returndate) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            pst=con.prepareStatement(sql);
            pst.setInt(1, a);
            pst.setString(2, b);
            pst.setString(3, c);
            pst.setString(4, d);
            pst.setString(5, e);
            pst.setString(6, f);
            pst.setInt(7, g);
            pst.setString(8, h);
            pst.setString(9, i);
            pst.setString(10, j);
            pst.setString(11, k);
            java.sql.Date newdate=new java.sql.Date(l.getTime());
            pst.setDate(12, newdate);
            
            java.sql.Date sdate=new java.sql.Date(m.getTime());
            pst.setDate(13, sdate);

            pst.execute();
            JOptionPane.showMessageDialog(null, "Book is returned and record is Updated.");
            rs.close();
            pst.close();
        } catch (Exception z) {
            JOptionPane.showMessageDialog(null, z);
        }
    
        }
        public void delete(String a,String b)
        {
            
             String sql="delete from issue where studentid=? AND bookid=?";
        try {
            pst=con.prepareStatement(sql);
            pst.setString(1,a);
            pst.setString(2,b);
            pst.execute();
            
        } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
        }
        }
}

    

