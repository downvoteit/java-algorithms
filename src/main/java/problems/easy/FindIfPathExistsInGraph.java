package problems.easy;

// https://leetcode.com/problems/find-if-path-exists-in-graph/
public class FindIfPathExistsInGraph {
  public boolean validPath(int n, int[][] edges, int source, int destination) {
    return new V1().validPath(n, edges, source, destination);
  }

  static class V1 extends FindIfPathExistsInGraph {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
      return false;
    }
  }
}
