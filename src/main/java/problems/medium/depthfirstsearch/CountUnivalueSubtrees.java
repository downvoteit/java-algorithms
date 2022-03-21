package problems.medium.depthfirstsearch;

// https://leetcode.com/problems/count-univalue-subtrees/
public class CountUnivalueSubtrees {
  public int countUnivalSubtrees(TreeNode root) {
    return new V1().countUnivalSubtrees(root);
  }

  // time O(n) space O(h)
  static class V1 extends CountUnivalueSubtrees {
    public int countUnivalSubtrees(TreeNode root) {
      if (root == null) return 0;

      return (isUnival(root) ? 1 : 0)
          + countUnivalSubtrees(root.left)
          + countUnivalSubtrees(root.right);
    }

    public boolean isUnival(TreeNode node) {
      if (node == null) return false;

      boolean left = node.left == null || node.left.val == node.val && isUnival(node.left);
      boolean right = node.right == null || node.right.val == node.val && isUnival(node.right);

      return left && right;
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
