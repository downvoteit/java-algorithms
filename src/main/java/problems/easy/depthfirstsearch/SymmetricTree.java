package problems.easy.depthfirstsearch;

// https://leetcode.com/problems/symmetric-tree/
public class SymmetricTree {
  public boolean isSymmetric(TreeNode root) {
    return new V1().isSymmetric(root);
  }

  // time O(n) space O(1)
  // two-tree approach
  static class V1 extends SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
      return recurse(root, root);
    }

    private boolean recurse(TreeNode tree, TreeNode antiTree) {
      if (tree == null && antiTree == null) return true; // both reached their leafs
      if (tree == null || antiTree == null) return false; // either one reached a leaf first

      // check node values and traverse down both trees
      return tree.val == antiTree.val
          && recurse(tree.left, antiTree.right)
          && recurse(tree.right, antiTree.left);
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
      return "{" + "v=" + val + ", l=" + left + ", r=" + right + '}';
    }
  }
}
