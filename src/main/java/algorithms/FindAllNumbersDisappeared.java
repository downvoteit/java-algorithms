package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllNumbersDisappeared {
  public List<Integer> findDisappearedNumbers(int[] nums) {
    return findDisappearedNumbersV1(nums);
  }

  // binary search time O(n) space O(1)
  private List<Integer> findDisappearedNumbersV1(int[] nums) {
    List<Integer> list = new ArrayList<>();

    Arrays.sort(nums);

    for (int i = 1; i <= nums.length; i++) {
      if (Arrays.binarySearch(nums, i) < 0) {
        list.add(i);
      }
    }

    return list;
  }
}
