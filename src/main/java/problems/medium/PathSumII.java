package problems.medium;

import java.util.List;

// https://leetcode.com/problems/path-sum-ii/
public class PathSumII {
  public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    return new V1().pathSum(root, targetSum);
  }

  static class V1 extends PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
      return null;
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
      StringBuilder sb = new StringBuilder().append(val);

      if (left != null) sb.append(", left=").append(left);
      if (right != null) sb.append(", right=").append(right);

      return sb.toString();
    }
  }
}
