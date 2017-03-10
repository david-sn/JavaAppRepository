/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OptionPane;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.ImageIcon;




public class MsgThread extends javax.swing.JDialog {

    
    
    public MsgThread(java.awt.Frame parent, boolean modal) {
       initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setTitle("System Action");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true), "System Action", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 255, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONS/sub.png"))); // NOI18N
        jLabel1.setText("Updted  Successfully");
        jLabel1.setIconTextGap(10);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
        );

        jLabel1.getAccessibleContext().setAccessibleParent(this);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    
    
    
     static Thread  t;
    static MsgThread not=new MsgThread(null,true);
   
    /**
     * @param type <br>
     * i ==> INSERT Successfully<br>
     * u ==> UPDATE Successfully<br>
     * d ==> Delete Successfully<br>
     */
    
public static void msg_Success(char type){
       switch (Character.toLowerCase(type)) {
           case 'i': jLabel1.setText("Added  Successfully"); break;
           case 'u': jLabel1.setText("Edited  Successfully"); break;
           case 'd': jLabel1.setText("Deleted  Successfully"); break;
          default:jLabel1.setText("Done"); break;         
       }
       
       not.setSize(282, 70);
       
      not.setVisible(true);
      
      
t=new Thread(new Runnable() {
    
    @Override 
     public void run() {
        try {
            for (int i = (-not.getWidth()); i < 5; i+=5) {
                     not.setLocation(i,(int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()-not.getHeight()-5));
                    Thread.sleep(4);
               }
            
            Thread.sleep(2599);
                
            for (int i =0; i >-320 ; i-=5) {
           not.setLocation(i,(int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()-not.getHeight()-5));
                    Thread.sleep(2);                   
            }
                        not.setVisible(false);

           
         }
    catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
});


       if (t.isAlive()) {
           t.stop();
            }
       else {t.start(); }

}
    
public static void msg_Success(String s,int WaiteTimeSeconds){
        jLabel1.setText(s);     
        jLabel1.setIcon(new ImageIcon("A:\\My programs\\myGeneral\\src\\ICONS\\flag.png"));
       not.setSize(s.length()*10+60, 60);
        not.setVisible(true);
      
      
t=new Thread(new Runnable() {
    
    @Override 
     public void run() {
        try {
            for (int i = (-not.getWidth()); i < 5; i+=5) {
not.setLocation(i,(int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()-not.getHeight()-5));                    Thread.sleep(4);
               }
            
            Thread.sleep(WaiteTimeSeconds*1000);
                
            for (int i =0; i >-not.getWidth()+5 ; i-=5) {
not.setLocation(i,(int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()-not.getHeight()-5));                    Thread.sleep(2);                   
            }
            not.setVisible(false);
           
         }
    catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
});


       if (t.isAlive()) {
           t.stop();
            }
       else {t.start(); }

}
 
public static void msg_Failed(){
       
    jLabel1.setText("Error You Don't Have Privilage To Do This Action Now");          
       jLabel1.setForeground(Color.red);
       jLabel1.setIcon(new ImageIcon("A:\\My programs\\myGeneral\\src\\ICONS\\Error.png"));
             
       not.setSize(600, 69);
       
       not.setVisible(true);
   
      
 t=new Thread(new Runnable() {
    
    @Override 
     public void run() {
        try {
            for (int i = (-not.getWidth()); i < 5; i+=5) {
not.setLocation(i,(int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()-not.getHeight()-5));                    Thread.sleep(4);
               }
            
            Thread.sleep(2899);
                
            for (int i =0; i >-not.getWidth()+5 ; i-=5) {
not.setLocation(i,(int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()-not.getHeight()-5));                    Thread.sleep(2);                   
            }
                       not.setVisible(false);

                       Thread.sleep(2899);
//                       System.err.println("gg");

                        
         }
    catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        
    }
});


       if (t.isAlive()) {
           t.stop();
            }
       else {t.start(); }
}



public static void msg_Failed(String msg){
       
    jLabel1.setText(msg);  
    
       jLabel1.setForeground(Color.red);
       jLabel1.setIcon(new ImageIcon("A:\\My programs\\myGeneral\\src\\ICONS\\Error.png"));
             
       not.setSize(msg.length()*20, 69);
       
       not.setVisible(true);
   
      
 t=new Thread(new Runnable() {
    
    @Override 
     public void run() {
        try {
            for (int i = (-not.getWidth()); i < 5; i+=5) {
not.setLocation(i,(int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()-not.getHeight()-5));                    Thread.sleep(4);
               }
            
            Thread.sleep(2990);
                
            for (int i =0; i >-not.getWidth()+5 ; i-=5) {
not.setLocation(i,(int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()-not.getHeight()-5));                    Thread.sleep(2);                   
            }
                       not.setVisible(false);
                       Thread.sleep(2899);
         }
    catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
});


       if (t.isAlive()) {
           t.stop();
            }
       else {t.start(); }

}

   
    
    public static void main(String args[]) {
      
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MsgThread.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MsgThread.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MsgThread.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MsgThread.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //NewJDialog dialog = new MsgThread(new javax.swing.JFrame(), true);
                //dialog.addWindowListener(new java.awt.event.WindowAdapter() {
           //         @Override
                 //   public void windowClosing(java.awt.event.WindowEvent e) {
                   //     System.exit(0);
                   // }
               // });
                //dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JLabel jLabel1;
    private static javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
