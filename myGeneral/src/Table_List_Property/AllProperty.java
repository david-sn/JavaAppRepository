
package Table_List_Property;

import java.awt.Color;
import java.awt.Font;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;



public class AllProperty {
    
   static DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
    
    static DefaultTableModel mod ;
  
   public static void removeColumn(int index, JTable myTable){
    int nRow= myTable.getRowCount();
    int nCol= myTable.getColumnCount()-1;
    Object[][] cells= new Object[nRow][nCol];
    String[] names= new String[nCol];

    for(int j=0; j<nCol; j++){
        if(j<index){
            names[j]= myTable.getColumnName(j);
            for(int i=0; i<nRow; i++){
                cells[i][j]= myTable.getValueAt(i, j);
            }
        }else{
            names[j]= myTable.getColumnName(j+1);
            for(int i=0; i<nRow; i++){
                cells[i][j]= myTable.getValueAt(i, j+1);
            }
        }
    }
  mod= new DefaultTableModel(cells, names);
    myTable.setModel(mod);       
}
   
   private void removeCol(int id,JTable myTable){
      //  DefaultTableModel tmp = new DefaultTableModel();
        int columnas = mod.getColumnCount();
        for(int i=0;i<columnas;i++){
            if(i!=id)
                mod.addColumn(mod.getColumnName(i));
        }
        int rows = mod.getRowCount();
        String datos[] = new String[columnas-1];
        for(int row=0;row<rows;row++){
            for(int col=0,sel=0;col<columnas;col++,sel++){
                if(col!=id)
                    datos[sel] = (String) mod.getValueAt(row, col);
                else
                    sel--;
            }
            mod.addRow(datos);
        }
        myTable=new JTable(mod);

    }
   
   
    public static void clearRows(JTable Table){
   mod= (DefaultTableModel)Table.getModel();
            int clerar_table_count=mod.getRowCount();
            
            if (mod.getRowCount()!=0) {
                
                for (int r = 0; r < clerar_table_count; r++) {
                    mod.removeRow(0);
                }}
    }
    
    public static void setColumnWidthAuto(JTable Table){
        Font f=new Font("", 0, 0);
        f=Table.getFont();
        f.getSize();
        Table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        int max=3;
        for(int k=0;k<Table.getColumnCount();k++){      
            for (int rows = 0; rows < Table.getRowCount(); rows++) 
                if(max<Table.getValueAt(rows, k).toString().length())max=Table.getValueAt(rows, k).toString().length();
            
            Table.getColumnModel().getColumn(k).setPreferredWidth(8*max+f.getSize());
            
              
        }
        
    }
        
    public static void setColumnWidthManual(JTable Table,int...Size){
     Table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
     int h=0; 
     for(int l:Size)
             Table.getColumnModel().getColumn(h++).setPreferredWidth(l);
         }
    
    public static void CenterDataInTable(JTable Table,int startColumn,int EndCoiumn){
     
centerRenderer.setHorizontalAlignment( SwingConstants.CENTER );   
if(EndCoiumn==0){
for(int i=startColumn;i<Table.getColumnCount();i++)
Table.getColumnModel().getColumn(i).setCellRenderer( centerRenderer );
              }

for(int i=startColumn;i<EndCoiumn;i++)
Table.getColumnModel().getColumn(i).setCellRenderer( centerRenderer );
              
     
     
     }
     
    public static void setFontHeader(JTable Table,String FontName,char Type,int size,Color FontColor,Color BackgroundColor){

          DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
         Font f;
         switch(Character.toLowerCase(Type)){
         case'b':f=new Font(FontName,Font.BOLD,size); break;
         case'i':f=new Font(FontName,Font.ITALIC,size); break;
         case'u':f=new Font(FontName,Font.TRUETYPE_FONT,size); break;
         default:f=new Font(FontName,0,size); break;
         }
         
         centerRenderer.setForeground(FontColor);
         centerRenderer.setBackground(BackgroundColor);
         centerRenderer.setFont(f);
         
  Table.getColumnModel().getColumn(0).setHeaderRenderer(centerRenderer);
      }
           
    public static void addRow(JTable Table,Object...Values){
         mod= (DefaultTableModel)Table.getModel();
          
          Vector v=new Vector();
          for (Object Value : Values) {
              v.add(Value);
          }
          mod.addRow(v);
      v.removeAllElements();
      v.clear();
      }
      
    
    public static void hideColumn(JTable TableName,int ColumnIndex){
    
     TableName.getColumnModel().getColumn(ColumnIndex).setWidth(0);
TableName.getColumnModel().getColumn(ColumnIndex).setMinWidth(0);
TableName.getColumnModel().getColumn(ColumnIndex).setMaxWidth(0);
    }
    
    public static void hideIDColumn(JTable TableName){
    
     TableName.getColumnModel().getColumn(0).setWidth(0);
TableName.getColumnModel().getColumn(0).setMinWidth(0);
TableName.getColumnModel().getColumn(0).setMaxWidth(0);
    }
      
     
}
