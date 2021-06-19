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
public class issuecontroller {
    int bookid;
    String bookname;
    String edition;
    String publisher;
    String price;
    int roll;
    String name;
    String fname;
    String course;
    String branch;
    String semester;
     Connection con;
        ResultSet rs;
        PreparedStatement pst;
        
        issuecontroller()
        {
            con=dbconnectivity.connect();
            
        }
                
                
                
        boolean addissue(int a,String b,String c,String d,String e,int f,String g,String h,String i,String j,String k,Date l){
            String sql="insert into issue(bookid,bookname,Edition,publisher,Price,studentid,studentname,fathername,course,branch,semester,dateofissue)values(?,?,?,?,?,?,?,?,?,?,?,?)";        
            try {
                pst=con.prepareStatement(sql);
                pst.setInt(1, a);
                pst.setString(2, b);
                pst.setString(3, c);
                pst.setString(4, d);
                pst.setString(5, e);
                pst.setInt(6, f);
                 pst.setString(7, g);
                  pst.setString(8, h);
                   pst.setString(9, i);
                    pst.setString(10, j);
                     pst.setString(11, k);
                      java.sql.Date sdate=new java.sql.Date(l.getTime());
                        
                     pst.setDate(12, sdate);
                      
                      pst.execute();
                     return true;
            } catch (Exception m) {
            }
            
            System.out.println("m");
            return false;
                }
        
       
    public String [] searchbookandfill(String id,String []result)
    {
        result=new String[4];
         String sql="Select * from books where bookid=?";
        
         try {
             pst=con.prepareStatement(sql);
            pst.setString(1, id);
            rs=pst.executeQuery();
            if(rs.next())
            {
                String add1=rs.getString("bookname");
                result[0]=add1;
               // System.out.println(result[0]);
                String add2=rs.getString("Edition");
               result[1]=add2;
           //  System.out.println(result[1]);
                String add3=rs.getString("publisher");
                result[2]=add3;
            //   System.out.println(result[2]);
                String add4=rs.getString("Price");
                result[3]=add4;   
               
                return result;
            }
            else
            {
            JOptionPane.showMessageDialog(null, "Book ID not Found.");
            }
            
        } catch (Exception e) {
             System.out.println("e");
             
        }
        
        
        
        return result;
    }
    
    public String [] searchstudentandfill(String id,String []result)
    {
        
        result=new String[5];
        String sql="Select * from student where studentid=?";
        try {
            pst=con.prepareStatement(sql);
            pst.setString(1,id);
            rs=pst.executeQuery();
            if(rs.next())
            {
                String add1=rs.getString("studentname");
                result[0]=add1;
                String add2=rs.getString("fathername");
                result[1]=add2;
                String add3=rs.getString("course");
                result[2]=add3;
                String add4=rs.getString("branch");
                result[3]=add4;   
                String add5=rs.getString("semester");
                result[4]=add5;
                
                
                
              
                return result;
                
            
            }
            
            
            else
            {
            JOptionPane.showMessageDialog(null, "Student ID not Found.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        return result;
    }
}
