package problems.easy.depthfirstsearch;

// https://leetcode.com/problems/merge-two-binary-trees/
public class MergeTwoBinaryTrees {
  public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
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