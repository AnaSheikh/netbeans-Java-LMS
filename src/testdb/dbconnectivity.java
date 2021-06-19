/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testdb;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author anasheikh
 */
public class dbconnectivity {
     Connection con;
    Statement smt;
    public static Connection connect()
    {
    
         try
        {
               String conn="jdbc:sqlserver://192.168.1.7:1433;databaseName=LMS"; 
               Connection con=DriverManager.getConnection(conn,"sa","yourStrong(!)Password");
               return con;
            }
        catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
                return null;
        
            }
        
        
    }
}
    
