package problems.medium;

import implementations.QuickUnionUndirectedTree;

// https://leetcode.com/problems/graph-valid-tree/
public class GraphValidTree {
  public boolean validTree(int n, int[][] edges) {
    return new V1().validTree(n, edges);
  }

  // time O(n alpha(n)) space O(n)
  // Runtime: 0 ms, faster than 100.00% of Java online submissions for Graph Valid Tree.
  // Memory Usage: 42.4 MB, less than 84.46% of Java online submissions for Graph Valid Tree.
  static class V1 extends GraphValidTree implements QuickUnionUndirectedTree {
    int components, connectedComponents;
    int[] vertices, rank;

    public boolean validTree(int n, int[][] edges) {
      if (edges.length != n - 1) return false; // if E = V - 1 is false does not adhere

      components = connectedComponents = n;

      vertices = new int[components];
      rank = new int[components];
      for (int i = 0; i < components; i++) {
        vertices[i] = i;
        rank[i] = 1;
      }

      for (int[] edge : edges) {
        if (union(edge[0], edge[1])) return false;
      }

      return hasMinVertices();
    }

    public int find(int vertex) {
      while (vertex != vertices[vertex]) {
        vertices[vertex] = vertices[vertices[vertex]];

        vertex = vertices[vertex];
      }

      return vertex;
    }

    public boolean union(int vertex1, int vertex2) {
      int root1 = find(vertex1), root2 = find(vertex2);

      if (root1 == root2) return true; // if true is not acyclic

      if (rank[root1] < rank[root2]) {
        vertices[root1] = root2;
        rank[root2] += rank[root1];
      } else {
        vertices[root2] = root1;
        rank[root1] += rank[root2];
      }

      connectedComponents--;

      return false;
    }

    public boolean hasMinVertices() {
      int found = 0;

      for (int value : rank) {
        if (value >= components - 1) found++;
      }

      // if false has less than n - 1 vertices on each candidate
      return found >= connectedComponents;
    }
  }
}
