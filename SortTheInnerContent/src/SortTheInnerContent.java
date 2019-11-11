import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * #Srot the inner ctnnoet in dsnnieedcg oredr
 *
 * You have to sort the inner content of every word of a string in descending order.
 * The inner content is the content of a word without first and the last char.
 *
 * Some examples:
 *
 * "sort the inner content in descending order" -> "srot the inner ctonnet in dsnnieedcg oredr"
 * "wait for me" -> "wiat for me"
 * "this kata is easy" -> "tihs ktaa is esay"
 *
 * The string will never be null and will never be empty.
 * It will contain only lowercase-letters and whitespaces.
 *
 * In C++ the string is always 0-terminated.
 *
 *
 * Have fun coding it and please don't forget to vote and rank this kata! :-)
 *
 * I have also created other katas. Take a look if you enjoyed this kata!
 */

public class SortTheInnerContent {

  public static void main(String[] args) {

    System.out.println(sortTheInnerContents("sort the inner content a descending order"));
    System.out.println(sortTheInnerContents("wait for me"));
    System.out.println(sortTheInnerContents("this kata is easy"));
  }

  public static String sortTheInnerContents(String words) {

    List<String> splittedWords = Arrays.asList(words.split(" "));
    return splittedWords.stream()
        .map(word -> {
          if (word.length() > 3) {
            String firstLetter = word.substring(0, 1);
            String lastLetter = word.substring(word.length() - 1);
            char[] sortedString = word.substring(1, word.length() - 1).toCharArray();
            Arrays.sort(sortedString);
            StringBuilder reversedInnerWord = new StringBuilder();
            for (int i = sortedString.length - 1; i >= 0; i--) {
              reversedInnerWord.append(sortedString[i]);
            }
            return firstLetter + reversedInnerWord.toString() + lastLetter;
          }
          return word;
        })
        .collect(Collectors.joining(" "));
  }
}
