package problems.medium;

// https://leetcode.com/problems/number-of-provinces/
public class NumberOfProvinces {
  public int findCircleNum(int[][] isConnected) {
    return new V1().findCircleNum(isConnected);
  }

  static class V1 extends NumberOfProvinces {
    private static int find(int[] rep, int v) {
      return 0;
    }
  }
}
