package problems.easy;

import java.util.*;

// https://leetcode.com/problems/contains-duplicate/
public class ContainsDuplicates {
  public boolean containsDuplicate(int[] nums) {
    return new V4().containsDuplicate(nums);
  }

  // time O(n) space O(n)
  static class V1 extends ContainsDuplicates {
    public boolean containsDuplicate(int[] nums) {
      Map<Integer, Integer> map = new HashMap<>();

      Arrays.sort(nums);

      for (int num : nums) {
        if (map.containsKey(num)) return true;

        map.put(num, 1);
      }

      return false;
    }
  }

  // time O(n) space O(n)
  static class V3 extends ContainsDuplicates {
    public boolean containsDuplicate(int[] nums) {
      Set<Integer> set = new HashSet<>();

      Arrays.sort(nums);

      for (int num : nums) {
        if (!set.add(num)) return true;
      }

      return false;
    }
  }

  // time O(n) space O(n)
  static class V2 extends ContainsDuplicates {
    public boolean containsDuplicate(int[] nums) {
      Arrays.sort(nums);

      for (int r = 0; r < nums.length; r++) {
        if (Arrays.binarySearch(nums, r + 1, nums.length, nums[r]) >= 0) return true;
      }

      return false;
    }
  }

  // time O(n) space O(n)
  static class V4 extends ContainsDuplicates {
    public boolean containsDuplicate(int[] nums) {
      Set<Integer> set = new HashSet<>();
      int buffer = 10;

      for (int x = 0; x < nums.length; x += buffer) {
        int len = Math.min(x + buffer, nums.length);

        Arrays.sort(nums, x, len);

        for (int num : Arrays.copyOfRange(nums, x, len)) {
          if (!set.add(num)) return true;
        }
      }

      return false;
    }
  }
}
