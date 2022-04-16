package com.downvoteit.javaalgorithms.problems.easy.twopointers;

// https://leetcode.com/problems/valid-palindrome/
public class ValidPalindrome {
  public boolean isPalindrome(String s) {
    return new V1().isPalindrome(s);
  }

  // time O(log n) space O(1)
  static class V1 extends ValidPalindrome {
    public boolean isPalindrome(String s) {
      s = s.replaceAll("[^\\p{Alnum}]", "").toLowerCase();

      for (int left = 0; left < s.length() >>> 1; left++)
        if (s.charAt(left) != s.charAt(s.length() - left - 1)) {
          return false;
        }

      return true;
    }
  }
}
