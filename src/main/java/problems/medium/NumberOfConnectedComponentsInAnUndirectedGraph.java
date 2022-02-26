package problems.medium;

// https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
public class NumberOfConnectedComponentsInAnUndirectedGraph {
  public int countComponents(int n, int[][] edges) {
    return new V1().countComponents(n, edges);
  }

  // time O(V+E.alpha(V)) space O(V+1)
  static class V1 extends NumberOfConnectedComponentsInAnUndirectedGraph {
    // find root parent
    private static int find(int[] rep, int v) {
      int res = v;

      // find parent
      while (res != rep[res]) { // stop if the n1 itself is the par
        rep[res] = rep[rep[res]]; // path compression

        res = rep[res];
      }

      return res;
    }

    // union two vertexes
    private static int union(int[] rep, int[] size, int v1, int v2) {
      int p1 = find(rep, v1), p2 = find(rep, v2);

      if (p1 == p2) return 0; // return if have the same parent/root

      // unionize p1 to p2 or p2 to p1, and increase the rank of the new par
      if (size[p2] > size[p1]) {
        rep[p1] = p2;
        size[p2] += size[p1];
      } else {
        rep[p2] = p1;
        size[p1] += size[p2];
      }
      // union was successful
      return 1;
    }

    public int countComponents(int n, int[][] edges) {
      // time O(V) space O(V)
      int[] rep = new int[n], size = new int[n];
      for (int i = 0; i < n; i++) {
        rep[i] = i;
        size[i] = 1;
      }

      // time O(E.alpha(V)) space O(1)
      int numCon = n;
      for (int[] edge : edges) {
        numCon -= union(rep, size, edge[0], edge[1]);
      }

      return numCon;
    }
  }
}
