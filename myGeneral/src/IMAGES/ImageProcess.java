/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IMAGES;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author David Sherif
 */
public class ImageProcess {
    
    public static void ScreenShoot  () {
        try {
            Robot r=new Robot();
         Rectangle rec=new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage bf =r.createScreenCapture(rec);
            ImageIO.write(bf, "png",new File( System.getProperty("user.home")+"/Desktop/Screenc.png"));
              
        } catch (AWTException ex) {
          Files.Error_Dynamic.getERRORS("ImageProcess > ScreenShot", ex);
        } catch (IOException ex) {
         Files.Error_Dynamic.getERRORS("ImageProcess > ScreenShot", ex);
        }
        
    }
    
    
}
