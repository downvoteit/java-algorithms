package problems.easy.unsolved;

// https://leetcode.com/problems/invert-binary-tree/
public class InvertBinaryTree {
  public TreeNode invertTree(TreeNode root) {
    return null;
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
