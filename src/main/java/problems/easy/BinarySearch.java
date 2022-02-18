package problems.easy;

public class BinarySearch {
  public int search(int[] nums, int target) {
    return new V1().search(nums, target);
  }

  // time O(log n) space O(1)
  static class V1 {
    public int search(int[] nums, int target) {
      int left = 0, right = nums.length - 1;

      while (left <= right) {
        int mid = (left + right) >>> 1;

        if (nums[mid] == target) {
          return mid;
        } else if (nums[mid] < target) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }

      return -1;
    }
  }
}
