/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OriginalClasses;
import DatabaseConnection.OracleConn;
import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public  class ComboWithIMAGES  
{
    DefaultComboBoxModel de =new DefaultComboBoxModel();
    
     public ComboWithIMAGES(JComboBox c2,String[] ImagesPath,String[] Text){
        c2.setModel(populate(ImagesPath,Text));
         c2.setRenderer(new ImagesTextRender());
        }
    
   
    private DefaultComboBoxModel populate(String[] ImagesPath,String[] Text){
     
     for(int i=0; i<OracleConn.stop;i++){
          de.addElement(new ImagesText(new ImageIcon(ImagesPath[i]), Text[i]));
         
              
    }
    return de;
    }
    
    
   
    Color c=new Color(0,102,255);
    class ImagesTextRender extends JLabel implements ListCellRenderer{

        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
           ImagesText it=(ImagesText) value;
            setIcon(it.getImg());
            setText(it.getName());
            
            if(isSelected){
                
                setBackground(c);
                setForeground(list.getSelectionForeground());
          
               
            }
            else {
                setBackground(list.getBackground());
                setForeground(list.getForeground());
           
            }
            
            setFont(list.getFont());
        
           
            
            
            
            return this;
        }
        
    
        
        
        
    }
    class ImagesText{
    private Icon img;
    private String name;

        public void setImg(Icon img) {
            this.img = img;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Icon getImg() {
            return img;
        }

        public String getName() {
            return name;
        }
    
    public ImagesText(Icon img,String name){
    this.img=img; this.name=name;
    }
    }
    
    
    public static void comboWithImage(JComboBox c,String[] ImagesPath,String[] Text){

        ComboWithIMAGES c1=new ComboWithIMAGES( c, ImagesPath, Text); 
        
        
    }
}