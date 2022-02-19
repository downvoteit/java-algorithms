package problems.easy;

// https://leetcode.com/problems/single-number/
public class SingleNumber {
  public int singleNumber(int[] nums) {
    return new V1().singleNumber(nums);
  }

  // time O(1) space O(1)
  static class V1 extends SingleNumber {
    public int singleNumber(int[] nums) {
      int num = 0;

      for (int value : nums) {
        num = num ^ value;
      }

      return num;
    }
  }
}
