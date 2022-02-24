package problems.easy;

// https://leetcode.com/problems/peak-index-in-a-mountain-array/
public class PeakIndexInAMountainArray {
  public int peakIndexInMountainArray(int[] arr) {
    return new V1().peakIndexInMountainArray(arr);
  }

  static class V1 {
    public int peakIndexInMountainArray(int[] arr) {
      // int left = 0, right = arr.length - 1;

      // int num = 0;

      // arr[0] < arr[1] < ... arr[i-1] < arr[i]
      // arr[i] > arr[i+1] > ... > arr[arr.length - 1]
      // while (left <right) {
      //  //int mid = left + right >>> 1;
      // }

      return 0;
    }
  }
}
