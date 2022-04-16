package com.downvoteit.javaalgorithms.problems.hard.slidingwindow;

import java.util.*;

// https://leetcode.com/problems/sliding-window-maximum/
public class SlidingWindowMaximum {
  public int[] maxSlidingWindow(int[] nums, int k) {
    return new V3().maxSlidingWindow(nums, k);
  }

  // time O(n*m) space O(n)
  // monotonically decreasing queue
  static class V3 extends SlidingWindowMaximum {
    /*

    deque methods

    L              R
    ^              ^
    3, 3, 5, 5, 6, 7

    for left/head
      offerFirst/addFirst
      pollFirst/removeFirst
      peekFirst/getFirst

    for right/tail
      offerLast/addLast
      pollLast/removeLast
      peekLast/getLast

    */
    public int[] maxSlidingWindow(int[] nums, int k) {
      int[] output = new int[nums.length - k + 1];

      Deque<Integer> deque = new ArrayDeque<>();

      int i = 0;

      while (i < nums.length) {
        // remove anything out of the window
        if (!deque.isEmpty() && deque.peekFirst() == i - k) {
          deque.pollFirst();
        }

        // remove the anything less than the current
        while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
          deque.pollLast();
        }

        deque.offerLast(i);

        if (i >= k - 1)
          if (!deque.isEmpty()) {
            output[i - k + 1] = nums[deque.peekFirst()];
          }

        i++;
      }

      return output;
    }
  }

  // time O(n*log n) space O(m)
  // heap
  // Time Limit Exceeded
  static class V2 extends SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
      int[] output = new int[nums.length - k + 1];
      PriorityQueue<Integer> heap = new PriorityQueue<>(k, Collections.reverseOrder());

      for (int i = 0; i < nums.length; i++) {
        heap.offer(nums[i]);

        if (heap.size() >= k) {
          if (!heap.isEmpty()) {
            output[i + 1 - k] = heap.peek();
          }

          heap.remove(nums[i + 1 - k]);
        }
      }

      return output;
    }
  }

  // time O(m*(n-m)) space O(n)
  // greedy, brute-force
  // Time Limit Exceeded
  static class V1 extends SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
      List<Integer> list = new ArrayList<>();

      for (int i = 0; i <= nums.length - k; i++) {
        int max = Integer.MIN_VALUE;
        for (int j = i; j < i + k; j++) {
          max = Math.max(max, nums[j]);
        }

        list.add(max);
      }

      int[] output = new int[list.size()];
      for (int i = 0; i < list.size(); i++) {
        output[i] = list.get(i);
      }

      return output;
    }
  }
}
