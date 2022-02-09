package algorithms.easy;

public class ClimbingStairs {
  public int climbStairs(int n) {
    return climbStairsV1(n);
  }

  // recursion time O(n) space O(1)
  private int climbStairsV1(int n) {
    if (n < 2) return 1;

    int n1 = 1, n2 = 1, result = 0;
    for (int i = 2; i <= n; i++) {
      result = n1 + n2;

      n1 = n2;
      n2 = result;
    }

    return result;
  }
}
