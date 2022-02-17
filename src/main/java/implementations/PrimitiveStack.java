package implementations;

import java.util.Arrays;

// LIFO
public class PrimitiveStack {
  public static void main(String[] args) {
    int index = -1;
    int[] entries = new int[10];

    for (int i = 1; i <= 3; i++) {
      entries[++index] = i;

      System.out.println(i + " " + Arrays.toString(entries));
    }

    System.out.println();

    while (index >= 0) {
      int temp = entries[index];

      entries[index--] = 0;

      System.out.println(temp + " " + Arrays.toString(entries));
    }
  }
}
