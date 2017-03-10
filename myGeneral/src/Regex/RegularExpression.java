package Regex;


import java.util.regex.Matcher;
import java.util.regex.Pattern;
 


public class RegularExpression {

    /**
     *
     * ^	#start of the line<br>
     * #	# must constains a "#" symbols <br>
     * (	# start of group #1<br>
     * [A-Fa-f0-9]{6} # any strings in the list, with length of 6<br>
     * |	# ..or<br>
     * [A-Fa-f0-9]{3} # any strings in the list, with length of 3<br>
     * )	# end of group #1 <br>
     * $
     *
     * <br><br>
     *
     * <b>Hex code that match:</b><br>
     *
1. “#1f1f1F”, “#AFAFAF”,”#1AFFa1″,”#222fff”, “#F00”, “#F00”
     *
     *
     * @param ColorCode
     * @return
     */
    public static boolean HexaDecimalColorCode(String ColorCode) {
        return Pattern.compile("^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$").matcher(ColorCode).matches();
    }

    
    /**
     *
     * ( #Start of the group #1<br>
     * [^\s]+	# must contains one or more anything (except white space)<br>
     * (	# start of the group #2<br>
     * \.	#	follow by a dot "."<br>
     * (?i)	#	ignore the case sensitive checking<br>
     * (	#	start of the group #3<br>
     * jpg	#	contains characters "jpg"<br>
     * |	#	..or<br>
     * png	#	contains characters "png"<br>
     * |	#	..or<br>
     * gif	#	contains characters "gif"<br>
     * |	#	..or<br>
     * bmp	#	contains characters "bmp"<br>
     * )	#	end of the group #3<br>
     * )	# end of the group #2	<br>
     * $	# end of the string<br>
     * )	#end of the group #1<br>
     * <br>
     *
     *
     *
     * @param Image
     * @return
     */
    public static boolean Image_File_Extension(String ImageName) {
        return Pattern.compile("([^\\s]+(\\.(?i)(jpg|png|gif|bmp))$)").matcher(ImageName).matches();
    }

