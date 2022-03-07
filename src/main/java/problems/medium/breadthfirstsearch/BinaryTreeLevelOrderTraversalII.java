package problems.medium.breadthfirstsearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
public class BinaryTreeLevelOrderTraversalII {
  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    return new V1().levelOrderBottom(root);
  }

  // time O(n) space O(n)
  // BFS, level-order traversal, efficient, stack for the results
  static class V1 extends BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
      LinkedList<List<Integer>> output = new LinkedList<>();

      if (root == null) return output;

      Queue<TreeNode> queue = new LinkedList<>();
      queue.offer(root);

      while (!queue.isEmpty()) {
        int levelSize = queue.size();
        List<Integer> temp = new ArrayList<>(levelSize);

        for (int i = 0; i < levelSize; i++) {
          TreeNode node = queue.poll();

          if (node == null) continue;

          temp.add(node.val);

          if (node.left != null) queue.offer(node.left);
          if (node.right != null) queue.offer(node.right);
        }

        if (temp.size() > 0) output.addFirst(temp);
      }

      return output;
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
