package algorithms.medium;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
  public int longestConsecutive(int[] nums) {
    return longestConsecutiveV1(nums);
  }

  // time O(n*k) space O(n) check for previous/next elements
  private int longestConsecutiveV1(int[] nums) {
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
