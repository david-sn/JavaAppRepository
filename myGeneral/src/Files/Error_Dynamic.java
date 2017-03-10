
package Files;

import BasicForms.RemotlyConnection;
import DatabaseConnection.OracleConn;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.SQLException;
import java.util.Date;
import static DatabaseConnection.OracleConn.sql;
import javax.swing.JOptionPane;

public class Error_Dynamic {


    public static void getERRORS(String ClassName,String InternalSQL,SQLException e)
    {
        
        
        StringBuilder str=new StringBuilder();
                
    try{
    		
    		File file =new File("ErrorAlert.txt");
    		
    		//if file doesnt exists, then create it
    		if(!file.exists())
    			file.createNewFile();
    		
    		
    		//true = append file
    		FileWriter fileWritter = new FileWriter(file.getName(),true);
    	        BufferedWriter bufferWritter = new BufferedWriter(fileWritter);


                str.append("\t\tSQL Errors\n");
                str.append("\nTime Occurs= ").append(new Date(System.currentTimeMillis()));
                str.append("\nClass name= ").append(ClassName);
                str.append("\nError Code= ").append(e.getErrorCode());
                str.append("\nError Message= ").append(e.getMessage());
                str.append("\nLocal Message= ").append(e.getLocalizedMessage()).append("\n");
                str.append("\nError SQL State= ").append(e.getSQLState());
                str.append("\nGlobal SQL= ").append(sql).append("\n");
                str.append("\nInternal Method SQL= ").append(InternalSQL).append("\n");
                str.append("\nError print Stack= ").append(e);
                bufferWritter.write(str+"\n----*************------*************-----\n");
                bufferWritter.newLine();
                        
                
               /*bufferWritter.newLine();
                bufferWritter.write("Time Occurs= "+new Date(System.currentTimeMillis())+" \t\t SQL Errors\n");
                bufferWritter.write("Class name= "+ClassName+"\n");
                bufferWritter.write("Error Code= "+e.getErrorCode()+"\n");
                bufferWritter.write("Error Message= "+e.getMessage()+"\n");
                bufferWritter.write("Error SQL State= "+e.getSQLState()+"\n");
                bufferWritter.write("Error print Stack= "+e+"\n");
                bufferWritter.write("SQL="+sql);
                bufferWritter.write("----------------------------------------------------------");
                bufferWritter.newLine();
*/
                bufferWritter.close();

                
                CorrectError(e);
                
                
    	}catch(Exception ee){
    		ee.printStackTrace();
    	}

    
    
    }
    
    
   static void CorrectError(SQLException ex)
   {
       RemotlyConnection r=new RemotlyConnection();
       if (ex.getErrorCode()==17002||ex.getErrorCode()==12505) {
           if (!r.isVisible()) {
               r.setVisible(true);
           }
       }
       
      if (ex.getErrorCode()==1 ) {
           OracleConn.PLSQL_Declare("declare seqname varchar2(40); CURSOR seq IS select SEQUENCE_NAME from USER_SEQUENCES; BEGIN OPEN seq; LOOP FETCH seq INTO seqname; EXECUTE IMMEDIATE ('declare res number ; begin SELECT '||seqname||'.nextval into res  from dual; end;'); EXIT WHEN seq%NOTFOUND; END LOOP;end;");
       }
      
      if (ex.getErrorCode()==1000 ) {
          //DatabaseConnection.OracleConn.openConn("center2","center2","XE");
          //OracleConn.openConn("CENTER","CENTER","XE");
          
          OracleConn.Restart_Connection();
          OracleConn.PLSQL_Declare("BEGIN for n in (select SID ,SERIAL# from v$session where USERNAME in('CENTER','CENTER2') )loop begin  execute immediate ('alter system kill session '''||n.SID||','||n.SERIAL#||''' immediate');  Exception when others then null; end; end loop; end;");
          
          //OracleConn.openConn("CENTER","CENTER","XE");
      }
      
      if (ex.getErrorCode()==17008 ) {
          OracleConn.openConn("CENTER","CENTER","XE");
      }
      
     
       if (ex.getErrorCode()==20002 ) {
           JOptionPane.showMessageDialog(null, "Group is Closed\nRoom Capacity is Full","Validation-Capacity",JOptionPane.ERROR_MESSAGE);
      }
      
       if (ex.getErrorCode()==20105 ) {
           JOptionPane.showMessageDialog(null, "Another Lecture Segment on Same Time","Validation-Overlap",JOptionPane.ERROR_MESSAGE);
      }
       if (ex.getErrorCode()==17008 ) {
           
      }
       if (ex.getErrorCode()==17008 ) {
           
      }
       if (ex.getErrorCode()==17008 ) {
           
      }
      
      
      
   }
    
    
    
    public static void getERRORS(String ClassName,Exception e)
    {
    StringBuilder str=new StringBuilder();
                try{
    		
    		File file =new File("ErrorAlert.txt");
    		
    		//if file doesnt exists, then create it
    		if(!file.exists())
    			file.createNewFile();
    		
    		
    		//true = append file
    		FileWriter fileWritter = new FileWriter(file.getName(),true);
    	        BufferedWriter bufferWritter = new BufferedWriter(fileWritter);


                str.append("\t\t>->->* General Error *<-<-<");
                str.append("Time Occurs= ").append(new Date(System.currentTimeMillis()));
                str.append("\nClass name= ").append(ClassName);
                str.append("\nError Message= ").append(e.getMessage());
                str.append("\nError print Stack= ").append(e);
                bufferWritter.write(str+"\n----*************------*************-----\n");

                bufferWritter.close();
    	    
	     
    	}catch(Exception ee){
    		ee.printStackTrace();
    	}

    
    }

}
