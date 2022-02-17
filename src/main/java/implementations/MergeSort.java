package implementations;

// https://www.geeksforgeeks.org/merge-sort/
// https://www.baeldung.com/java-merge-sort/
// stable, recursive, divide and conquer, not in-place
// time best case O(n*log n)
// time worse case O(n*log n)
// space O(n)
public class MergeSort {
  public void sort(int[] nums, int left, int right) {
    if (left >= right) return;

    int mid = left + (right - left) / 2;

    sort(nums, left, mid);
    sort(nums, mid + 1, right);

    merge(nums, left, mid, right);
  }

  private void merge(int[] nums, int left, int mid, int right) {
    int leftLen = mid - left + 1;
    int rightLen = right - mid;

    int[] leftArr = new int[leftLen];
    int[] rightArr = new int[rightLen];

    for (int i = 0; i < leftLen; ++i) leftArr[i] = nums[left + i];
    for (int j = 0; j < rightLen; ++j) rightArr[j] = nums[mid + 1 + j];

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
