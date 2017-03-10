 
package Runtime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

 
public class CMD {
public static void WriteCMD_noReply(String CMDcommand,int TimeWaiteSeconds){
  Runtime runtime=Runtime.getRuntime();
  
  try{        

   Thread.sleep((TimeWaiteSeconds*1000));    
  Process proc=runtime.exec(CMDcommand);
  }catch(Exception e){e.printStackTrace();}
      
  }
public static void WriteCMD_noReply(String CMDcommand ){
  Runtime runtime=Runtime.getRuntime();
  
  try{        
   
  Process proc=runtime.exec(CMDcommand);
  }catch(Exception e){e.printStackTrace();}
      
  }
public static void WriteCMD_noReply(String CMDcommand,int TimeWaiteSeconds,String Msg){
  Runtime runtime=Runtime.getRuntime();
  
  try{        

   Thread.sleep((TimeWaiteSeconds*1000));    
      JOptionPane.showMessageDialog(null, Msg, "Alert", JOptionPane.INFORMATION_MESSAGE);
  Process proc=runtime.exec(CMDcommand);
  }catch(Exception e){e.printStackTrace();}
      
  }
public static String Write_CMD(String CMDcommand){
       Runtime rt;
       Process proc = null ;
       String s = "",k="";
    try {
     rt = Runtime.getRuntime();
        String  commands = "ping 192.168.1.1";
        proc= rt.exec(commands);
        
        BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
        
        
        
// read the output from the command
//System.out.println("Here is the standard output of the command:\n");

while ((s = stdInput.readLine()) != null) {
      k=k+s+"\n";
}
return k;

// read any errors from the attempted command
//System.out.println("Here is the standard error of the command (if any):\n");


    } catch (IOException ex) {
           try {
               BufferedReader stdError = new BufferedReader(new InputStreamReader(proc.getErrorStream()));
               while ((s = stdError.readLine()) != null) {
                   k=k+s+"\n";
               }
               return k;
           } catch (IOException ex1) {
               return "Error";
           }
    }
    
   
    
    }
}
