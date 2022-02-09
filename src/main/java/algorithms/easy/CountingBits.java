package algorithms.easy;

import java.util.Arrays;

public class CountingBits {
  public int[] countBits(int n) {
    return countBitsV4(n);
  }

  private int[] countBitsV4(int num) {
    int[] arr = new int[num + 1];

    for (int i = 1; i <= num; ++i) {
      arr[i] = arr[i & (i - 1)] + 1;
    }

    System.out.println(Arrays.toString(arr));

    return arr;
  }

  private int[] countBitsV3(int n) {
    int[] arr = new int[n + 1];

    for (int i = 0; i <= n; i++) {
      for (int j = 31; j >= 0; j--) {
        int mask = i & (1 << j);
        if (mask != 0) {
          arr[i] = arr[i] + 1;
        }
      }
    }

    return arr;
  }

  private int[] countBitsV2(int n) {
    int[] arr = new int[n + 1];

    for (int i = 0; i <= n; i++) {
      arr[i] = Integer.bitCount(i);
    }

    return arr;
  }

  private int[] countBitsV1(int n) {
    int[] arr = new int[n + 1];

    for (int i = 0; i <= n; i++) {
      int c = 0;
      for (char value : Integer.toBinaryString(i).toCharArray()) {
        if (value == '1') c++;
      }

      arr[i] = c;
    }

    return arr;
  }
}
