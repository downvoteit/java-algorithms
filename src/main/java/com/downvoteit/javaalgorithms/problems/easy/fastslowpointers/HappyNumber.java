package com.downvoteit.javaalgorithms.problems.easy.fastslowpointers;

// https://leetcode.com/problems/happy-number/
public class HappyNumber {
  public boolean isHappy(int n) {
    return new V1().isHappy(n);
  }

  // time O(log n) space O(1)
  static class V1 extends HappyNumber {
    public boolean isHappy(int n) {
      int slow = n, fast = n;

      do {
        slow = square(slow);
        fast = square(square(fast));

        System.out.println(slow + " " + fast);
      } while (slow != fast);

      System.out.println(slow);

      return slow == 1;
    }

    private int square(int n) {
      int sum = 0, digit;

      while (n > 0) {
        digit = n % 10;
        sum += digit * digit;
        n /= 10;
      }

      return sum;
    }
  }
}
