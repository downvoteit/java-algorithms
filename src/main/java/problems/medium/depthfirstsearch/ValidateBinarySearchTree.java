package problems.medium.depthfirstsearch;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/validate-binary-search-tree/
public class ValidateBinarySearchTree {
  public boolean isValidBST(TreeNode root) {
    return new V2().isValidBST(root);
  }

  // time O(n) space O(h)
  static class V2 extends ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
      // left and right are initially negative and positive infinity
      // use long to avoid int overflow
      return recurse(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean recurse(TreeNode root, long left, long right) {
      // null BST is still a BST allegedly
      if (root == null) return true;

      // verify that left is lesser and right is greater
      if (!(root.val > left && root.val < right)) return false;

      // ensure that the left BST is valid (updated right boundary)
      // ensure that the right BST is valid (updated left boundary)
      return recurse(root.left, left, root.val) && recurse(root.right, root.val, right);
    }
  }

  // time O(n) space O(h)
  // DFS, inorder
  // everything on the left must be less than the root
  // everything on the right must be greater than the root
  static class V1 extends ValidateBinarySearchTree {
    List<Integer> list = new ArrayList<>();

    public boolean isValidBST(TreeNode root) {
      recurse(root);

      for (int i = 1; i < list.size(); i++)
        if (list.get(i - 1) >= list.get(i)) {
          return false;
        }

      return true;
    }

    private void recurse(TreeNode root) {
      if (root == null) return;

      recurse(root.left);
      list.add(root.val);
      recurse(root.right);
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
      return "("
          + val
          + (left == null ? "" : ", l" + left)
          + (right == null ? "" : ", r" + right)
          + ')';
    }
  }
}
