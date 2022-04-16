package com.downvoteit.javaalgorithms.problems.easy.slidingwindow;

// https://leetcode.com/problems/maximum-difference-between-increasing-elements/
public class MaximumDifferenceBetweenIncreasingElements {
  public int maximumDifference(int[] nums) {
    return new V1().maximumDifference(nums);
  }

  // time O(n) space O(1)
  static class V1 extends MaximumDifferenceBetweenIncreasingElements {
    public int maximumDifference(int[] nums) {
      int winStart = 0, max = -1;

      for (int winEnd = 1; winEnd < nums.length; winEnd++) {
        if (nums[winStart] > nums[winEnd]) {
          winStart = winEnd;
        }

        max = Math.max(max, nums[winEnd] - nums[winStart]);
      }

      return max == 0 ? -1 : max;
    }
  }
}
