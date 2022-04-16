package com.downvoteit.javaalgorithms.problems.easy.unsolved;

// https://leetcode.com/problems/power-of-two/
public class PowerOfTwo {
  public boolean isPowerOfTwo(int n) {
    return new V1().isPowerOfTwo(n);
  }

  // time O(1) space O(1)
  static class V1 extends PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
      return n > 0 && (n & (n - 1)) == 0;
    }
  }
}
