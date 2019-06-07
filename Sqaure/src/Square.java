public class Square {

  public static void main(String[] args) {

    System.out.println("-1: " + isSquare(-1));
    System.out.println("0: " + isSquare(0));
    System.out.println("3: " + isSquare(3));
    System.out.println("4: " + isSquare(4));
    System.out.println("25: " + isSquare(25));
    System.out.println("26: " + isSquare(26));
    System.out.println("30498387: " + isSquare(30498387));
  }

  private static boolean isSquare(int number){
    int squareRoot = (int) (Math.sqrt(number));
    return (squareRoot * squareRoot) == number;
  }

  /*private static boolean isSquare(int number){
    return Math.sqrt(number) % 1 == 0;
  }*/
}
