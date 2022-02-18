package problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
  public List<List<Integer>> threeSum(int[] nums) {
    return new V1().threeSum(nums);
  }

  static class V1 {
    // two-pointers + binary search
    public List<List<Integer>> threeSum(int[] nums) {
      Arrays.sort(nums);

      List<List<Integer>> triplets = new ArrayList<>();

      return triplets;
    }
  }
}
