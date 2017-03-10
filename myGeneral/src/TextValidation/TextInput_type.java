

package TextValidation;

import java.awt.Component;
  import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
 import javax.swing.JTextField;
import static mystring.mystring.*;
 
/**
 *
 * @author David Sherif
 */
public class TextInput_type {
  
 static int ch1;
 
 
    /**
     *
     * @param evt
     * @param MsgLabel
     * @param JtextField
     * <br>
     * <u>User by Force Entered Numbers Only</u>
     */
    public static void NumbersOnlny(KeyEvent evt,JLabel MsgLabel ,JTextField JtextField)
    {
      
     ch1=evt.getKeyChar();
        if(ch1>=48&&ch1<=57)
      MsgLabel.setVisible(false);  
        else{
            MsgLabel.setVisible(true);
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            return;
        }
     

}//func

    
    
    public static void NumbersOnlny(KeyEvent evt ,Component c)
    {
      
     ch1=evt.getKeyChar();
        if(!(ch1>=48&&ch1<=57))  
      {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            return;
      }
     

}//func
    
    
    
     
    
    
            
    /**
     *
     * @param evt
     * @param MsgLabel
     * @param JtextField
     * <br>
     * <u>User by Force Entered English Capital Letters Only</u>
     */
    public static void English_Capital_Onlny(KeyEvent evt ,JLabel  MsgLabel,JTextField JtextField)
    {
       ch1=evt.getKeyChar();
    
        if(ch1>=65&&ch1<=90)
        MsgLabel.setVisible(false);  
        else{
            MsgLabel.setVisible(true);
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            return;
        }    
     

    
}
    
    
    /**
     *
     * @param evt
     * @param MsgLabel
     * @param JtextField
     * <br>
     * <u>User by Force Entered English Small Letter Only</u>
     */
    public static void English_Small_Onlny(KeyEvent evt, JLabel MsgLabel,JTextField JtextField)
    {
     ch1=evt.getKeyChar();
    
        if(ch1>=97&&ch1<=122)
        MsgLabel.setVisible(false);  
        else{
            MsgLabel.setVisible(true);
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            return;
        }    
     
}

    
    /**
     *
     * @param evt
     * @param MsgLabel
     * @param JtextField
     * <br>
     * <u>User by Force Entered Arabic Letters Only</u>
     */
    public static void Arabic_Onlny(KeyEvent evt, JLabel MsgLabel,JTextField JtextField)
    {

     ch1=evt.getKeyChar();
    
        if(ch1>=1570&&ch1<=1610)
       MsgLabel.setVisible(false);  
        else{
            MsgLabel.setVisible(true);
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            return;
        }    
    
}

    
    public static void English_Arabic_Onlny(KeyEvent evt, JLabel MsgLabel,JTextField JtextField)
    {
     ch1=evt.getKeyChar();
    
        if(ch1>=97&&ch1<=122||ch1>=1570&&ch1<=1610||ch1==8||ch1==32)
        MsgLabel.setVisible(false);  
        else{
            MsgLabel.setVisible(true);
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            return;
        }    
     
}
    
    
    
    /**
     *
     * @param JtextField
     * <br>
     * <b>Convert Automatic to Case you Selected</b>
     */
    public static void to_lowerCase(JTextField JtextField)
    {
     JtextField.setText(JtextField.getText().toLowerCase()); 
     }
     
    
    /**
     *
     * @param JtextField
     * <br>
     * <b>Convert Automatic to Case you Selected</b>
     */
    public static void to_UpperCase(JTextField JtextField)
    {
     JtextField.setText(JtextField.getText().toUpperCase()); 
     }
     
    
    /**
     *
     * @param JtextField
     * <br>
     * <b>Convert Automatic to Case you Selected</b>
     */
    public static void to_InitCape(JTextField JtextField)
    {if (JtextField.getText().length()<=0) {
         return;
        }
    else JtextField.setText(InitCap(JtextField.getText())); 
     }

 
     public static void maxlenght(java.awt.event.KeyEvent evt ,JTextField TextField)
     {
             if (TextField.getText().length()>20) {
                evt.consume();
             }
         
     }

}
