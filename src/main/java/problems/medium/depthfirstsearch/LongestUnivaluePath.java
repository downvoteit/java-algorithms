package problems.medium.depthfirstsearch;

// https://leetcode.com/problems/longest-univalue-path/
public class LongestUnivaluePath {
  public int longestUnivaluePath(TreeNode root) {
    return new V1().longestUnivaluePath(root);
  }

  // time O(n) space O(h)
  static class V1 extends LongestUnivaluePath {
    int longestUnivalueArrowLength = 0;

    public int longestUnivaluePath(TreeNode root) {
      if (root == null) return 0;

      recurse(root);

      return longestUnivalueArrowLength;
    }

    private int recurse(TreeNode node) {
      if (node == null) return 0;

      int longestUnivalueLeftArrowLength;
      if (node.left == null) longestUnivalueLeftArrowLength = 0;
      else {
        int temp = recurse(node.left);
        longestUnivalueLeftArrowLength = node.left.val == node.val ? temp + 1 : 0;
      }

      int longestUnivalueRightArrowLength;
      if (node.right == null) longestUnivalueRightArrowLength = 0;
      else {
        int temp = recurse(node.right);

        longestUnivalueRightArrowLength = node.right.val == node.val ? temp + 1 : 0;
      }

      longestUnivalueArrowLength =
          Math.max(
              longestUnivalueArrowLength,
              longestUnivalueLeftArrowLength + longestUnivalueRightArrowLength);

      return Math.max(longestUnivalueLeftArrowLength, longestUnivalueRightArrowLength);
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

    @Override
    public String toString() {
      return "{"
          + val
          + ", l:"
          + (left == null ? "" : left)
          + ", r:"
          + (right == null ? "" : right)
          + '}';
    }
  }
}
