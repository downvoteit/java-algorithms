package problems.easy.breadthfirstsearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/average-of-levels-in-binary-tree/
public class AverageOfLevelsInBinaryTree {
  public List<Double> averageOfLevels(TreeNode root) {
    return new V1().averageOfLevels(root);
  }

  // time O(n) space O(n)
  // BFS, level-order traversal
  static class V1 extends AverageOfLevelsInBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
      List<Double> output = new ArrayList<>();

      if (root == null) return output;

      Queue<TreeNode> queue = new LinkedList<>();
      queue.offer(root);

      while (!queue.isEmpty()) {
        int levelSize = queue.size();
        long levelSum = 0;

        for (int i = 0; i < levelSize; i++) {
          TreeNode node = queue.poll();

          if (node == null) continue;

          levelSum += node.val;

          if (node.left != null) queue.offer(node.left);
          if (node.right != null) queue.offer(node.right);
        }

        output.add(((double) levelSum / levelSize));
      }

      return output;
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
