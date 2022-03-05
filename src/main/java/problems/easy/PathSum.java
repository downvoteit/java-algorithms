package problems.easy;

import java.util.LinkedList;

// https://leetcode.com/problems/path-sum/
public class PathSum {
  public boolean hasPathSum(TreeNode root, int targetSum) {
    return new V1().hasPathSum(root, targetSum);
  }

  static class V1 extends PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
      if (root == null) return false;

      System.out.println(root);

      LinkedList<TreeNode> stack = new LinkedList<>();
      stack.push(root);

      int count = 0, sum = 0;
      while (!stack.isEmpty()) {
        TreeNode node = stack.pop();

        sum += node.val;

        if (node.right != null) stack.push(node.right);
        if (node.left != null) stack.push(node.left);

        count++;

        if (node.right == null && node.left == null) {
          System.out.println(count + " " + sum + " " + targetSum);

          if (sum == targetSum) return true;

          sum -= node.val;
        }
      }

      return false;
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
      StringBuilder sb = new StringBuilder().append(val);

      if (left != null) sb.append(", left=").append(left);
      if (right != null) sb.append(", right=").append(right);

      return sb.toString();
    }
  }
}
