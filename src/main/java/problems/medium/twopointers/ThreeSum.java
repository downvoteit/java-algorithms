package problems.medium.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/3sum/
public class ThreeSum {
  public List<List<Integer>> threeSum(int[] nums) {
    return new V2().threeSum(nums);
  }

  // time O(n^2) space O(n)
  // two-pointers + binary search refactor
  static class V2 extends ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
      Arrays.sort(nums);
      List<List<Integer>> triplets = new ArrayList<>();

      for (int left = 0; left < nums.length; left++) {
        if (left > 0 && nums[left - 1] == nums[left]) {
          continue;
        }

        int mid = left + 1, right = nums.length - 1;

        while (mid < right) {
          int curSum = nums[left] + nums[mid] + nums[right];

          if (curSum > 0) {
            right--;
          } else if (curSum < 0) {
            mid++;
          } else {
            triplets.add(Arrays.asList(nums[mid++], nums[left], nums[right]));

            while (mid < right && nums[mid] == nums[mid - 1]) {
              mid++;
            }
          }
        }
      }

      for (List<Integer> x : triplets) x.sort(Integer::compareTo);

      return triplets;
    }
  }

  // time O(n^2) space O(n)
  // two-pointers + binary search
  static class V1 {
    public List<List<Integer>> threeSum(int[] nums) {
      Arrays.sort(nums);
      List<List<Integer>> triplets = new ArrayList<>();

      for (int left = 0; left < nums.length; left++) {
        if (left > 0 && nums[left - 1] == nums[left]) {
          continue;
        }
        find(nums, -1 * nums[left], left + 1, triplets);
      }

      for (List<Integer> x : triplets) x.sort(Integer::compareTo);

      return triplets;
    }

    // x + y + z = 0
    // y + z = -x
    // x = -1 * (y + z)
    private void find(int[] nums, int x, int left, List<List<Integer>> triplets) {
      int right = nums.length - 1;

      while (left < right) {
        int curSum = nums[left] + nums[right];

        if (curSum == x) {
          triplets.add(Arrays.asList(-1 * x, nums[left++], nums[right--]));

          while (left < right && nums[left] == nums[left - 1]) {
            left++;
          }
          while (left < right && nums[right] == nums[right + 1]) {
            right--;
          }
        } else if (x > curSum) {
          left++;
        } else {
          right--;
        }
      }
    }
  }
}
