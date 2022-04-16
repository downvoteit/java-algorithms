package com.downvoteit.javaalgorithms.problems.easy.twopointers;

// https://leetcode.com/problems/reverse-string/
public class ReverseString {
  public void reverseString(char[] s) {
    new V1().reverseString(s);
  }

  // time O(log n) space O(1)
  static class V1 extends ReverseString {
    public void reverseString(char[] s) {
      for (int left = 0; left < s.length >>> 1; left++) {
        int right = s.length - left - 1;

        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
      }
    }
  }
}
