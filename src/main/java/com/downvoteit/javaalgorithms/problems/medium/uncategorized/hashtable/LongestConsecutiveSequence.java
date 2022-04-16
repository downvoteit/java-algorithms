package com.downvoteit.javaalgorithms.problems.medium.uncategorized.hashtable;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/longest-consecutive-sequence/
public class LongestConsecutiveSequence {
  public int longestConsecutive(int[] nums) {
    return new V1().longestConsecutive(nums);
  }

  // time O(n*k) space O(n)
  static class V1 extends LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
      int longest = 0;

      Set<Integer> entries = new HashSet<>();

      for (int num : nums) {
        entries.add(num);
      }

      for (int entry : entries) {
        if (!entries.contains(entry - 1)) {
          int len = 0;

          while (entries.contains(entry + len)) {
            len++;
          }

          if (len > longest) {
            longest = len;
          }
        }
      }

      return longest;
    }
  }
}
