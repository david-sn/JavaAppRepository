package ConvertTextTypes;


import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.concurrent.Callable;

public class Demo {

private static final String[] ones =
{
" one",
" two",
" three",
" four",
" five",
" six",
" seven",
" eight",
" nine",
" ten",
" eleven",
" twelve",
" thirteen",
" fourteen",
" fifteen",
" sixteen",
" seventeen",
" eighteen",
" nineteen" };

private static final String[] tens =
{
" twenty",
" thirty",
" forty",
" fifty",
" sixty",
" seventy",
" eighty",
" ninety" };

//
// so quintillions is as big as it gets. The
// program would automatically handle larger
// numbers if this array were extended.
//
private static final String[] groups =
{
"",
" thousand",
" million",
" billion",
" trillion",
" quadrillion",
" quintillion" };

private static String string = new String();

 
public static String EnglishNumber(long enteredNo) {

// Go through the number one group at a time.
//System.out.println("groups.length= " + groups.length);
for (int i = groups.length - 1; i >= 0; i--) {

// Is the number as big as this group?

long cutoff = (long) Math.pow((double) 10, (double) (i * 3));

if (enteredNo >= cutoff) {
int thisPart = (int) (enteredNo / cutoff);

// Use the ones[] array for both the
// hundreds and the ones digit. Note
// that tens[] starts at "twenty".

if (thisPart >= 100) {
string += ones[(thisPart / 100) - 1] + " hundred";

thisPart = thisPart % 100;
}
if (thisPart >= 20) {
string += tens[(thisPart / 10) - 2];
thisPart = thisPart % 10;
}
if (thisPart >= 1) {
string += ones[thisPart - 1];
}

string += groups[i];

enteredNo = enteredNo % cutoff;//to check for big numbers which are greater than or equal to 1 million
//System.out.println("enteredNo is : " + enteredNo);
}
}

if (string.length() == 0) {
string = "zero";
} else {
// remove initial space
string = string.substring(1);
}
return string;
}

public static String to_Ranks(int i) {
    String[] sufixes = new String[] { "th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th" };
    switch (i % 100) {
    case 11:
    case 12:
    case 13:
        return i + "th";
    default:
        return i + sufixes[i % 10];

    }
}
 

/**
 * Recursive implementation, invokes itself for each factor of a thousand, increasing the class on each invokation.
 * @param n the number to format
 * @param iteration in fact this is the class from the array c
 * @return a String representing the number n formatted in a cool looking way.
 */
private static String coolFormat(double n, int iteration) {
        char[] c = new char[]{'k', 'm', 'b', 't'};
    double d = ((long) n / 100) / 10.0;
    boolean isRound = (d * 10) %10 == 0;//true if the decimal part is equal to 0 (then it's trimmed anyway)
    return (d < 1000? //this determines the class, i.e. 'k', 'm' etc
        ((d > 99.9 || isRound || (!isRound && d > 9.99)? //this decides whether to trim the decimals
         (int) d * 10 / 10 : d + "" // (int) d * 10 / 10 drops the decimal
         ) + "" + c[iteration]) 
        : coolFormat(d, iteration+1));

}
 
 
/**
 * k", "m", "b", "t based on numers count 000000
*/
private static String K_M_B_T(long number) {
    
 String[] suffix = new String[]{"","k", "m", "b", "t"};
 int MAX_LENGTH = 4;
    String r = new DecimalFormat("##0E0").format(number);
    r = r.replaceAll("E[0-9]", suffix[Character.getNumericValue(r.charAt(r.length() - 1)) / 3]);
    while(r.length() > MAX_LENGTH || r.matches("[0-9]+\\.[a-z]")){
        r = r.substring(0, r.length()-2) + r.substring(r.length() - 1);
    }
    return r;
}
 

	

public static String convertNumberToWord(int word) {
   String d=to_Ranks(word);
    char num = d.charAt(d.length() - 3);
    String newNum = "";
    switch (num) {
    case '1': newNum = "First"; break;
    case '2': newNum = "Second"; break;
    case '3': newNum = "Third"; break;
    case '4': newNum = "Fourth"; break;
    case '5': newNum = "Fifth"; break;
    case '6': newNum = "Sixth"; break;
    case '7': newNum = "Seventh"; break;
    case '8': newNum = "Eighth"; break;
    case '9': newNum = "Ninth"; break;
    }
    if (d.length() == 4) { //tens
        if (d.charAt(0) == '1') { //teens
            switch (num) {
            case '0': newNum = "Tenth"; break;
            case '1': newNum = "Eleventh"; break;
            case '2': newNum = "Twelfth"; break;
            case '3': newNum = "Thirteenth"; break;
            case '4': newNum = "Fourteenth"; break;
            case '5': newNum = "Fifteenth"; break;
            case '6': newNum = "Sixteenth"; break;
            case '7': newNum = "Seventeenth"; break;
            case '8': newNum = "Eighteenth"; break;
            case '9': newNum = "Nineteenth"; break;
            }
        } else {
            switch (d.charAt(0)) {
            case '2': newNum = "Twenty" + newNum; break;
            case '3': newNum = "Thirty" + newNum; break;
            case '4': newNum = "Fourty" + newNum; break;
            case '5': newNum = "Fifty" + newNum; break;
            case '6': newNum = "Sixty" + newNum; break;
            case '7': newNum = "Seventy" + newNum; break;
            case '8': newNum = "Eighty" + newNum; break;
            case '9': newNum = "Ninety" + newNum; break;
            }
        }
    }
    return newNum;
}


    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) 
            System.err.println(convertNumberToWord((i)));
     
         
    }
}