package problems.easy.binarysearch;

// https://leetcode.com/problems/peak-index-in-a-mountain-array/
public class PeakIndexInAMountainArray {
  public int peakIndexInMountainArray(int[] arr) {
    return new V3().peakIndexInMountainArray(arr);
  }

  // time O(log n) space O(1)
  // bitonic array
  static class V3 extends PeakIndexInAMountainArray {
    public int peakIndexInMountainArray(int[] arr) {
      int left = 0, right = arr.length - 1;

      while (left < right) {
        int mid = left + right >>> 1;

        if (arr[mid] < arr[mid + 1]) {
          left = mid + 1;
        } else {
          right = mid;
        }
      }

      return left;
    }
  }

  // time O(log n) space O(1)
  static class V2 extends PeakIndexInAMountainArray {
    public int peakIndexInMountainArray(int[] arr) {
      int left = 0, right = arr.length - 1;

      while (left < right) {
        int mid = left + right >>> 1;

        if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
          return mid;
        } else if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]
            || arr[mid] < arr[mid + 1] && arr[mid] > arr[mid - 1]) {
          left++;
        } else if (arr[mid] > arr[mid + 1] && arr[mid] < arr[mid - 1]
            || arr[mid] < arr[mid + 1] && arr[mid] < arr[mid - 1]) {
          right--;
        }
      }

      return 0;
    }
  }

  // time O(n) space O(1)
  static class V1 extends PeakIndexInAMountainArray {
    public int peakIndexInMountainArray(int[] arr) {
      int peakIdx = 0;

      for (int i = 2; i < arr.length; i++) {
        int prev = arr[i - 2], cur = arr[i - 1], next = arr[i];

        if (cur > prev && cur > next) {
          peakIdx = i - 1;
        }
      }

      return peakIdx;
    }
  }
}
