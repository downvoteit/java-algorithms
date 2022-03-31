package problems.easy.twopointers;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/two-sum/
public class TwoSum {
  public int[] twoSum(int[] nums, int target) {
    return new V2().twoSum(nums, target);
  }

  // time O(n) space O(1)
  // two pointers, suitable only for a sorted array
  static class V3 extends TwoSum {
    public int[] twoSum(int[] nums, int target) {
      int left = 0, right = nums.length - 1;

      while (left < right) {
        int curSum = nums[left] + nums[right];

        if (curSum == target) return new int[] {left, right};

        if (target > curSum) left++;
        else right--;
      }

      return new int[] {-1, -1};
    }
  }

  // time O(n^2) space O(1)
  // brute-force
  static class V2 extends TwoSum {
    public int[] twoSum(int[] nums, int target) {
      for (int i = 0; i < nums.length; i++)
        for (int j = i + 1; j < nums.length; j++)
          if (nums[i] + nums[j] == target) {
            return new int[] {i, j};
          }

      return new int[] {-1, -1};
    }
  }

  // time O(n) space O(n)
  // hashtable
  static class V1 extends TwoSum {
    public int[] twoSum(int[] nums, int target) {
      Map<Integer, Integer> map = new HashMap<>();

      for (int i = 0; i < nums.length; i++)
        if (map.containsKey(target - nums[i])) {
          return new int[] {map.get(target - nums[i]), i};
        } else {
          map.put(nums[i], i);
        }

      return new int[] {-1, -1};
    }
  }
}