    /**
     * ^	#start of the line <br>
     * (	# start of group #1 <br>
     * [01]?\\d\\d? # Can be one or two digits. If three digits appear, it must
     * start either 0 or 1 <br>
     * # e.g ([0-9], [0-9][0-9],[0-1][0-9][0-9]) <br>
     * |	# ...or <br>
     * 2[0-4]\\d	# start with 2, follow by 0-4 and end with any digit
     * (2[0-4][0-9])  <br>
     * | # ...or <br>
     * 25[0-5] # start with 2, follow by 5 and end with 0-5 (25[0-5])  <br>
     * )	# end of group #2 <br>
     * \. # follow by a dot "." <br>
     * .... # repeat with 3 time (3x) <br>
     * $	#end of t <br>
     *
     * @param ColorCode
     * @return
     */
    public static boolean IPv4_Address(String IP) {
        return Pattern.compile("^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
                + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
                + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
                + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$").matcher(IP).matches();
    }

    public static boolean IPv6_Address(String IPv6_Address) {
         
        return Pattern.matches("(([0-9a-fA-F]{1,4}:){7,7}[0-9a-fA-F]{1,4}|([0-9a-fA-F]{1,4}:){1,7}:|([0-9a-fA-F]{1,4}:){1,6}:[0-9a-fA-F]{1,4}|([0-9a-fA-F]{1,4}:){1,5}(:[0-9a-fA-F]{1,4}){1,2}|([0-9a-fA-F]{1,4}:){1,4}(:[0-9a-fA-F]{1,4}){1,3}|([0-9a-fA-F]{1,4}:){1,3}(:[0-9a-fA-F]{1,4}){1,4}|([0-9a-fA-F]{1,4}:){1,2}(:[0-9a-fA-F]{1,4}){1,5}|[0-9a-fA-F]{1,4}:((:[0-9a-fA-F]{1,4}){1,6})|:((:[0-9a-fA-F]{1,4}){1,7}|:)|fe80:(:[0-9a-fA-F]{0,4}){0,4}%[0-9a-zA-Z]{1,}|::(ffff(:0{1,4}){0,1}:){0,1}((25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9])\\.){3,3}(25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9])|([0-9a-fA-F]{1,4}:){1,4}:((25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9])\\.){3,3}(25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9]))", IPv6_Address);
    }
    

    /**
     * (	#start of group #1<br>
     * 1[012]	# start with 10, 11, 12<br>
     * |	# or<br>
     * [1-9]	# start with 1,2,...9<br>
     * )	#end of group #1<br>
     * :	# follow by a semi colon (:)<br>
     * [0-5][0-9]	# follow by 0..5 and 0..9, which means 00 to 59<br>
     * (\\s)?	# follow by a white space (optional)<br>
     * (?i)	# next checking is case insensitive<br>
     * (am|pm)	# follow by am or pm<br>
     *
     * @param Time_12
     * @return
     */
    public static boolean Time12_Hour(String Time_12) {
        return Pattern.compile("(1[012]|[1-9]):[0-5][0-9](\\s)?(?i)(am|pm)").matcher(Time_12).matches();
    }

    /**
     * (#start of group #1<br>
     * [01]?[0-9] # start with 0-9,1-9,00-09,10-19<br>
     * | #or<br>
     * 2[0-3]	#start with 20-23<br>
     * ) #end of group #1<br>
     * : #follow by a semi colon (:)<br>
     * [0-5][0-9] #follow by 0..5 and 0..9, which means 00 to 59<br>
     *
     *
     * @param Time_24
     * @return
     */
    public static boolean Time24_Hour(String Time_24) {
        return Pattern.compile("([01]?[0-9]|2[0-3]):[0-5][0-9]").matcher(Time_24).matches();
    }
     

    /**
     * <b>Date Format (dd/mm/yyyy) </b>
     *
     * (	#start of group #1<br>
     * 0?[1-9]# 01-09 or 1-9<br>
     * | # ..or<br>
     * [12][0-9]# 10-19 or 20-29<br>
     * |# ..or<br>
     * 3[01]#30, 31<br>
     * )#end of group #1<br>
     * /#follow by a "/"<br>
     * (#start of group #2<br>
     * 0?[1-9]#	01-09 or 1-9<br>
     * |#	..or<br>
     * 1[012]# 10,11,12<br>
     * )# end of group #2<br>
     * /#	follow by a "/"<br>
     * (#start of group #3<br>
     * (19|20)\\d\\d# 19[0-9][0-9] or 20[0-9][0-9]<br>
     * )#end of group #3<br>
     *
     *
     * @param Day:Day number
     * @param Month:Month Number
     * @param Year
     *
     * @return
     */
    public static boolean Date_Format(int Day, int month, int year) {
        return Pattern.compile("(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)").matcher(Day + "/" + month + "/" + year).matches();
    }

    /**
     * <b>Date Format (dd/mm/yyyy) </b>
     */
    public static boolean Date_Format(String Date) {
        return Pattern.compile("(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)").matcher(Date).matches();
    }

    /**
     * <b>Social Number Security Format (000-00-0000) </b>
     */
    public static boolean SSN(String SSN_full) {
        return Pattern.matches("^(?!000|666)[0-8][0-9]{2}-(?!00)[0-9]{2}-(?!0000)[0-9]{4}$", SSN_full);
    }

    /**
     * <b>Social Number Security Format</b> <br>
     *
     * @param G1>000<br>
     * @param G2>00<br>
     * @param G3>0000<br>
     * (000-00-0000) </b>
     */
    public static boolean SSN(int G1, int G2, int G3) {
        return Pattern.matches("^(?!000|666)[0-8][0-9]{2}-(?!00)[0-9]{2}-(?!0000)[0-9]{4}$", G1 + "-" + G2 + "-" + G3);
    }

    /**
     * 012-892-864-68
     *
     * @param G1>012<br>
     * @param G2>892<br>
     * @param G3>864<br>
     * @param G4>68<br>
     */
    public static boolean Phone(int G1, int G2, int G3, int G4) {
        return Pattern.matches("^[0-9]\\d{3}-\\d{3}-\\d{3-\\d{2}}$", G1 + "-" + G2 + "-" + G3 + "-" + G4);
    }

    /**
     *
     * @param PhoneNumber>01289286468
     * @return
     */
    public static boolean Phone(String PhoneNumber) {
        return Pattern.matches("^[0-9]{11}$", PhoneNumber);
    }
 
    
   public static String removeDuplicateWhitespace(CharSequence inputStr) {
     
         return Pattern.compile("\\s+").matcher(inputStr).replaceAll(" ");
  }
   

   /**
    * String String >>Dublicated
    * @param phrase
    * @return 
    */
   public static boolean  DuplicateWord(String phrase) {
    boolean retval = false;
  
    Pattern p = null;
     
      p = Pattern.compile("\\b(\\w+) \\1\\b");
    
    int matches = 0;
    Matcher m = p.matcher(phrase);
    String val = null;

    while (m.find()) {
      retval = true;
      val = ":" + m.group() + ":";
       
      matches++;
    }

    
    return retval;
  }
   
   
   public static String FindDuplicateWord(String phrase) {
    
       Pattern p = null;
     
        p = Pattern.compile("\\b(\\w+) \\1\\b");
    
     
    Matcher m = p.matcher(phrase);
    

    while (m.find()) {
      phrase = ":" + m.group(1) + ":";
    }

    
    return phrase;
  }
   
   /**
    * Menna >Mena
    * @param args 
    */
   public static String RemoveDoubledLetter(String Word)
    {
        return Word.replaceAll("(.)\\1", "$1");
    }
    
   
   public static Boolean HasDoubledLetter (String Word)
    {Pattern p = Pattern.compile("(\\w)\\1+");
Matcher m = p.matcher(Word);
        return ( m.find())  ;
    }
   
   
   /**
    * John Allen Smith 888 Luck Street, NY 64332-4453
    * @param USAaddress
    * @return 
    */
    public static boolean USA_Full_address (String USAaddress) {
 
    return Pattern.matches("^(\\p{Upper}(\\p{Lower}+\\s?)){2,3}\\w+ .*, \\w+ \\d{5}(-\\d{4})?$",USAaddress);
  }
   
    
   public static boolean Email(String Email)
   {
       return Pattern.matches("(?:(?:\\r\\n)?[ \\t])*(?:(?:(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*|(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)*\\<(?:(?:\\r\\n)?[ \\t])*(?:@(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*(?:,@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*)*:(?:(?:\\r\\n)?[ \\t])*)?(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*\\>(?:(?:\\r\\n)?[ \\t])*)|(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)*:(?:(?:\\r\\n)?[ \\t])*(?:(?:(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*|(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)*\\<(?:(?:\\r\\n)?[ \\t])*(?:@(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*(?:,@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*)*:(?:(?:\\r\\n)?[ \\t])*)?(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*\\>(?:(?:\\r\\n)?[ \\t])*)(?:,\\s*(?:(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*|(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)*\\<(?:(?:\\r\\n)?[ \\t])*(?:@(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*(?:,@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*)*:(?:(?:\\r\\n)?[ \\t])*)?(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*\\>(?:(?:\\r\\n)?[ \\t])*))*)?;\\s*)",Email);
   }
    
   /**
    * https://www.google.com
    * @param args
    * @return 
    */
    public static boolean WEB_URL_Pure(String args) {
        return Pattern.matches("(http://|https://)(www.)?([a-zA-Z0-9]+).[a-zA-Z0-9]*.[a-z]{3}.?([a-z]+)?", args);
    }
  
    
    
    public static String  CorrectName(String BadName)
    {
        Matcher pat1=Pattern.compile(".ola$").matcher(BadName.toLowerCase()) ;

        if (pat1.matches()) {
            return BadName=pat1.replaceAll("b")+"ola" ;
        }
       
        pat1=Pattern.compile(".e.hoy$").matcher(BadName.toLowerCase()) ;
        if (pat1.matches()) {
            return BadName=pat1.replaceAll("beshoy")  ;
        }
        
        pat1=Pattern.compile("m.n.?a$").matcher(BadName.toLowerCase()) ;
        if (pat1.matches()||HasDoubledLetter(BadName.toLowerCase())) {
            return BadName=pat1.replaceAll("mina")  ;
        }
        
        pat1=Pattern.compile("k.rollos|k.rolos$").matcher(BadName.toLowerCase()) ;
        if (pat1.matches()) {
            return BadName=pat1.replaceAll("kerolos") ;
        }
        
        pat1=Pattern.compile("andr[e-w]$").matcher(BadName.toLowerCase()) ;
        if (pat1.matches()) {
            return BadName=pat1.replaceAll("andrew")  ;
        }
        
        
        pat1=Pattern.compile("abano.?b$").matcher(BadName.toLowerCase()) ;
        if (pat1.matches()) {
            return BadName=pat1.replaceAll("abanoub") ;
        }
        
        pat1=Pattern.compile(".?.?restena$").matcher(BadName.toLowerCase()) ;
        if (pat1.matches()) {
            return BadName=pat1.replaceAll("chrestena") ;
        }
        
        pat1=Pattern.compile(".?.?resten$").matcher(BadName.toLowerCase()) ;
        if (pat1.matches()) {
            return BadName=pat1.replaceAll("chresten");
        }
        
        pat1=Pattern.compile(".eter$").matcher(BadName.toLowerCase()) ;
        if (pat1.matches()) {
            return BadName=pat1.replaceAll("peter");
        }
        
        pat1=Pattern.compile("m.rna$").matcher(BadName.toLowerCase()) ;
        if (pat1.matches()) {
            return BadName=pat1.replaceAll("merna") ;
        }
        
        pat1=Pattern.compile("dav.d$").matcher(BadName.toLowerCase()) ;
        if (pat1.matches()) {
            return BadName=pat1.replaceAll("david") ;
        }
        
        pat1=Pattern.compile("mon.{2}a$").matcher(BadName.toLowerCase()) ;
        if (pat1.matches()) {
            return BadName=pat1.replaceAll("monica") ;
        }
        
        pat1=Pattern.compile("m.rna$").matcher(BadName.toLowerCase()) ;
        if (pat1.matches()) {
            return BadName=pat1.replaceAll("merna") ;
        }
        
        pat1=Pattern.compile("n.v.n$").matcher(BadName.toLowerCase()) ;
        if (pat1.matches()) {
            return BadName=pat1.replaceAll("nevin") ;
        }
        
        pat1=Pattern.compile("mar.am$").matcher(BadName.toLowerCase()) ;
        if (pat1.matches()) {
            return BadName=pat1.replaceAll("maryam") ;
        }
        
        pat1=Pattern.compile("mn.rva$").matcher(BadName.toLowerCase()) ;
        if (pat1.matches()) {
            return BadName=pat1.replaceAll("mnerva") ;
        }
        
         pat1=Pattern.compile("^mi.?.?.?.?l$").matcher(BadName.toLowerCase()) ;
        if (pat1.matches()) {
            return BadName=pat1.replaceAll("micheal") ;
        }
        
         pat1=Pattern.compile("mn.rva$").matcher(BadName.toLowerCase()) ;
        if (pat1.matches()) {
            return BadName=pat1.replaceAll("mnerva") ;
        }
        
        pat1=Pattern.compile("^b.{3,}").matcher(BadName.toLowerCase()) ;
        if (pat1.matches()) {
            return BadName=pat1.replaceAll("p")+BadName.replace("b", "") ;
        }
        
     return BadName ;
    }
   
    
public static void main(String[] args) {
 
         System.out.println(CorrectName("mikel"));

    }
}
