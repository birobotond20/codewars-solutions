import java.util.HashMap;
import java.util.Map;

/**
 * Count the number of Duplicates
 *
 * Write a function that will return the count of distinct case-insensitive alphabetic characters and numeric digits that occur more than once in the input string. The input string can be assumed to contain only alphabets (both uppercase and lowercase) and numeric digits.
 * Example
 *
 * "abcde" -> 0 # no characters repeats more than once
 * "aabbcde" -> 2 # 'a' and 'b'
 * "aabBcde" -> 2 # 'a' occurs twice and 'b' twice (`b` and `B`)
 * "indivisibility" -> 1 # 'i' occurs six times
 * "Indivisibilities" -> 2 # 'i' occurs seven times and 's' occurs twice
 * "aA11" -> 2 # 'a' and '1'
 * "ABBA" -> 2 # 'A' and 'B' each occur twice
 */

public class Main {

  public static void main(String[] args) {

  }

  public static int duplicateCount(String text) {
    if (text == null || text.isEmpty()){
      return 0;
    }

    int numberOfCharacterRepeats = 0;
    Map<Character, Integer> characterCount = new HashMap<>();

    text = text.toLowerCase();

    for (int i = 0; i < text.length(); i++){
      if (characterCount.containsKey(text.charAt(i))){
        characterCount.put(text.charAt(i), characterCount.get(text.charAt(i))+ 1);
      } else {
        characterCount.put(text.charAt(i), 0);
      }
    }

    for (Map.Entry<Character, Integer> entry : characterCount.entrySet()){
      if (entry.getValue() > 1){
        numberOfCharacterRepeats++;
      }
    }
    return numberOfCharacterRepeats;
  }
}
