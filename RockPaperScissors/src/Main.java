import java.util.HashMap;
import java.util.Map;

public class Main {

  public static void main(String[] args) {

    System.out.println(rps("scissors", "paper"));
    System.out.println(rps("scissors", "rock"));
    System.out.println(rps("paper", "paper"));
  }

  private static String rps(String p1, String p2) {

    if (p1.equals(p2)) {
      return "Draw!";
    } else if (p1.equals("scissors")) {
      if (p2.equals("paper")) {
        return "Player 1 won!";
      } else {
        return "Player 2 won!";
      }
    } else if (p1.equals("paper")) {
      if (p2.equals("rock")) {
        return "Player 1 won!";
      } else {
        return "Player 2 won!";
      }
    } else {
      if (p2.equals("scissors")) {
        return "Player 1 won!";
      } else {
        return "Player 2 won!";
      }
    }
  }
}
