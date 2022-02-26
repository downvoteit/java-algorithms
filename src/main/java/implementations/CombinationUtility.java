package implementations;

import java.util.ArrayList;
import java.util.List;

// https://www.geeksforgeeks.org/print-all-possible-combinations-of-r-elements-in-a-given-array-of-size-n/
public class CombinationUtility {
  public long[] calculateCombinationsAndPermutations(int n, int r) {
    if (n < r) throw new IllegalArgumentException("r cannot be greater than n");

    long a = 1, b = 1, c = 1;

    for (int i = 1; i <= n; i++) a *= i;
    for (int i = 1; i <= n - r; i++) b *= i;
    for (int i = 1; i <= r; i++) c *= i;

    long permutations = a / b, combinations = a / (b * c);

    return new long[] {permutations, combinations};
  }

  public List<List<Integer>> generateAllPossibleCombinations(int n, int r) {
    List<List<Integer>> list = new ArrayList<>();
    int[] nums = new int[n], data = new int[r];

    for (int i = 1; i <= n; i++) nums[i - 1] = i;

    combine(list, nums, data, 0, n - 1, 0, r);

    return list;
  }

  private void combine(
      List<List<Integer>> list, int[] nums, int[] array, int start, int end, int index, int r) {
    if (index == r) {
      List<Integer> temp = new ArrayList<>();

      for (int j = 0; j < r; j++) temp.add(array[j]);

      list.add(temp);

      return;
    }

    for (int i = start; i <= end && end - i + 1 >= r - index; i++) {
      array[index] = nums[i];

      combine(list, nums, array, i + 1, end, index + 1, r);
    }
  }
}
