package problems.medium;

import implementations.QuickUnion;

// https://leetcode.com/problems/number-of-provinces/
public class NumberOfProvinces {
  public int findCircleNum(int[][] isConnected) {
    return new V1().findCircleNum(isConnected);
  }

  // time O(n alpha(n)) space O(n)
  // union-find, quick-union with rank and path compression optimisations
  // component vertices are i and j
  // isConnected[i][j] == 1 means i and j are connected
  // isConnected[i][j] == 0 means i and j are not connected
  static class V1 extends NumberOfProvinces implements QuickUnion {
    int components, connectedComponents;
    int[] vertices, rank;

    public int findCircleNum(int[][] edges) {
      components = connectedComponents = edges.length;

      vertices = new int[components];
      rank = new int[components];
      for (int i = 0; i < components; i++) {
        vertices[i] = i;
        rank[i] = 1;
      }

      for (int i = 0; i < components - 1; i++) {
        for (int j = i + 1; j < components; j++) {
          if (edges[i][j] == 1) union(i, j);
          System.out.print(edges[i][j]);
        }
        System.out.println();
      }

      return connectedComponents;
    }

    public int find(int vertex) {
      while (vertex != vertices[vertex]) {
        vertices[vertex] = vertices[vertices[vertex]];

        vertex = vertices[vertex];
      }

      return vertex;
    }

    public void union(int vertex1, int vertex2) {
      int root1 = find(vertex1), root2 = find(vertex2);

      if (root1 == root2) return;

      if (rank[root1] < rank[root2]) {
        vertices[root1] = root2;
        rank[root2] += rank[root1];
      } else {
        vertices[root2] = root1;
        rank[root1] += rank[root2];
      }

      connectedComponents--;
    }
  }
}
