package problems.easy;

// https://leetcode.com/problems/diameter-of-binary-tree/
public class DiameterOfBinaryTree {
  public int diameterOfBinaryTree(TreeNode root) {
    return 0;
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
