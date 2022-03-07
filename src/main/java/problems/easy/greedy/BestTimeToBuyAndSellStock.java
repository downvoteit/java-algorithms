package problems.easy.greedy;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class BestTimeToBuyAndSellStock {
  public int maxProfit(int[] prices) {
    return new V1().maxProfit(prices);
  }

  // time O(n^2) space O(1)
  // greedy, dynamic programming, brute-force
  // Time Limit Exceeded
  static class V1 extends BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
      int max = 0;
      for (int i = 0; i < prices.length; i++)
        for (int j = i + 1; j < prices.length; j++) {
          if (prices[j] == 0) continue;
          if (prices[j] - prices[i] <= 0) continue;

          max = Math.max(max, prices[j] - prices[i]);
        }

      return max;
    }
  }
}