package problems.hard;

public class LongestSubsequenceRepeatedKTimes {
  public String longestSubsequenceRepeatedK(String s, int k) {
    return new V1().longestSubsequenceRepeatedK(s, k);
  }

  static class V1 extends LongestSubsequenceRepeatedKTimes {
    // backtracking
    public String longestSubsequenceRepeatedK(String s, int k) {
      return null;
    }

    private boolean isValidState() {
      return false;
    }

    private char[] getCandidates() {
      return null;
    }

    private void search() {}
  }
}
