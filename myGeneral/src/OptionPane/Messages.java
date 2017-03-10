 
package OptionPane;


import java.awt.Component;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

 
public class Messages {
static int x=0;
 
    /**
     * @param content  Content of Message
     * @param Title  Head of Message
     * @param type  type of Message as Char default Plain Message@param
     * @deprecated  Type
     * <p>
     * 'p' > Plain Message<br>
     * 'e' > Error Message<br>
     * 'w' > Warning Message<br>
     * 'i' > Information Message<br>
     * 'q' > Question Message<br>
     * </p>
     * @param PathIcon   Location of Image can be null if NOT needed
     */
    public static void  MsgShow(String content,String Title,char type,String PathIcon){      
 
        if (PathIcon.equals(null)||PathIcon.equals("")||PathIcon.equals(" ")) 
{
        switch(Character.toLowerCase(type)){
          
case'p' : JOptionPane.showMessageDialog(null,content,Title ,JOptionPane.PLAIN_MESSAGE);         break;       
case'e' : JOptionPane.showMessageDialog(null,content,Title ,JOptionPane.ERROR_MESSAGE);         break;        
case'w' : JOptionPane.showMessageDialog(null,content,Title ,JOptionPane.WARNING_MESSAGE);       break; 
case'i' : JOptionPane.showMessageDialog(null,content,Title ,JOptionPane.INFORMATION_MESSAGE);   break; 
case'q' : JOptionPane.showMessageDialog(null,content,Title ,JOptionPane.QUESTION_MESSAGE);      break; 
default : JOptionPane.showMessageDialog(null,content,Title ,JOptionPane.INFORMATION_MESSAGE);   break;    
        }    
}else JOptionPane.showMessageDialog(null,content,Title ,JOptionPane.PLAIN_MESSAGE,new ImageIcon(PathIcon));
 }           
         
    
    /**
     * @param content  Content of Message
     * @param Title  Head of Message
     * @param type  type of Message as Char default Plain Message@param
     * @deprecated  Type
     * <p>
     * 'p' > Plain Message<br>
     * 'e' > Error Message<br>
     * 'w' > Warning Message<br>
     * 'i' > Information Message<br>
     * 'q' > Question Message<br>
     * </p>
     * @param PathIcon   Location of Image can be null if NOT needed
       * <b>if Location found Type will no use</b>
     */
    public static void  Msg_LongTextScroll(String content,String Title,char type,String PathIcon){      
    JTextArea textArea = new JTextArea(content,6, 25);
            textArea.setEditable(false);
             JScrollPane scrollPane = new JScrollPane(textArea);

if (PathIcon.equals(null)||PathIcon.equals("")||PathIcon.equals(" ")) 
{          
   switch(Character.toLowerCase(type)){
    case'p' : JOptionPane.showMessageDialog(null,scrollPane,Title ,JOptionPane.PLAIN_MESSAGE);         break;       
    case'e' : JOptionPane.showMessageDialog(null,scrollPane,Title ,JOptionPane.ERROR_MESSAGE);         break;        
    case'w' : JOptionPane.showMessageDialog(null,scrollPane,Title ,JOptionPane.WARNING_MESSAGE);       break; 
    case'i' : JOptionPane.showMessageDialog(null,scrollPane,Title ,JOptionPane.INFORMATION_MESSAGE);   break; 
    case'q' : JOptionPane.showMessageDialog(null,scrollPane,Title ,JOptionPane.QUESTION_MESSAGE);      break; 
    default : JOptionPane.showMessageDialog(null,scrollPane,Title ,JOptionPane.INFORMATION_MESSAGE);   break;    }
       
}
else  JOptionPane.showMessageDialog(null, scrollPane,Title,JOptionPane.INFORMATION_MESSAGE,new ImageIcon(PathIcon));
    }

    
    /**
     * @param content  Content of Message
     * @param Title  Head of Message
     * @param type  type of Message as Char default Plain Message@param
     * @deprecated  Type
     * <p>
     * 'p' > Plain Message<br>
     * 'e' > Error Message<br>
     * 'w' > Warning Message<br>
     * 'i' > Information Message<br>
     * 'q' > Question Message<br>
     * </p>
     * @param PathIcon   Location of Image can be null if NOT needed
     * <b>if Location found Type will no use</b>
     *@<b>return 0 if Canceled or Abort</b>
     */
    public static int OptionDialog(String content,String Title,char Type,Object[] ButtonsName,String PathIcon){
 

if (PathIcon.equals(null)||PathIcon.equals("")||PathIcon.equals(" ")) {
    switch(Character.toLowerCase(Type)){
    case'p' : x = JOptionPane.showOptionDialog(null, content, Title,JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,    null,  ButtonsName, 0);         break;       
    case'e' : x = JOptionPane.showOptionDialog(null, content, Title,JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE,    null, ButtonsName, 0);         break;        
    case'w' : x = JOptionPane.showOptionDialog(null, content, Title,JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,    null, ButtonsName, 0);       break; 
    case'i' : x = JOptionPane.showOptionDialog(null, content, Title,JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,    null, ButtonsName, 0);   break; 
    case'q' : x = JOptionPane.showOptionDialog(null, content, Title,JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,    null, ButtonsName, 0);      break; 
    default : x = JOptionPane.showOptionDialog(null, content, Title,JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,    null, ButtonsName, 0);   break;    }
            
}
else x = JOptionPane.showOptionDialog(null, content, Title,JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,    new ImageIcon(PathIcon),  ButtonsName, 0);
   
       if (x==-1) 
       return 0; //error
       else return x;
    
  
}

    
    /**
      
     * @param Content ONLY Panel NO FRAME
     * @param Title
     * @param ButtonsName No button write new Object[]{}
     * @return 0 if canceled AND return start from 1
     */
    public static int OptionDialog_Component(Component Content ,String Title,Object[] ButtonsName){

 
 x = JOptionPane.showOptionDialog(null, Content, Title,JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,  null,  ButtonsName, 1); 
    
       if (x==-1) 
       return 0; //error
       else return x;  
}

    
    /**
     * @param content  Content of Message
     * @param Title  Head of Message
     * @param type  type of Message as Char default Plain Message@param
     * @deprecated  Type
     * <p>
     * 'p' > Plain Message<br>
     * 'e' > Error Message<br>
     * 'w' > Warning Message<br>
     * 'i' > Information Message<br>
     * 'q' > Question Message<br>
     * </p>
     * @param PathIcon   Location of Image can be "" only if NOT needed
     * <b>if Location found Type will use</b>
     * @return 0 <b>if Canceled or Abort Other return Value Selected Item from combo</b>
     */
    public static String InputDialogAs_ComboBox(String Content,String Title,char Type,String PathIcon,Object[] ComboItems )    {
Object s=null;    
                
if (PathIcon==null||PathIcon.equals("")||PathIcon.equals(" ")) {
    switch(Character.toLowerCase(Type)){
    case'p' : s=JOptionPane.showInputDialog(null, Content, Title, JOptionPane.PLAIN_MESSAGE, null, ComboItems, 1);         break;       
    case'e' : s=JOptionPane.showInputDialog(null, Content, Title, JOptionPane.ERROR_MESSAGE, null, ComboItems, 1);         break;        
    case'w' : s=JOptionPane.showInputDialog(null, Content, Title, JOptionPane.WARNING_MESSAGE, null, ComboItems, 1);       break; 
    case'i' : s=JOptionPane.showInputDialog(null, Content, Title, JOptionPane.INFORMATION_MESSAGE, null, ComboItems, 1);   break; 
    case'q' : s=JOptionPane.showInputDialog(null, Content, Title, JOptionPane.QUESTION_MESSAGE, null, ComboItems, 1);      break; 
    default : s=JOptionPane.showInputDialog(null, Content, Title, JOptionPane.PLAIN_MESSAGE, null, ComboItems, 1);   break;    }
      
      } //end if

else s=JOptionPane.showInputDialog(null, Content, Title, JOptionPane.PLAIN_MESSAGE, new ImageIcon(PathIcon), ComboItems, 1);

        if (s.equals(null)||s.equals("null")) {
     return "0";
        }


 else return  s.toString();
 
    } //end function
    
    
    
    
     public static String InputDialogAs_ComboBox(String Content,String Title,char Type,String PathIcon,Vector ComboItems )    {
Object s=null;    
                
if (PathIcon==null||PathIcon.equals("")||PathIcon.equals(" ")) {
    
    
    switch(Character.toLowerCase(Type)){
    
    case'p' : s=JOptionPane.showInputDialog(null, Content, Title, JOptionPane.PLAIN_MESSAGE, null, ComboItems.toArray(), 1);         break;       
    case'e' : s=JOptionPane.showInputDialog(null, Content, Title, JOptionPane.ERROR_MESSAGE, null, ComboItems.toArray(), 1);         break;        
    case'w' : s=JOptionPane.showInputDialog(null, Content, Title, JOptionPane.WARNING_MESSAGE, null, ComboItems.toArray(), 1);       break; 
    case'i' : s=JOptionPane.showInputDialog(null, Content, Title, JOptionPane.INFORMATION_MESSAGE, null, ComboItems.toArray(), 1);   break; 
    case'q' : s=JOptionPane.showInputDialog(null, Content, Title, JOptionPane.QUESTION_MESSAGE, null, ComboItems.toArray(), 1);      break; 
    default : s=JOptionPane.showInputDialog(null, Content, Title, JOptionPane.PLAIN_MESSAGE, null, ComboItems.toArray(), 1);   break;    }
      
      } //end if

else s=JOptionPane.showInputDialog(null, Content, Title, JOptionPane.PLAIN_MESSAGE, new ImageIcon(PathIcon), ComboItems.toArray(), 1);

        if (s.equals(null)||s.equals("null")) {
     return "0";
        }


 else return  s.toString();
 
    } //end function
    
    
    
    
        
