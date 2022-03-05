package problems.medium;

// https://leetcode.com/problems/find-the-duplicate-number/
public class FindTheDuplicateNumber {
  public int findDuplicate(int[] nums) {
    return new V2().findDuplicate(nums);
  }

  // time O(n) space O(1)
  // fast and slow pointers
  // Floyd's cycle detection algorithm
  static class V2 extends FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
      int fast = 0, slow = 0;

      // determine if a cycle is found
      // fast and slow pointers
      do {
        fast = nums[nums[fast]];
        slow = nums[slow];
      } while (fast != slow);

      // determine the start
      // run another pointer with the slow pointer
      // until the start is found
      int current = 0;
      do {
        current = nums[current];
        slow = nums[slow];
      } while (slow != current);

      return slow;
    }
  }

  // time O(n^2) space O(1)
  // brute-force, expensive nested loops
  // Time Limit Exceeded
  static class V1 extends FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
      for (int i = 0; i < nums.length; i++) {
        for (int j = i + 1; j < nums.length; j++) {
          if (nums[i] == nums[j]) return nums[i];
        }
      }

      return 0;
    }
  }
}
