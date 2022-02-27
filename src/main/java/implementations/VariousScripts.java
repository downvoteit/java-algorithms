package implementations;

public class VariousScripts {
  public static void main(String[] args) {}

  public static String integerToNBitBinaryString(int num, int bitSize) {
    if (bitSize < 8) bitSize = 8;

    String x1 = Integer.toBinaryString(num);
    String x2 = "0".repeat(bitSize - x1.length()).concat(x1);
    StringBuilder x3 = new StringBuilder();

    for (int i = 0; i < x2.length(); i++) {
      if (i > 0 && i % 8 == 0) x3.append(" ");

      x3.append(x2.toCharArray()[i]);
    }

    return x3.toString();
  }
}
