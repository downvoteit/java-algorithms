package implementations.searching;

// https://www.geeksforgeeks.org/binary-search/
public class RecursiveBinarySearch {
  public int search(int[] nums, int low, int high, int target) {
    if (high >= low) {
      int mid = (low + high) >>> 1;

      if (nums[mid] == target) return mid;

      if (nums[mid] < target) {
        return search(nums, mid + 1, high, target);
      } else {
        return search(nums, low, mid - 1, target);
      }
    }

    return -(low + 1);
  }
}
