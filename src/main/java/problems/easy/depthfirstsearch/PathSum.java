package problems.easy.depthfirstsearch;

import java.util.LinkedList;

// https://leetcode.com/problems/path-sum/
public class PathSum {
  public boolean hasPathSum(TreeNode root, int targetSum) {
    return new V2().hasPathSum(root, targetSum);
  }

  // time O(n) space O(n)
  // DFS, iterative, preorder, very slow runtime
  static class V2 extends PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
      if (root == null) return false;

      class Temp {
        final int sum;
        final TreeNode node;

        Temp(int sum, TreeNode node) {
          this.sum = sum;
          this.node = node;
        }
      }

      LinkedList<Temp> stack = new LinkedList<>();
      stack.push(new Temp(targetSum - root.val, root));

      while (!stack.isEmpty()) {
        Temp temp = stack.pop();

        if (temp.node.left == null && temp.node.right == null & temp.sum == 0) return true;

        if (temp.node.left != null)
          stack.push(new Temp(temp.sum - temp.node.left.val, temp.node.left));
        if (temp.node.right != null)
          stack.push(new Temp(temp.sum - temp.node.right.val, temp.node.right));
      }

      return false;
    }
  }

  // time O(n) space O(n)
  // DPS, recursive, limited by the stack space
  static class V1 extends PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
      // if root is null
      if (root == null) return false;

      // if left and right are null then we found the bottom
      // if out bottom val equals the target sum then return true
      // meaning that we have found correct root-to-leaf path
      if (root.left == null && root.right == null && root.val == targetSum) return true;

      // prioritize left by short-circuit
      return hasPathSum(root.left, targetSum - root.val)
          || hasPathSum(root.right, targetSum - root.val);
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
    public String toString() {
      return "{" + "v=" + val + ", l=" + left + ", r=" + right + '}';
    }
  }
}
