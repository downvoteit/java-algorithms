package algorithms;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
  public int[] twoSum(int[] nums, int target) {
    return twoSumV2(nums, target);
  }

  // hash table time O(n) space O(n)
  private int[] twoSumV2(int[] nums, int target) {
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

  // two pointers time O(n) space O(1)
  private int[] twoSumV1(int[] nums, int target) { // unpredictable for unsorted arrays
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
