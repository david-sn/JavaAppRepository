/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseConnection;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author David Sherif
 */
public class CSVconnection {
 static   Connection connCSV=null;
  static  Statement stCSV=null; 
  static ResultSet rsCSV=null;
  
    public static void openconn(String DirectoryPath,String FileName ) {
        
        if (DirectoryPath.endsWith(FileName)) 
           DirectoryPath= DirectoryPath.substring(0, (DirectoryPath.length()-FileName.length()));
          
        
        
        try
    {
        
        Class.forName("org.relique.jdbc.csv.CsvDriver");
 
       //connCSV = DriverManager.getConnection("jdbc:relique:csv:A:\\My programs\\general1");
       
              connCSV = DriverManager.getConnection("jdbc:relique:csv:"+DirectoryPath);
       
       stCSV = connCSV.createStatement();
          
        //rsCSV = stCSV.executeQuery("SELECT * FROM dept_PK");
        //while (rsCSV.next()) {
       ///     System.err.println(rsCSV.getObject(1));
       // }
     
    }
    catch(Exception e)
    {       try {
        connCSV.close();
            } catch (SQLException ex) {
                Logger.getLogger(CSVconnection.class.getName()).log(Level.SEVERE, null, ex);
            }
      e.printStackTrace();
    }
        
    }
    
    public static void ExecuteDML_CSV(String sql) {
        
     try {
         File f=new File("A:\\My programs\\general1\\dept_PK.csv");
         FileWriter fr = new FileWriter(f);
          
         
         FileOutputStream is = new FileOutputStream(f);
            OutputStreamWriter osw = new OutputStreamWriter(is);    
            Writer w = new BufferedWriter(osw);
            w.write("POTATO!!!");
       
         
         
     
        
    } catch (FileNotFoundException ex) {
         Logger.getLogger(CSVconnection.class.getName()).log(Level.SEVERE, null, ex);
     } catch (IOException ex) {
         Logger.getLogger(CSVconnection.class.getName()).log(Level.SEVERE, null, ex);
     }
    
    
    
        
    
    
        
    
    
        
    
    
    }
    public static void main(String[] args) {
        openconn("A:\\My programs\\general1\\dept_PK.csv","dept_PK.csv");
   ExecuteDML_CSV("update dept_PK.csv set Dept_id=100");
    }
}
