package problems.easy;

// https://leetcode.com/problems/same-tree/
public class SameTree {
  public boolean isSameTree(TreeNode p, TreeNode q) {
    return false;
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
  }
}
