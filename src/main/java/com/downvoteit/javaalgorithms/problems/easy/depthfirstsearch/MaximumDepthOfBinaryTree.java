package com.downvoteit.javaalgorithms.problems.easy.depthfirstsearch;

// https://leetcode.com/problems/maximum-depth-of-binary-tree/
public class MaximumDepthOfBinaryTree {
  public int maxDepth(TreeNode root) {
    return new V2().maxDepth(root);
  }

  // time O(n) space O(n)
  // DFS, top-down, as fast and efficient as the below
  static class V2 extends MaximumDepthOfBinaryTree {
    int max = 1;

    public int maxDepth(TreeNode root) {
      if (root == null) return 0;

      recurse(root, max);

      return max;
    }

    private void recurse(TreeNode node, int depth) {
      if (node == null) return;

      if (node.left == null && node.right == null) {
        max = Math.max(max, depth);
      }

      recurse(node.left, depth + 1);
      recurse(node.right, depth + 1);
    }
  }

  // time O(n) space O(n)
  // DFS, bottom-up, very fast and efficient
  static class V1 extends MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
      if (root == null) return 0;

      return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
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
