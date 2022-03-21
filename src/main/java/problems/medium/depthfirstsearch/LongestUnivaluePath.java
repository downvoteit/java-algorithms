package problems.medium.depthfirstsearch;

// https://leetcode.com/problems/longest-univalue-path/
public class LongestUnivaluePath {
  public int longestUnivaluePath(TreeNode root) {
    return new V1().longestUnivaluePath(root);
  }

  static class V1 extends LongestUnivaluePath {
    public int longestUnivaluePath(TreeNode root) {
      return 0;
    }
  }

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
}
