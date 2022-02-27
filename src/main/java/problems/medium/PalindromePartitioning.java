package problems.medium;

import java.util.List;

// https://leetcode.com/problems/palindrome-partitioning/
public class PalindromePartitioning {
  public List<List<String>> partition(String s) {
    return new V1().partition(s);
  }

  static class V1 extends PalindromePartitioning {
    public List<List<String>> partition(String s) {
      return null;
    }
  }
}
