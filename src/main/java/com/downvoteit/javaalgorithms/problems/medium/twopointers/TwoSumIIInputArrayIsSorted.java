package com.downvoteit.javaalgorithms.problems.medium.twopointers;

// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
public class TwoSumIIInputArrayIsSorted {
  public int[] twoSum(int[] nums, int target) {
    return new V1().twoSum(nums, target);
  }

  // time O(n) space O(1)
  static class V1 extends TwoSumIIInputArrayIsSorted {
    public int[] twoSum(int[] nums, int target) {
      int left = 0, right = nums.length - 1;

      while (left < right) {
        int num = nums[left] + nums[right];

        if (num == target) {
          return new int[] {left + 1, right + 1};
        } else if (num < target) {
          left++;
        } else {
          right--;
        }
      }

      return new int[] {-1, -1};
    }
  }
}
