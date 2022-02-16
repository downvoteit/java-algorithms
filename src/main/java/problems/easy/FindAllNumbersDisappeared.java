package problems.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllNumbersDisappeared {
  public List<Integer> findDisappearedNumbers(int[] nums) {
    return new V1().findDisappearedNumbers(nums);
  }

  // time O(n) space O(1)
  static class V1 extends FindAllNumbersDisappeared {
    public List<Integer> findDisappearedNumbers(int[] nums) {
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
}