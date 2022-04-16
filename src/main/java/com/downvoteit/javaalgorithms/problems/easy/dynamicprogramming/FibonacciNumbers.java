package com.downvoteit.javaalgorithms.problems.easy.dynamicprogramming;

// https://leetcode.com/problems/fibonacci-number/
public class FibonacciNumbers {
  public int fib(int n) {
    return new V4().fib(n);
  }

  // time O(2^n) space O(n)
  static class V2 extends FibonacciNumbers {
    public int fib(int n) {
      int[] arr = new int[n];

      return calculateMemoized(n, arr);
    }

    int calculateMemoized(int n, int[] arr) {
      if (n < 2) {
        return n;
      }

      int m = n - 1;
      if (arr[m] == 0) {
        arr[m] = calculateMemoized(n - 1, arr) + calculateMemoized(n - 2, arr);
      }

      return arr[m];
    }
  }

  // time O(2^n) space O(n)
  static class V1 extends FibonacciNumbers {
    // example 4F, 3 =>
    // 3F + 2F =
    // (2F + 1F) + (1F + 0F) =
    // (2F + 1) + 1 =
    // (1 + 1) + 1 = 3
    // example 5F, 5 =>
    // 4F + 3F =
    // (3F + 2F) + (2F + 1) =
    // ((2F + 1) + (1 + 0)) + ((1 + 0) + 1) =
    // (1 + 1 + 1) + (1 + 1) = 5
    public int fib(int n) {
      if (n < 2) {
        return n;
      }

      return fib(n - 1) + fib(n - 2);
    }
  }

  // time O(n) space O(1)
  static class V4 extends FibonacciNumbers {
    public int fib(int n) {
      if (n < 2) {
        return n;
      }

      int prev = 0, next = 1, num = 0;
      for (int i = 2; i <= n; i++) {
        num = prev + next;
        prev = next;
        next = num;
      }

      return num;
    }
  }

  // time O(n) space O(n)
  static class V3 extends FibonacciNumbers {
    public int fib(int n) {
      if (n < 2) {
        return n;
      }

      int[] arr = new int[n + 1];
      arr[1] = 1;

      for (int i = 2; i <= n; i++) {
        arr[i] = arr[i - 1] + arr[i - 2];
      }

      return arr[n];
    }
  }
}
