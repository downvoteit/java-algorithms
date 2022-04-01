package problems.easy.depthfirstsearch;

// https://leetcode.com/problems/diameter-of-binary-tree/
public class DiameterOfBinaryTree {
  public int diameterOfBinaryTree(TreeNode root) {
    return new V1().diameterOfBinaryTree(root);
  }

  // time O(n) space O(1)
  static class V1 extends DiameterOfBinaryTree {
    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
      recurse(root);

      return diameter;
    }

    private int recurse(TreeNode node) {
      if (node == null) return 0;

      int left = recurse(node.left);
      int right = recurse(node.right);

      diameter = Math.max(diameter, left + right);

      return 1 + Math.max(left, right);
    }
  }

  class TreeNode {
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
