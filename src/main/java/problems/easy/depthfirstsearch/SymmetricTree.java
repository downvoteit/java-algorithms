package problems.easy.depthfirstsearch;

// https://leetcode.com/problems/symmetric-tree/
public class SymmetricTree {
  public boolean isSymmetric(TreeNode root) {
    return new V1().isSymmetric(root);
  }

  static class V1 extends SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
      return false;
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
      return "" + val;
    }
  }
}
