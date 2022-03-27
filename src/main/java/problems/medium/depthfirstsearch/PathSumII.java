package problems.medium.depthfirstsearch;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/path-sum-ii/
public class PathSumII {
  public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    return new V1().pathSum(root, targetSum);
  }

  // time O(n^2) space O(n)
  static class V1 extends PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
      List<List<Integer>> output = new ArrayList<>();
      List<Integer> temp = new ArrayList<>();

      recurse(root, output, temp, targetSum);

      return output;
    }

    private void recurse(
        TreeNode node, List<List<Integer>> output, List<Integer> temp, int targetSum) {
      if (node == null) return;

      temp.add(node.val);

      if (node.left == null && node.right == null && targetSum == node.val)
        output.add(List.copyOf(temp));

      recurse(node.left, output, temp, targetSum - node.val);
      recurse(node.right, output, temp, targetSum - node.val);

      temp.remove(temp.size() - 1);
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
