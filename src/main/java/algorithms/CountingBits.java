package algorithms;

public class CountingBits {
  public int[] countBits(int n) {
    return countBitsV2(n);
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
