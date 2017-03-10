 
package ConvertTextTypes;

 
public class Converts {
    
    public static int ParseINT(String NumberString)
    {
        return Integer.parseInt(NumberString);
    }
    
    public static int parseINT(String NumberPlusText)
    {
        return Integer.parseInt(NumberPlusText.replaceAll("[^0-9]", ""));
    }

    public static boolean ParseBool(String value)
    {
        switch (value.toLowerCase()) 
        {
            case "true": return true; 
            
            case "fales": return false; 
            
            case "1": return true; 
            
            case "0": return true; 
                
            default: return false;
        }

    }

     public static boolean ParseBool(char value)
    {
        switch (value) 
        {
            case 't': return true; 
            case 'T': return true;
            
            case 'f': return false; 
            case 'F': return true;
            
            case '1': return true; 
            
            case '0': return true; 
                
            default: return false;
        }
    }

     
     

}
    

