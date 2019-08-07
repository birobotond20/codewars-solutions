/**
 * In a factory a printer prints labels for boxes. For one kind of boxes the printer has to use
 * colors which, for the sake of simplicity, are named with letters from a to m.
 *
 * The colors used by the printer are recorded in a control string. For example a "good" control
 * string would be aaabbbbhaijjjm meaning that the printer used three times color a, four times
 * color b, one time color h then one time color a...
 *
 * Sometimes there are problems: lack of colors, technical malfunction and a "bad" control string
 * is produced e.g. aaaxbbbbyyhwawiwjjjwwm with letters not from a to m.
 *
 * You have to write a function printer_error which given a string will output the error rate of
 * the printer as a string representing a rational whose numerator is the number of errors and
 * the denominator the length of the control string. Don't reduce this fraction to a simpler
 * expression.
 *
 * The string has a length greater or equal to one and contains only letters from ato z.
 *
 * #Examples:
 *
 * s="aaabbbbhaijjjm"
 * error_printer(s) => "0/14"
 *
 * s="aaaxbbbbyyhwawiwjjjwwm"
 * error_printer(s) => "8/22"
 */

public class PrinterErrors {

  public static void main(String[] args){
    System.out.println(printerError("aaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbmmmmmmmmmmmmmmmmmmmxyz"));
  }

  // My solution
  /*public static String printerError(String s) {
    int controlStringLength = s.length();
    int numberOfErrors = 0;
    for (char currentChar : s.toCharArray()) {
      if (currentChar > 'm'){
        numberOfErrors++;
      }
    }
    return numberOfErrors + "/" + controlStringLength;
  }*/

  // Clever solution 1
  /*public static String printerError(String s){
    return s.replaceAll("[a-m]", "").length() + "/" + s.length();
  }*/

  //Clever solution 2
  public static String printerError(String s){
    return s.chars().filter(c -> c > 'm').count() + "/" + s.length();
  }
}
