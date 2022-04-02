package problems.easy.twopointers;

// https://leetcode.com/problems/valid-palindrome-ii/
public class ValidPalindromeII {
  public boolean validPalindrome(String s) {
    return new V1().validPalindrome(s);
  }

  // time O(n) space O(n)
  static class V1 extends ValidPalindromeII {
    // case aydmda
    public boolean validPalindrome(String s) {
      for (int left = 0; left < s.length() >>> 1; left++) {
        int right = s.length() - left - 1;

        System.out.println(s.charAt(left) + " " + s.charAt(right) + " " + left + " " + right);

        // pass a a with range at 0-5
        // fail y d with range at 1-4
        if (s.charAt(left) != s.charAt(right)) {
          // left with [a]ydmda[a]
          // split at 2-5 [ay]dmd[a] and at 1-3 [a]ydm[da]
          // note the short-circuit and index-exclusive
          return isSame(s.substring(left + 1, right + 1)) || isSame(s.substring(left, right));
        }
      }

      return true;
    }

    private boolean isSame(String s) {
      for (int left = 0; left < s.length() >>> 1; left++)
        if (s.charAt(left) != s.charAt(s.length() - left - 1)) {
          return false;
        }

      return true;
    }
  }
}
