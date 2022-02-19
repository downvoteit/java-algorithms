package problems.easy.unsolved;

// https://leetcode.com/problems/subtree-of-another-tree/
public class SubtreeOfAnotherTree {
  public boolean isSubtree(TreeNode root, TreeNode subRoot) {
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
