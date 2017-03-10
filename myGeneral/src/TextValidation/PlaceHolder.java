/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextValidation;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;

/**
 *
 * @author David Sherif <br>
 * 
 * Take an array of this class like PlaceHolder []p=new PlaceHolder[4];
 * <br> then use p[0]=new PlaceHolder();<br>p[0].focus.........
 * 
 */
public class PlaceHolder {
 String s="";
 short check=1; 
 Font f;

static Color forcolor;

    /**
     *
     * @param evt
     * @param TextField
     * Take an array of this class like PlaceHolder []p=new PlaceHolder[4];
 * <br> then use p[0]=new PlaceHolder();<br>p[0].focus.........
 * 
     */
    public  void FocusLost(java.awt.event.FocusEvent evt,JTextField TextField){
    
    
   
    if(check !=1)
    if (TextField.getText().trim().isEmpty()) {
            TextField.setForeground(Color.GRAY);
            TextField.setFont(new Font("DialogInput", Font.ITALIC, TextField.getFont().getSize()));
            TextField.setText(s);
        }
    }

    /**
     *
     * @param evt
     * @param TextField
     */
    public  void FocusGain(java.awt.event.FocusEvent evt,JTextField TextField){
    
    if(check==1){
     s=TextField.getText();
    f=new Font(TextField.getFont().getName(),TextField.getFont().getStyle(),TextField.getFont().getSize());
    forcolor=TextField.getForeground();
    check++;
        System.err.println("here intializa  "+check+"  Gain");
    }
    
    
        if (TextField.getText().equals(s)) {
            TextField.setText("");
            TextField.setFont(f);
            TextField.setForeground(forcolor);
            //check=1;
        }
    }
    
    

    
}
