 
package mystring;

import javax.swing.JComponent;
import javax.swing.TransferHandler;


public    class    mystring  {
    
   
     static  public String InitCap(String s)
    {      
        return (s.toUpperCase().charAt(0)  +   (s.toLowerCase().substring(1, s.length())));          
    }
     
     
     
public static void DragDropText(java.awt.event.MouseEvent evt,JComponent TextBoxOrTable){
 
     JComponent   jc =(JComponent)evt.getSource();
        TransferHandler th=jc.getTransferHandler();
        th.exportAsDrag(jc, evt, TransferHandler.COPY);
    TextBoxOrTable.setTransferHandler(new TransferHandler("text"));
  
    }
 

public static void print(Object statement){
         System.err.println(statement);
     }

public static String substring_LastIndexOf(String string,char ch){
string=string.substring(0, string.lastIndexOf(ch));
    return string;
}
   


}

