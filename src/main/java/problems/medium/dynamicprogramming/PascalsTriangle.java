package problems.medium.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/pascals-triangle/
public class PascalsTriangle {
  public List<List<Integer>> generate(int numRows) {
    return new V1().generate(numRows);
  }

  static class V1 extends PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
      List<List<Integer>> output = new ArrayList<>();

      int[][] dp = new int[numRows][];
      dp[0] = new int[] {1};

      recurse(dp, numRows, 1);

      for (int[] outer : dp) {
        List<Integer> temp = new ArrayList<>(outer.length);
        for (int i : outer) temp.add(i);
        output.add(temp);
      }

      return output;
    }

    private void recurse(int[][] dp, int numRows, int i) {
      if (i >= numRows) return;

      int[] previous = dp[i - 1], current = new int[i + 1];

      current[0] = previous[0];
      current[current.length - 1] = previous[0];

      for (int j = 0; j < current.length; j++) {
        if (current[j] != 0) continue;

        int sum = 0;
        if (j > 0 && j < current.length - 1) {
          sum = previous[j - 1] + previous[j];
        }

        current[j] = sum;
      }

      dp[i] = current;

      recurse(dp, numRows, ++i);
    }
  }
}
