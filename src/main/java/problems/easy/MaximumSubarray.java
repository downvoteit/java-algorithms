package problems.easy;

public class MaximumSubarray {

  public int maxSubArray(int[] nums) {
    return new V1().maxSubArray(nums);
  }

  static class V1 {
    public int maxSubArray(int[] nums) {
      int sum = nums[0], temp = 0;

      for (int num : nums) {
        if (temp < 0) {
          temp = 0;
        }

        temp += num;
        sum = Math.max(sum, temp);
      }

      return sum;
    }
  }
}
