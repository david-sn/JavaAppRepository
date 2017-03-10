/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Voice_Translate;

import java.io.*;

import com.sun.speech.freetts.*;

/**
 *
 * @author David Sherif
 */
public class textToSpeach {
    private static final String VOICENAME="kevin16";
    public static void TextToTalk(String  TextToTalk) {
        
        Voice voice;
        VoiceManager vm =VoiceManager.getInstance();
        voice=vm.getVoice(VOICENAME);
        voice.setRate(100);
       
   //voice.setPitch((float)(50));
   //voice.setPitchShift((float)(6.2));
   //voice.setPitchRange((float)(100.0)); //mutace
    voice.setStyle("breathy");  //"business", "casual", "robotic", "breathy"

    voice.allocate();
        try{
          //  voice.setVolume(5f);
            
        voice.speak(TextToTalk);
        
        }
        catch(Exception e){e.printStackTrace();}
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
}
