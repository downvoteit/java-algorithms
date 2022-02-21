package problems.hard;

import java.util.*;

// https://leetcode.com/problems/longest-subsequence-repeated-k-times/
public class LongestSubsequenceRepeatedKTimes {
  public String longestSubsequenceRepeatedK(String s, int k) {
    return new V1().longestSubsequenceRepeatedK(s, k);
  }

  // backtracking, brute-force
  static class V1 extends LongestSubsequenceRepeatedKTimes {
    public String longestSubsequenceRepeatedK(String s, int n) {
      List<String> subSequences = new ArrayList<>();

      // find possible candidates
      Map<Character, Integer> candidates = new HashMap<>();
      for (int i = 0; i < s.length(); i++)
        if (candidates.containsKey(s.charAt(i))) {
          candidates.replace(s.charAt(i), candidates.get(s.charAt(i)) + 1);
        } else {
          candidates.put(s.charAt(i), 1);
        }

      // filter candidates
      Map<Integer, Character> candidateIndexes = new TreeMap<>();
      for (Character c : candidates.keySet())
        if (candidates.get(c) >= n) {
          candidateIndexes.put(s.indexOf(c), c);
        }

      System.out.format("%s %n%s%n%n", candidates, candidateIndexes);

      // construct all possible combinations
      // n=3,r=2
      // l=let,lte
      // e=elt,etl
      // t=tel,tle
      List<String> permutations = new ArrayList<>();
      for (int i = 0; i < candidateIndexes.size(); i++) {
        StringBuilder builder = new StringBuilder();

        for (int j = i; j < candidateIndexes.size(); j++) {
          builder.append(candidateIndexes.get(j));
        }

        permutations.add(builder.toString());
      }

      System.out.println(permutations);

      Collections.sort(subSequences);

      if (!subSequences.isEmpty()) {
        return subSequences.get(0);
      }

      return "";
    }
  }
}
