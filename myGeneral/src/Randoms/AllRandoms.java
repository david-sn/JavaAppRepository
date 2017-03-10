 
package Randoms;

import java.util.Random;
 
public class AllRandoms {
    
    
  static String capital[]={"q","a","z","w","s","x","e","d","c","r","f","v","t","g","b","y","h","n","u","j","m","i","k","o","l","p"};

  static String special[]={"`","~","!","@","#","%","^",":",">",";","'","$","&","\"","(","*","<","_",")","-","?","=","+","/","\\",".","|"};

  static Random random=new Random() ;



    public static char getCapitalChar(){ 
        return capital[random.nextInt(25)].toUpperCase().charAt(0);
    }

    public static char getSmallChar(){ 
    return capital[random.nextInt(25)].toLowerCase().charAt(0);
    }


    public static String getCapitalCharAsString(){ 
        return capital[random.nextInt(25)].toUpperCase();
    }

    public static String getSmallCahrAsString(){ 
    return capital[random.nextInt(25)].toLowerCase();
    }


    public static char getSpecialChar(){ 
        return special[random.nextInt(27)].toLowerCase().charAt(0);
    }

    public static String getSpecialCharAsString(){ 
        return special[random.nextInt(27)].toUpperCase();
    }


    public static int getRangeRandoms(int FromSmall  ,int ToBig){
  
    
    
    
    int k=random.nextInt(ToBig++);
    if(k<FromSmall)
       return   getRangeRandoms( --FromSmall,ToBig);
    
    else   return k;
   
}
 
    
    public static int RangeRandoms(int FromSmall  ,int ToBig){
 
return  random.nextInt((ToBig - FromSmall) + 1) + FromSmall;
       
   
}
    
 
    
    
    
 public static double getRangeRandoms(double FromSmall  ,double ToBig){
  
    
    
    
    int k=random.nextInt((int)ToBig++);
    if(k<FromSmall)
       return   getRangeRandoms( --FromSmall,ToBig);
    
    else   return k;
   
}
    
    
}