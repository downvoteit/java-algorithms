package com.downvoteit.javaalgorithms.problems.easy.modifiedbinarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
public class FindAllNumbersDisappearedInAnArray {
  public List<Integer> findDisappearedNumbers(int[] nums) {
    return new V1().findDisappearedNumbers(nums);
  }

  // time O(n) space O(1)
  static class V1 extends FindAllNumbersDisappearedInAnArray {
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
