package problems.easy.depthfirstsearch;

// https://leetcode.com/problems/invert-binary-tree/
public class InvertBinaryTree {
  public TreeNode invertTree(TreeNode root) {
    return new V1().invertTree(root);
  }

  // time O(n) space O(h)
  static class V1 extends InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
      recurse(root);

      return root;
    }

    private void recurse(TreeNode root) {
      if (root == null) return;

      recurse(root.left);
      recurse(root.right);

      TreeNode temp = root.left;
      root.left = root.right;
      root.right = temp;
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
    public boolean equals(Object obj) {
      if (obj instanceof InvertBinaryTree.TreeNode) {
        return obj.toString().equals(this.toString());
      }

      return false;
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
