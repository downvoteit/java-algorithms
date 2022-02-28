package problems.medium;

// https://leetcode.com/problems/number-of-provinces/
public class NumberOfProvinces {
  public int findCircleNum(int[][] isConnected) {
    return new V1().findCircleNum(isConnected);
  }

  // time O(log n) space O(1)
  static class V1 extends NumberOfProvinces {
    /*
    ij 0 1 2
    0 [1,1,0]
    1 [1,1,0]
    2 [0,0,1]

    if isConnected[i][j] = 1, i and j are connected
    m is the number of vertices
    n is the number of connected vertices
    */
    int m, n;
    int[] vertices, size;

    public int findCircleNum(int[][] isConnected) {
      m = n = isConnected.length;

      vertices = new int[m];
      size = new int[m];
      for (int i = 0; i < m; i++) {
        vertices[i] = i;
        size[i] = 1;
      }

      for (int i = 0; i < m - 1; i++)
        for (int j = i + 1; j < m; j++) {
          if (isConnected[i][j] == 1) union(i, j);
        }

      return n;
    }

    private void union(int p, int q) {
      int i = find(p), j = find(q);

      if (i == j) return;

      if (size[i] < size[j]) {
        vertices[i] = j;
        size[j] += size[i];
      } else {
        vertices[j] = i;
        size[i] += size[j];
      }
      n--;
    }

    private int find(int p) {
      while (p != vertices[p]) {
        p = vertices[p];
      }

      return p;
    }
  }
}
