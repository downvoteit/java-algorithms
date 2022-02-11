package algorithms.easy;

import java.util.Arrays;

public class CountingBits {
  public int[] countBits(int n) {
    return new V4().countBits(n);
  }

  static class V4 extends CountingBits {
    // arrays O(n) space O(1)
    public int[] countBits(int num) {
      int[] arr = new int[num + 1];

      for (int i = 1; i <= num; ++i) {
        arr[i] = arr[i & (i - 1)] + 1;
      }

      System.out.println(Arrays.toString(arr));

      return arr;
    }
  }

  static class V3 extends CountingBits {
    // arrays bit masking time O(n^2) space O(1)
    public int[] countBits(int n) {
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
  }

  static class V2 extends CountingBits {
    // arrays time O(n) space O(1)
    public int[] countBits(int n) {
      int[] arr = new int[n + 1];

      for (int i = 0; i <= n; i++) {
        arr[i] = Integer.bitCount(i);
      }

      return arr;
    }
  }

  static class V1 extends CountingBits {
    // arrays strings time O(n^2) space O(1)
    public int[] countBits(int n) {
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
}
