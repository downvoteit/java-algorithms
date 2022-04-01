package problems.medium.modifiedbinarysearch;

// https://leetcode.com/problems/find-peak-element/
public class FindPeakElement {
  public int findPeakElement(int[] nums) {
    return new V2().findPeakElement(nums);
  }

  // time O(log n) space O(1)
  // bitonic array
  static class V2 extends FindPeakElement {
    public int findPeakElement(int[] nums) {
      int left = 0, right = nums.length - 1;

      while (left < right) {
        int mid = left + right >>> 1;

        System.out.println(left + " " + mid + " " + right);

        if (nums[mid] > nums[mid + 1]) {
          right = mid;
        } else {
          left = mid + 1;
        }
      }

      return left;
    }
  }

  // time O(log n) space O(1)
  static class V1 extends FindPeakElement {
    public int findPeakElement(int[] nums) {
      if (nums.length == 1) return 0;
      if (nums.length == 2) return (nums[0] > nums[1]) ? 0 : 1;

      int left = 0, right = nums.length - 1;

      while (left < right) {
        int mid = left + right >>> 1;

        if (mid - 1 < 0) return 0;

        if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
          return mid;
        } else if (nums[mid + 1] > nums[mid] && mid + 1 == nums.length - 1) {
          return mid + 1;
        } else if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]
            || nums[mid] < nums[mid + 1] && nums[mid] > nums[mid - 1]) {
          left++;
        } else if (nums[mid] > nums[mid + 1] && nums[mid] < nums[mid - 1]
            || nums[mid] < nums[mid + 1] && nums[mid] < nums[mid - 1]) {
          right--;
        }

        System.out.println("mid: " + mid + ", val: " + nums[mid]);
      }

      return 0;
    }
  }
}
