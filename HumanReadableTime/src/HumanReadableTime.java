/**
 * Write a function, which takes a non-negative integer (seconds) as input and returns the time
 * in a human-readable format (HH:MM:SS)
 *
 *     HH = hours, padded to 2 digits, range: 00 - 99
 *     MM = minutes, padded to 2 digits, range: 00 - 59
 *     SS = seconds, padded to 2 digits, range: 00 - 59
 *
 * The maximum time never exceeds 359999 (99:59:59)
 */

public class HumanReadableTime {

  public static void main(String[] args) {
    System.out.println(makeReadable(0));
    System.out.println(makeReadable(5));
    System.out.println(makeReadable(60));
    System.out.println(makeReadable(86399));
    System.out.println(makeReadable(359999));
  }

  // My solution
  /*private static String makeReadable(int seconds) {
    int hours = 0;
    int min = 0;
    while (seconds > 59) {
      min++;
      while (min > 59) {
        hours++;
        min = min - 60;
      }
      seconds = seconds - 60;
    }
    return String.format("%02d", hours) + ":" + String.format("%02d", min) + ":" + String.format(
            "%02d", seconds);
  }*/

  // Clever solution
  private static String makeReadable(int seconds){
    return String.format("%02d:%02d:%02d", seconds / 3600, (seconds / 60) % 60, seconds % 60);
  }
}
