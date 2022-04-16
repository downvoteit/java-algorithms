package com.downvoteit.javaalgorithms.problems.easy.depthfirstsearch;

// https://leetcode.com/problems/univalued-binary-tree/
public class UnivaluedBinaryTree {
  public boolean isUnivalTree(TreeNode root) {
    return new V1().isUnivalTree(root);
  }

  // time O(n) space O(h)
  static class V1 extends UnivaluedBinaryTree {
    public boolean isUnivalTree(TreeNode root) {
      if (root == null) return false;

      // check if the LHS/RHS is null
      // check if the LHS/RHS value equals to the root all the way to the left/right
      boolean left = root.left == null || root.left.val == root.val && isUnivalTree(root.left);
      boolean right = root.right == null || root.right.val == root.val && isUnivalTree(root.right);

      // check if both left and right true
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
