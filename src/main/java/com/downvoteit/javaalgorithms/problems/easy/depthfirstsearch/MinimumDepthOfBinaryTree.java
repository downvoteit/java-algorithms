package com.downvoteit.javaalgorithms.problems.easy.depthfirstsearch;

import java.util.PriorityQueue;

// https://leetcode.com/problems/minimum-depth-of-binary-tree/
public class MinimumDepthOfBinaryTree {
  public int minDepth(TreeNode root) {
    return new V1().minDepth(root);
  }

  // time O(n) space O(n)
  static class V1 extends MinimumDepthOfBinaryTree {
    PriorityQueue<Integer> routes = new PriorityQueue<>(Integer::compareTo);

    public int minDepth(TreeNode root) {
      if (root == null) return 0;

      recurse(root, 1);

      return !routes.isEmpty() ? routes.poll() : 0;
    }

    private void recurse(TreeNode node, int depth) {
      if (node == null) return;

      if (node.left == null && node.right == null) {
        routes.add(depth);
      }

      recurse(node.left, depth + 1);
      recurse(node.right, depth + 1);
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
