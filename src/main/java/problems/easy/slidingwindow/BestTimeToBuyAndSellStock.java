package problems.easy.slidingwindow;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class BestTimeToBuyAndSellStock {
  public int maxProfit(int[] prices) {
    return new V2().maxProfit(prices);
  }

  // time O(n) space O(1)
  // sliding window, greedy, single loop
  static class V2 extends BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
      int winStart = 0, max = 0;

      for (int winEnd = 1; winEnd < prices.length; winEnd++) {
        if (prices[winStart] > prices[winEnd]) { // found a new low on the right
          winStart = winEnd; // update the left with the new low value
        }

        max = Math.max(max, prices[winEnd] - prices[winStart]);
      }

      return max;
    }
  }

  // time O(n^2) space O(1)
  // greedy, brute-force
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
