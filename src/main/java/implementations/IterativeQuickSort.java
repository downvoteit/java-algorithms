package implementations;

// https://www.geeksforgeeks.org/iterative-quick-sort/
public class IterativeQuickSort {
  public void sort(int[] nums, int left, int right) {
    int top = -1;
    int[] stack = new int[right - left + 1];

    stack[++top] = left;
    stack[++top] = right;

    while (top >= 0) {
      right = stack[top--];
      left = stack[top--];

      int pi = partition(nums, left, right);

      if (pi - 1 > left) {
        stack[++top] = left;
        stack[++top] = pi - 1;
      }

      if (pi + 1 < right) {
        stack[++top] = pi + 1;
        stack[++top] = right;
      }
    }
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
