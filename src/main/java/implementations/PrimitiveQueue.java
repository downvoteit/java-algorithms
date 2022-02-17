package implementations;

import java.util.Arrays;

// FIFO
public class PrimitiveQueue {
  public static void main(String[] args) {
    int[] entries = new int[10];

    for (int i = 0; i < 3; i++) {
      entries[i] = i + 1;

      System.out.println((i + 1) + " " + Arrays.toString(entries));
    }

    System.out.println();

    for (int i = 0; i < entries.length; i++) {
      int temp = entries[i];
      if (temp == 0) continue;

      entries[i] = 0;

      System.out.println(temp + " " + Arrays.toString(entries));
    }
  }
}
