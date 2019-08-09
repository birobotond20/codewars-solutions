import java.util.Arrays;

/**
 * There is an array with some numbers. All numbers are equal except for one. Try to find it!
 * <p>
 * Kata.findUniq(new double[]{ 1, 1, 1, 2, 1, 1 }); // => 2
 * Kata.findUniq(new double[]{ 0, 0, 0.55, 0, 0 }); // => 0.55
 * <p>
 * It’s guaranteed that array contains more than 3 numbers.
 * <p>
 * The tests contain some very huge arrays, so think about performance.
 * <p>
 * This is the first kata in series:
 * <p>
 * Find the unique number (this kata) (https://www.codewars.com/kata/585d7d5adb20cf33cb000235)
 * Find the unique string (https://www.codewars.com/kata/585d8c8a28bc7403ea0000c3)
 * Find The Unique (https://www.codewars.com/kata/5862e0db4f7ab47bed0000e5)
 */

public class FindTheUniqueNumber {

  public static void main(String[] args) {
    System.out.println(findUniq(new double[]{1, 1, 1, 2, 1, 1}));
    System.out.println(findUniq(new double[]{0, 0, 0.55, 0, 0}));
  }

  // My solution for finding the unique number, when more than two different numbers are present
  // in the array (I have misread the description: it says that all numbers are equal, except for
  // one.
  /*private static double findUniq(double[] arr) {
    Map<Double, Integer> numberCounts = new HashMap<>();
    for (double d : arr) {
      if (numberCounts.containsKey(d)) {
        numberCounts.put(d, numberCounts.get(d) + 1);
      } else {
        numberCounts.put(d, 1);
      }
    }

    double unique = -1;
    for (Map.Entry entry : numberCounts.entrySet()) {
      if (entry.getValue().equals(1)) {
        unique = (double) (entry.getKey());
      }
    }
    return unique;
  }*/

  private static double findUniq(double[] arr) {
    Arrays.sort(arr);
    return arr[0] == arr[1] ? arr[arr.length - 1] : arr[0];
  }
}
