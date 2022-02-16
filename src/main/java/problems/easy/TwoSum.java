package problems.easy;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
  public int[] twoSum(int[] nums, int target) {
    return new V2().twoSum(nums, target);
  }

  //  time O(n) space O(n)
  static class V2 extends TwoSum {
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

  // time O(n) space O(1)
  static class V1 extends TwoSum {
    public int[] twoSum(int[] nums, int target) { // unpredictable for unsorted arrays
      int left = 0, right = nums.length - 1;

      while (left < right) {
        int num = nums[left] + nums[right];

        if (num == target) return new int[] {left, right};

        if (target > num) left++;
        else right--;
      }

      return new int[] {-1, -1};
    }
  }
}
