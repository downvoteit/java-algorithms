package com.downvoteit.javaalgorithms.implementations;

// https://www.geeksforgeeks.org/binary-search/
// divide and conquer
// not suited for unsorted arrays
// not safe for number overflows
// time O(log n)
// space O(1)
public class IterativeBinarySearch {
  public int search(int[] nums, int target) {
    int low = 0, high = nums.length - 1;

    while (low <= high) {
      int mid = (low + high) >>> 1; // right bit-shift by 1 will divide by 2 and truncate

      if (nums[mid] == target) return mid;

      if (nums[mid] < target) { // prone to number overflows
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }

    return -(low + 1);
  }
}
