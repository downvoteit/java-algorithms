package problems.medium.disjointsets;

import interfaces.QuickUnion;

// https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
public class NumberOfConnectedComponentsInAnUndirectedGraph {
  public int countComponents(int n, int[][] edges) {
    return new V1().countComponents(n, edges);
  }

  // time O(n alpha(n)) space O(n)
  // union-find, quick-union with rank and path compression optimisations
  static class V1 extends NumberOfConnectedComponentsInAnUndirectedGraph implements QuickUnion {
    int components, connectedComponents;
    int[] vertices, rank;

    public int countComponents(int n, int[][] edges) {
      components = connectedComponents = n;

      vertices = new int[components];
      rank = new int[components];
      for (int i = 0; i < components; i++) {
        vertices[i] = i;
        rank[i] = 1;
      }

      for (int[] i : edges) {
        union(i[0], i[1]);
      }

      return connectedComponents;
    }

    public int find(int vertex) {
      // find with iterative path compression optimisation
      while (vertex != vertices[vertex]) {
        vertices[vertex] = vertices[vertices[vertex]];

        vertex = vertices[vertex];
      }

      return vertex;
    }

    public void union(int vertex1, int vertex2) {
      int root1 = find(vertex1), root2 = find(vertex2);

      if (root1 == root2) return;

      // union with rank optimisation
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
