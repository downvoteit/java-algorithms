package problems.medium.breadthfirstsearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/binary-tree-level-order-traversal/
public class BinaryTreeLevelOrderTraversal {
  public List<List<Integer>> levelOrder(TreeNode root) {
    return new V1().levelOrder(root);
  }

  // time O(n) space O(n)
  // BFS, level-order traversal, efficient
  static class V1 extends BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
      List<List<Integer>> output = new ArrayList<>();

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

        output.add(temp);
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
      return "{" + "v=" + val + ", l=" + left + ", r=" + right + '}';
    }
  }
}
