// 
//package Voice_Translate;
//
//import java.io.BufferedInputStream;
//import java.io.*;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javazoom.jl.decoder.JavaLayerException;
//import javazoom.jl.player.*;
//import sun.audio.AudioPlayer;
//import sun.audio.AudioStream;
//
//
//public class RunMusic {
//
//    
//    
// public static void RUN_MP3(String MP3Path){
//        FileInputStream in=null;
//        try {
//            File f=new File(MP3Path);
//            in = new FileInputStream(f);
//            BufferedInputStream bit=new BufferedInputStream(in);
//            Player p=new Player(bit);
//            p.play();
//
//            
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(RunMusic.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (JavaLayerException ex) {
//            Logger.getLogger(RunMusic.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            try {
//                in.close();
//            } catch (IOException ex) {
//                Logger.getLogger(RunMusic.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//            
//            
//    }
// 
// 
// public static void RUN_WAV(String WAV_Path){
// InputStream in;
//        try {
//           
//            File f=new File(WAV_Path);
//            in=new FileInputStream(f);
//            AudioStream audio=new AudioStream(in);
//            AudioPlayer.player.start(audio);
//        
//        
//        
//        } catch (FileNotFoundException ex) {
//            ex.printStackTrace();
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//        
// }
// 
//}