package problems.medium;

// https://leetcode.com/problems/number-of-islands/
public class NumberOfIslands {
  public int numIslands(char[][] grid) {
    return new V1().numIslands(grid);
  }

  static class V1 extends NumberOfIslands {
    public int numIslands(char[][] grid) {
      return 0;
    }
  }
}