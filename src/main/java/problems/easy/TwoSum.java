package problems.easy;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/two-sum/
public class TwoSum {
  public int[] twoSum(int[] nums, int target) {
    return new V1().twoSum(nums, target);
  }

  //  time O(n) space O(n)
  static class V1 extends TwoSum {
    public int[] twoSum(int[] nums, int target) {
      Map<Integer, Integer> map = new HashMap<>();

      for (int r = 0; r < nums.length; r++) {
        if (map.containsKey(target - nums[r])) {
          return new int[] {map.get(target - nums[r]), r};
        } else {
          map.put(nums[r], r);
        }
      }

      return new int[] {-1, -1};
    }
  }
}
