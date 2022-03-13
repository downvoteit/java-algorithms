package problems.hard.slidingwindow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/sliding-window-maximum/
public class SlidingWindowMaximum {
  private static int[] listToArray(List<Integer> list) {
    int[] output = new int[list.size()];
    for (int i = 0; i < list.size(); i++) {
      output[i] = list.get(i);
    }

    return output;
  }

  public int[] maxSlidingWindow(int[] nums, int k) {
    return new V2().maxSlidingWindow(nums, k);
  }

  // monotonically decreasing queue
  static class V2 extends SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
      List<Integer> output = new ArrayList<>();

      Queue<Integer> queue = new LinkedList<>();

      for (int i = 0; i < nums.length; i++) {}

      return listToArray(output);
    }
  }

  // time O(m*(n-m)) space O(n)
  // greedy, brute-force
  // Time Limit Exceeded
  static class V1 extends SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
      List<Integer> output = new ArrayList<>();

      for (int i = 0; i <= nums.length - k; i++) {
        int max = Integer.MIN_VALUE;
        for (int j = i; j < i + k; j++) {
          max = Math.max(max, nums[j]);
        }

        output.add(max);
      }

      return listToArray(output);
    }
  }
}