    /**
     * @param content  Content of Message
     * @param Title  Head of Message
     * @param type  type of Message as Char default Plain Message@param
     * @deprecated  Type
     * <p>
     * 'p' > Plain Message<br>
     * 'e' > Error Message<br>
     * 'w' > Warning Message<br>
     * 'i' > Information Message<br>
     * 'q' > Question Message<br>
     * </p>
     * 
     * @return 0 <b>if Canceled or Abort Other return Value Entered in textbox</b>
     */
    public static String InputDialogAs_TextFiel(String Content,String Title,char Type )   {
String s="";    
        try{        

    switch(Character.toLowerCase(Type)){
    case'p' : s=JOptionPane.showInputDialog(null, Content, Title, JOptionPane.PLAIN_MESSAGE);         break;       
    case'e' : s=JOptionPane.showInputDialog(null, Content, Title, JOptionPane.ERROR_MESSAGE);         break;        
    case'w' : s=JOptionPane.showInputDialog(null, Content, Title, JOptionPane.WARNING_MESSAGE);       break; 
    case'i' : s=JOptionPane.showInputDialog(null, Content, Title, JOptionPane.INFORMATION_MESSAGE);   break; 
    case'q' : s=JOptionPane.showInputDialog(null, Content, Title, JOptionPane.QUESTION_MESSAGE);      break; 
    default : s=JOptionPane.showInputDialog(null, Content, Title, JOptionPane.PLAIN_MESSAGE);         break;    }
      
        
if(s.equals(null)||s.equals("null")){
return "0";
}
    return s;
        
        }catch(NullPointerException e){return "0";}
 
    } //end function
    
    
    public static String CONTAINER(Component c)
    {
   
        
 int result =  JOptionPane.showOptionDialog(null, c,"Title", JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE, null, new Object[]{}, null);

 if (result != JOptionPane.OK_OPTION) {
 
    }
        return "";

    }
    
    public static int CONTAINER(Component c,String Btn)
    {
   
        
 int result =  JOptionPane.showOptionDialog(null, c,"Title", JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE, null, new Object[]{Btn}, null);

  
        return result;

    }
    
    public static void CONTAINER(JInternalFrame c,String Title)
    {
   c.setVisible(true);
        
 int result =  JOptionPane.showOptionDialog(null, c  ,Title, JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE, null, new Object[]{}, null);

 if (result != JOptionPane.OK_OPTION) {
 
     } 
 
    }
     
}
