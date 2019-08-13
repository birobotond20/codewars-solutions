import java.util.Stack;

/**
 * Your job is to create a calculator which evaluates expressions in Reverse Polish notation.
 * <p>
 * For example expression 5 1 2 + 4 * + 3 - (which is equivalent to 5 + ((1 + 2) * 4) - 3 in
 * normal notation) should evaluate to 14.
 * <p>
 * For your convenience, the input is formatted such that a space is provided between every token.
 * <p>
 * Empty expression should evaluate to 0.
 * <p>
 * Valid operations are +, -, *, /.
 * <p>
 * You may assume that there won't be exceptional situations (like stack underflow or division by
 * zero).
 */
public class ReversePolishNotationCalculator {

  public static void main(String[] args) {
    System.out.println(evaluate("5 1 2 + 4 * + 3 -"));
  }

  /*private static double evaluate(String expression) {
    List<Double> doubles = new ArrayList<>();
    if (expression.length() == 0){
      return 0;
    } else if (expression.length() == 1){
      return Double.parseDouble(expression);
    } else {
      List<String> expr = Arrays.asList(expression.split(" "));
      for (String s : expr) {
        if (s.matches("\\d") || s.matches("(\\d+.\\d+)")) {
          doubles.add(Double.parseDouble(s));
        } else if (s.equals("+")) {
          doubles.add(doubles.remove(doubles.size() - 2) + doubles.remove(doubles.size() - 1));
        } else if (s.equals("-")) {
          doubles.add(doubles.remove(doubles.size() - 2) - doubles.remove(doubles.size() - 1));
        } else if (s.equals("*")) {
          doubles.add(doubles.remove(doubles.size() - 2) * doubles.remove(doubles.size() - 1));
        } else if (s.equals("/")) {
          doubles.add(doubles.remove(doubles.size() - 2) / doubles.remove(doubles.size() - 1));
        }
      }
    }
    return doubles.get(0);
  }*/

  private static double evaluate(String expression) {
    Stack<Double> stack = new Stack<>();
    if (expression == null || expression.isEmpty()) {
      return 0;
    } else {
      String[] exprElements = expression.split(" ");
      for (String element : exprElements) {
        Double a, b;
        if (element.equals("+")) {
          stack.push(stack.pop() + stack.pop());
        } else if (element.equals("-")) {
          b = stack.pop();
          a = stack.pop();
          stack.push(a - b);
        } else if (element.equals("*")) {
          stack.push(stack.pop() * stack.pop());
        } else if (element.equals("/")) {
          b = stack.pop();
          a = stack.pop();
          stack.push(a / b);
        }
        else {
          stack.push(Double.parseDouble(element));
        }
      }
    }
    return stack.pop();
  }
}
