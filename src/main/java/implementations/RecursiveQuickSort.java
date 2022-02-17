package implementations;

// https://www.geeksforgeeks.org/iterative-quick-sort/
// https://www.geeksforgeeks.org/quick-sort/
// https://www.baeldung.com/java-quicksort/
// unstable, recursive, divide and conquer, in-place
// time best case O(n*log n)
// time worst case O(n^2)
// space O(log n)
// suitable for arrays
// not suitable for linked lists
// [start .. end] => [left .. right - 1] + [left + 1 .. right]
public class RecursiveQuickSort {
  public void sort(int[] nums, int left, int right) {
    if (left >= right) return;

    int pi = partition(nums, left, right); // O(n)

    sort(nums, left, pi - 1); // 2*O(n/2)
    sort(nums, pi + 1, right); //
  }

  private int partition(int[] nums, int start, int end) {
    int pivot = nums[end], i = start - 1;

    for (int j = start; j <= end - 1; j++)
      if (nums[j] <= pivot) {
        swap(nums, ++i, j);
      }
    swap(nums, ++i, end);

    return i;
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}
