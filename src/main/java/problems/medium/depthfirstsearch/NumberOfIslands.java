package problems.medium.depthfirstsearch;

// https://leetcode.com/problems/number-of-islands/
public class NumberOfIslands {
  public int numIslands(char[][] grid) {
    return new V1().numIslands(grid);
  }

  // time O(4*m*n) space O(m*n)
  // recursive dfs with 4-way flood fill
  static class V1 extends NumberOfIslands {
    int rows = 0, columns = 0, islands = 0;
    char[][] edges;

    public int numIslands(char[][] edges) {
      if (edges == null || edges.length == 0) return 0;

      this.edges = edges;
      this.rows = edges.length;
      this.columns = edges[0].length;

      for (int i = 0; i < rows; i++)
        for (int j = 0; j < columns; j++) {

          if (edges[i][j] == '0') continue; // continue on water

          dfs(i, j);

          islands++;
        }

      return islands;
    }

    private void dfs(int i, int j) {
      if (i < 0 || j < 0) return; // stop out of range
      if (i >= rows || j >= columns) return; // stop out of range
      if (edges[i][j] == '0') return; // avoid visited/water

      edges[i][j] = '0'; // mark visited/water

      dfs(i + 1, j); // go right
      dfs(i - 1, j); // go left
      dfs(i, j + 1); // go up
      dfs(i, j - 1); // go down
    }
  }
}
