package com.downvoteit.javaalgorithms.problems.easy.depthfirstsearch;

// https://leetcode.com/problems/same-tree/
public class SameTree {
  public boolean isSameTree(TreeNode p, TreeNode q) {
    return new V1().isSameTree(p, q);
  }

  static class V1 extends SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
      return recurse(p, q);
    }

    private boolean recurse(TreeNode p, TreeNode q) {
      if (p == null && q == null) return true;
      if (p == null || q == null) return false;

      return p.val == q.val && recurse(p.left, q.left) && recurse(p.right, q.right);
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
