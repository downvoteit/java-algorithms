package com.downvoteit.javaalgorithms.problems.medium.dynamicprogramming;

import java.util.Arrays;

// https://leetcode.com/problems/house-robber/
public class HouseRobber {
  public int rob(int[] nums) {
    return new V4().rob(nums);
  }

  // time O(n) space O(1)
  static class V4 extends HouseRobber {
    public int rob(int[] nums) {
      if (nums.length == 0) return 0;

      int n1 = 0, n2 = nums[0], n3;
      for (int i = 1; i < nums.length; i++) {
        n3 = Math.max(n1 + nums[i], n2);
        n1 = n2;
        n2 = n3;
      }

      return n2;
    }
  }

  // time O(n) space O(n)
  static class V3 extends HouseRobber {
    public int rob(int[] nums) {
      if (nums.length == 0) return 0;

      int[] mem = new int[nums.length + 1];
      mem[1] = nums[0];

      for (int i = 1; i < nums.length; i++) {
        mem[i + 1] = Math.max(nums[i] + mem[i - 1], mem[i]);
      }

      System.out.println(Arrays.toString(mem));

      return mem[nums.length];
    }
  }

  // time O(2^n) space O(n)
  static class V2 extends HouseRobber {
    public int rob(int[] nums) {
      int[] mem = new int[nums.length];

      return robRecursive(nums, mem, 0);
    }

    private int robRecursive(int[] nums, int[] mem, int index) {
      if (index >= nums.length) return 0;

      if (mem[index] == 0) {
        int zeroIndexed = nums[index] + robRecursive(nums, mem, index + 2);
        int oneIndexed = robRecursive(nums, mem, index + 1);

        mem[index] = Math.max(zeroIndexed, oneIndexed);
      }

      return mem[index];
    }
  }

  // time O(2^n) space O(n)
  static class V1 extends HouseRobber {
    public int rob(int[] nums) {
      return robRecursive(nums, 0);
    }

    private int robRecursive(int[] nums, int index) {
      if (index >= nums.length) return 0;

      int zeroIndexed = nums[index] + robRecursive(nums, index + 2);
      int oneIndexed = robRecursive(nums, index + 1);

      return Math.max(zeroIndexed, oneIndexed);
    }
  }
}
