package algorithms.unsolved;

import java.util.List;

public class AverageOfLevelsInBinaryTree {
  public List<Double> averageOfLevels(TreeNode root) {
    return null;
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
  }
}
