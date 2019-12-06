/*
  Take the following IPv4 address: 128.32.10.1

  This address has 4 octets where each octet is a single byte (or 8 bits).

      1st octet 128 has the binary representation: 10000000
      2nd octet 32 has the binary representation: 00100000
      3rd octet 10 has the binary representation: 00001010
      4th octet 1 has the binary representation: 00000001

  So 128.32.10.1 == 10000000.00100000.00001010.00000001

  Because the above IP address has 32 bits, we can represent it as the unsigned 32 bit number: 2149583361

  Complete the function that takes an unsigned 32 bit number and returns a string representation of its IPv4 address.
  Examples

  2149583361 ==> "128.32.10.1"
  32         ==> "0.0.0.32"
  0          ==> "0.0.0.0"
 */

public class Main {

  public static void main(String[] args) {

    System.out.println(longToIP(12L)); // expected: 0.0.0.12
    System.out.println(longToIP(2154959208L)); // expected: 128.114.17.104
    System.out.println(longToIP(0)); // expected: 0.0.0.0
    System.out.println(longToIP(2149583361L)); // expected: 128.32.10.1
    System.out.println(longToIP(540791124L)); // expected: 32.59.209.84
  }

  private static String longToIP(long ip) {
    StringBuilder binaryRepresentation = new StringBuilder();
    long remainder;

    while (binaryRepresentation.length() != 32) {
      if (ip != 0) {
        remainder = ip % 2;
        binaryRepresentation.insert(0, remainder);
        ip = ip / 2;
      } else {
        binaryRepresentation.insert(0, "0");
      }
    }

    String binary = binaryRepresentation.toString();

    int power = 7;
    int currentNumber = 0;
    int[] numbersOfIpAddress = new int[4];
    for (int i = 0; i < binary.length(); i++) {
      if (binary.charAt(i) == '1') {
        currentNumber += Math.pow(2, power - (i % 8));
      }

      if (i > 0 && (i + 1) % 8 == 0) {
        numbersOfIpAddress[((i + 1) / 8) - 1] = currentNumber;
        currentNumber = 0;
      }
    }

    return String.format("%d.%d.%d.%d", numbersOfIpAddress[0], numbersOfIpAddress[1],
        numbersOfIpAddress[2], numbersOfIpAddress[3]);

    // others solution:
    // return String.format("%d.%d.%d.%d", ip>>>24, (ip>>16)&0xff, (ip>>8)&0xff, ip&0xff);
  }
}
