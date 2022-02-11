package algorithms.easy;

import java.util.*;

public class ContainsDuplicates {
  public boolean containsDuplicate(int[] nums) {
    return new V4().containsDuplicate(nums);
  }

  static class V1 extends ContainsDuplicates {
    // map time O(n) space O(n)
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

  static class V3 extends ContainsDuplicates {
    // sets binary search time O(n) space O(n)
    public boolean containsDuplicate(int[] nums) {
      Set<Integer> set = new HashSet<>();

      Arrays.sort(nums);

      for (int num : nums) {
        if (!set.add(num)) return true;
      }

      return false;
    }
  }

  static class V2 extends ContainsDuplicates {
    // binary search time O(n) space O(n)
    public boolean containsDuplicate(int[] nums) {
      Arrays.sort(nums);

      for (int r = 0; r < nums.length; r++) {
        if (Arrays.binarySearch(nums, r + 1, nums.length, nums[r]) >= 0) return true;
      }

      return false;
    }
  }

  static class V4 extends ContainsDuplicates {
    // arrays time O(n) space O(n)
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
