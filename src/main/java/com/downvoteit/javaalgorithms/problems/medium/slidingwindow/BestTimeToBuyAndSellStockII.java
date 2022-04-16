package com.downvoteit.javaalgorithms.problems.medium.slidingwindow;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
public class BestTimeToBuyAndSellStockII {
  public int maxProfit(int[] prices) {
    return new V1().maxProfit(prices);
  }

  // time O(n) space O(1)
  // just ridiculous
  static class V1 extends BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
      int max = 0;

      for (int i = 1; i < prices.length; i++)
        if (prices[i] > prices[i - 1]) {
          max += prices[i] - prices[i - 1];
        }

      return max;
    }
  }
}
