 
package CheckComponent;
 
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import static OptionPane.Messages.*;
public   class Text_Null {
    
     
    
    public static void Text_Is_Null( String[] MessageCusom,char CHAR ,JTextField...j1 )
    {int counter=-1;
       for(JTextField j2:j1)
        {   counter++;  
            for(int i=counter;i<MessageCusom.length;i++)
             if(j2.getText().equals("")||j2.getText().equals(null)||j2.getText().equals(" ")||j2.getText().equals("  ")||j2.getText().equals("   ")||j2.getText().startsWith(" ")||j2.getText().contains(""+CHAR)||j2.getText().contains(".."))
                 { 
                     if(MessageCusom[i].equals("")||MessageCusom[i].equals(null))
                     {
                     MsgShow( "Please Re-Check Text You Entered in Fields","Attention",'w',null);
                     System.err.println("hh"); 
                     break;
                     }
                     else{
                      MsgShow (MessageCusom[i],"Attention",'w',null);
                     System.err.println("i "+i);
                     break;
                     }
                         
                 }  
            
            
        }
    }
    
    
}
