package problems.easy;

// https://leetcode.com/problems/missing-number/
public class MissingNumber {
  public int missingNumber(int[] nums) {
    return new V1().missingNumber(nums);
  }

  // time O(n) space O(1)
  static class V2 extends MissingNumber {
    // example {3, 0, 1}, 2
    // 3 ^ (0 ^ 0) ^ (1 ^ 1) ^ (2 ^ 3) =
    // 2 ^ (0 ^ 0) ^ (1 ^ 1) ^ (3 ^ 3) =
    // 2 ^ 0 ^ 0 ^ 0 =
    // 2
    public int missingNumber(int[] nums) {
      int num = nums.length;
      for (int i = 0; i < nums.length; i++) num ^= i ^ nums[i];

      return num;
    }
  }

  // time O(n) space O(1)
  static class V1 extends MissingNumber {
    public int missingNumber(int[] nums) {
      int x1 = 1, x2 = nums[0];
      int len = nums.length + 1;

      for (int i = 2; i < len; i++) {
        x1 = x1 ^ i;
      }

      for (int i = 1; i < len - 1; i++) {
        x2 = x2 ^ nums[i];
      }

      return x1 ^ x2;
    }
  }
}
