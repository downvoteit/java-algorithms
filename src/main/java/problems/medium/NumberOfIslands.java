package problems.medium;

import implementations.QuickUnion;

import java.util.Arrays;

// https://leetcode.com/problems/number-of-islands/
public class NumberOfIslands {
  public int numIslands(char[][] grid) {
    return new V1().numIslands(grid);
  }

  // grid[i][j] = 1 => land
  // grid[i][j] = 0 => water
  // 1 - count connected components
  // 2 - count root nodes
  static class V1 extends NumberOfIslands implements QuickUnion {
    int components, connectedComponents;
    int[] vertices, rank, parent;

    public int numIslands(char[][] edges) {
      components = connectedComponents = edges.length * edges[0].length;

      vertices = new int[components];
      rank = new int[components];
      parent = new int[components];
      for (int i = 0; i < components; i++) {
        vertices[i] = i;
        rank[i] = 1;
      }

      for (int i = 0; i < edges.length; i++) {
        for (int j = 0; j < edges[i].length; j++) {
          if (edges[i][j] == '1') {
            union(i, j);
            System.out.print(edges[i][j] + " " + Arrays.toString(vertices));
          }
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
      else parent[root1] = root2;

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
