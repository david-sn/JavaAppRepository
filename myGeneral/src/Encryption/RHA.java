
package Encryption;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class RHA {
/**<b>    
    MD2
    MD5
    SHA-1
    SHA-256
    SHA-384
    SHA-512
</b>
    */
  static public String get_SHA_512_SecurePassword(String passwordToHash, String   salt){
String generatedPassword = null;
    try {
         MessageDigest md = MessageDigest.getInstance("SHA-1");
         md.update(salt.getBytes("UTF-8"));
         byte[] bytes = md.digest(passwordToHash.getBytes("UTF-8"));
         StringBuilder sb = new StringBuilder();
         for(int i=0; i< bytes.length ;i++){
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
         }
         generatedPassword = sb.toString();
        } 
       catch (NoSuchAlgorithmException e){
        e.printStackTrace();
       } catch (UnsupportedEncodingException ex) {
          Logger.getLogger(RHA.class.getName()).log(Level.SEVERE, null, ex);
      }
    return generatedPassword;
}
    
  
  
  
   
  
  public static void main(String[] args) throws NoSuchAlgorithmException {
        System.err.println(get_SHA_512_SecurePassword("david","davi"));
        
       
      
      
    }
    
}
