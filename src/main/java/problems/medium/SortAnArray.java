package problems.medium;

public class SortAnArray {
  public int[] sortArray(int[] nums) {
    return new V1().sortArray(nums);
  }

  // time O(n*log n) space O(n)
  static class V1 {
    public int[] sortArray(int[] nums) {
      sort(nums, nums.length);

      return nums;
    }

    private void sort(int[] nums, int n) {
      int curSize, leftStart;

      for (curSize = 1; curSize <= n - 1; curSize = 2 * curSize)
        for (leftStart = 0; leftStart < n - 1; leftStart += 2 * curSize) {
          int mid = Math.min(leftStart + curSize - 1, n - 1);

          int right_end = Math.min(leftStart + 2 * curSize - 1, n - 1);

          merge(nums, leftStart, mid, right_end);
        }
    }

    private void merge(int[] nums, int left, int mid, int right) {
      int leftLen = mid - left + 1;
      int rightLen = right - mid;

      int[] leftArr = new int[leftLen];
      int[] rightArr = new int[rightLen];

      for (int i = 0; i < leftLen; i++) leftArr[i] = nums[left + i];
      for (int j = 0; j < rightLen; j++) rightArr[j] = nums[mid + 1 + j];

      int i = 0, j = 0, k = left;

      while (i < leftLen && j < rightLen)
        if (leftArr[i] <= rightArr[j]) {
          nums[k++] = leftArr[i++];
        } else {
          nums[k++] = rightArr[j++];
        }
      while (i < leftLen) nums[k++] = leftArr[i++];
      while (j < rightLen) nums[k++] = rightArr[j++];
    }
  }
}
