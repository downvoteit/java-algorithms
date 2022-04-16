package com.downvoteit.javaalgorithms.problems.easy.depthfirstsearch;

// https://leetcode.com/problems/subtree-of-another-tree/
public class SubtreeOfAnotherTree {
  public boolean isSubtree(TreeNode root, TreeNode subRoot) {
    return new V1().isSubtree(root, subRoot);
  }

  // time O(m * n) space O(h)
  static class V1 extends SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode p, TreeNode q) {
      if (q == null) return true;
      if (p == null) return false;

      if (isSameTree(p, q)) return true;

      return isSubtree(p.left, q) || isSubtree(p.right, q);
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
      if (p == null && q == null) return true;
      if (p == null || q == null) return false;

      return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
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
      return "("
          + val
          + (left == null ? "" : ", l" + left)
          + (right == null ? "" : ", r" + right)
          + ')';
    }
  }
}
