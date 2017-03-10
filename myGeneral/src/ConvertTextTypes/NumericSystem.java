
package ConvertTextTypes;



public class NumericSystem {
    
    public static long DecimalToBinary(long Decimal)
    {
        if(Decimal<=99999)
          return Long.parseLong(Long.toBinaryString(Decimal)  );
        else return 0;
    }
     
    
     public static int DecimalToBinary(int Decimal)
    {
        if(Decimal<99999)
          return Integer.parseInt(Long.toBinaryString(Decimal)  );
        else return 0;
    }
    
     
      public static String  DecimalToBinary_(long Decimal)
    {
          return  (Long.toBinaryString(Decimal)  );
    }
    
      
      public static String  DecimalToHexa(long Decimal)
    {
          return  (Long.toHexString(Decimal)  );
    }
      
       public static String  DecimalToOcta(long Decimal)
    {
          return  (Long.toOctalString(Decimal)  );
    }
       
    
       
      public static  int binaryToDecimal(int binary,int size){  
        if(binary==0) return 0;        
          return binary%10*(int)Math.pow(2,size)+binaryToDecimal((int)binary/10,size-1);  
}
       
       
       
       
    
    public static void main(String[] args) {
      
        System.err.println(binaryToDecimal(101,2));
        
    }
}
