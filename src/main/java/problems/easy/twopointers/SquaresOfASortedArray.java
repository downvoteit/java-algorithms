package problems.easy.twopointers;

import java.util.Arrays;

// https://leetcode.com/problems/squares-of-a-sorted-array/
public class SquaresOfASortedArray {
  public int[] sortedSquares(int[] nums) {
    return new V2().sortedSquares(nums);
  }

  // time O(n) space O(n)
  static class V2 extends SquaresOfASortedArray {
    public int[] sortedSquares(int[] nums) {
      int[] squared = new int[nums.length];
      int squaredIndex = squared.length - 1;

      int left = 0, right = nums.length - 1;
      while (left <= right) {
        int x = nums[left] * nums[left];
        int y = nums[right] * nums[right];

        if (x > y) {
          squared[squaredIndex--] = x;
          left++;
        } else {
          squared[squaredIndex--] = y;
          right--;
        }
      }

      return squared;
    }
  }

  // time O(n*log n) space O(1)
  static class V1 extends SquaresOfASortedArray {
    public int[] sortedSquares(int[] nums) {
      for (int left = 0; left < (nums.length + 1) >>> 1; left++) {
        int right = nums.length - left - 1;

        int x = nums[left] * nums[left];
        int y = nums[right] * nums[right];

        nums[left] = x;
        nums[right] = y;
      }

      Arrays.sort(nums);

      return nums;
    }
  }
}
