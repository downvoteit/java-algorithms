package com.downvoteit.javaalgorithms.problems.easy.twopointers;

// https://leetcode.com/problems/backspace-string-compare/
public class BackspaceStringCompare {
  public boolean backspaceCompare(String s, String t) {
    return new V2().backspaceCompare(s, t);
  }

  // time O(n) space O(1) allegedly
  static class V2 extends BackspaceStringCompare {
    public boolean backspaceCompare(String s, String t) {
      short skipS = 0, skipT = 0;
      for (short i = ((short) (s.length() - 1)), j = ((short) (t.length() - 1));
          i >= 0 || j >= 0;
          i--, j--) {
        while (i >= 0)
          if (s.charAt(i) == '#') {
            skipS++;
            i--;
          } else if (skipS > 0) {
            skipS--;
            i--;
          } else break;
        while (j >= 0)
          if (t.charAt(j) == '#') {
            skipT++;
            j--;
          } else if (skipT > 0) {
            skipT--;
            j--;
          } else break;
        if (i >= 0 && j >= 0 && s.charAt(i) != t.charAt(j)) return false;
        if ((i >= 0) != (j >= 0)) return false;
      }

      return true;
    }
  }

  // time O(n) space O(n)
  static class V1 extends BackspaceStringCompare {
    public boolean backspaceCompare(String s, String t) {
      return backspace(s).equals(backspace(t));
    }

    private String backspace(String s) {
      StringBuilder ss = new StringBuilder(32);

      for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);

        if (c != '#') ss.append(c);

        if (ss.length() > 0 && c == '#') {
          ss.deleteCharAt(ss.length() - 1);
        }
      }

      return ss.toString();
    }
  }
}
