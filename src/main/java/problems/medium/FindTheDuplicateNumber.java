package problems.medium;

// https://leetcode.com/problems/find-the-duplicate-number/
public class FindTheDuplicateNumber {
  public int findDuplicate(int[] nums) {
    return new V2().findDuplicate(nums);
  }

  static class V2 extends FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
      return 0;
    }
  }

  // time O(n^2) space O(1)
  // brute-force, expensive nested loops
  // Time Limit Exceeded
  static class V1 extends FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
      for (int i = 0; i < nums.length; i++) {
        for (int j = i + 1; j < nums.length; j++) {
          if (nums[i] == nums[j]) return nums[i];
        }
      }

      return 0;
    }
  }
}
