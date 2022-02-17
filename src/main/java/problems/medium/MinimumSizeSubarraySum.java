package problems.medium;

public class MinimumSizeSubarraySum {
  public int minSubArrayLen(int target, int[] nums) {
    return new V1().minSubArrayLen(target, nums);
  }

  // time O(m*n) space O(1)
  static class V1 {
    public int minSubArrayLen(int target, int[] nums) {
      int winStart = 0, winEnd, winSum = 0, minLen = Integer.MAX_VALUE;

      for (winEnd = 0; winEnd < nums.length; winEnd++) {
        winSum += nums[winEnd];

        while (winSum >= target) {
          minLen = Math.min(minLen, winEnd - winStart + 1);
          winSum -= nums[winStart];
          winStart++;
        }
      }

      return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
  }
}
