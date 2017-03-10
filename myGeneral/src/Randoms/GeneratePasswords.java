
package Randoms;

import static Randoms.AllRandoms.getCapitalCharAsString;
import static Randoms.AllRandoms.getSmallCahrAsString;
import static Randoms.AllRandoms.getSpecialChar;
import static Randoms.AllRandoms.random;
import java.util.regex.Pattern;

public class GeneratePasswords {

    private static String result="";

    
    
    
    public static String passSmallCharachter(int length){
   
        for (int i = 0; i < length; i++) {
            result += getSmallCahrAsString();
        }
        return result;
    }
    public static String passCapitalCharachter(int length){
   
        for (int i = 0; i < length; i++) {
            result += getCapitalCharAsString();
        }
        return result;
    }
    
    
    public static String passMixChars(int length){

        for (int i = 0; i < length; i++) {
            if (random.nextInt(20)%2==0) result += getSmallCahrAsString();
            
           else 
            result += getCapitalCharAsString();
        
        }
      
        
        if (Pattern.compile("[A-Z]{0,}[a-z]{0,}").matcher(result).matches()) {
            result="";
           passMixChars(length);
        }
        
        return result;
    }
    
    
    public static String finalpass(int length,char number,char capital,char special){
    result="";
       
        for (int i = 0; i < length; i+=4) 
        {
             
           
            if (number=='1'&&capital=='1'&&special=='1') 
            {
                switch (random.nextInt(11)) {
                case 1:
                result +=  getCapitalCharAsString(); 
                result += getSmallCahrAsString();    
                result +=  getSpecialChar();         
                result +=  random.nextInt(9);  
                break;

                case 2:
                result += getSmallCahrAsString();    
                result +=  getCapitalCharAsString(); 
                result +=  random.nextInt(9);  
                result +=  getSpecialChar();         
                        break;

                case 3:
                result += getSmallCahrAsString();    
                result +=  random.nextInt(9);
                result +=  getSpecialChar();         
                result +=  getCapitalCharAsString(); 
                break;

                case 4:
                result += getSmallCahrAsString();    
                result +=  getCapitalCharAsString(); 
                result +=  getSpecialChar();         
                result +=  random.nextInt(9);   break;

                case 5:
                result +=  getCapitalCharAsString(); 
                result +=  getSpecialChar();                         
                result +=  random.nextInt(9);
                result += getSmallCahrAsString();    break;

                case 6:
                result += getSmallCahrAsString();    
                result +=  getCapitalCharAsString(); 
                result +=  getSpecialChar();         
                result +=  random.nextInt(9);   break;
                    
                 case 7:
                result +=  random.nextInt(9);
                result +=  getCapitalCharAsString(); 
                result +=  getSpecialChar();        
                result += getSmallCahrAsString();    
                break;
 
                 case 8:
                 result +=  getSpecialChar();         
                 result += getSmallCahrAsString();    
                 result +=  getCapitalCharAsString(); 
                 result +=  random.nextInt(9);   break;

                case 9:
                result +=  getSpecialChar();         
                result +=  getCapitalCharAsString(); 
                result +=  random.nextInt(9);
                result += getSmallCahrAsString();    
                 break;

                case 10:
                result += getSmallCahrAsString();    
                result +=  getCapitalCharAsString(); 
                result +=  random.nextInt(9);  
                result +=  getSpecialChar();         
                break;
                        
                }
            }
            
            
            else if (number=='0'&&capital=='0'&&special=='0') 
            {
                result+=getSmallCahrAsString();
            }
            
            else if (number=='0'&&capital=='0'&&special=='1') 
            {
                result+=getSpecialChar();
                result+=getSmallCahrAsString();
            }
            
            
        }//for
         if (Pattern.compile("(?=.*[0-9])(?=.*[a-z])(?=.*[`~!@#$%^&*()-_=+\\|?><]).{0,}").matcher("D@A2ViD").matches()==false||result.length()<length) {
                         System.err.println("error "+result);
                         result="";
                    finalpass(length,'1','1','1');
                    }
        
        return result;
    
    }

    
    
    public static void main(String[] args) {
      
         
    }   
}