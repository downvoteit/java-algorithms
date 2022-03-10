package problems.medium.breadthfirstsearch;

import java.util.*;

// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
public class BinaryTreeZigzagLevelOrderTraversal {
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    return new V1().zigzagLevelOrder(root);
  }

  // time O(n) space O(n)
  // BFS, level-order traversal, left-to-right then right-to-left results
  static class V1 extends BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
      List<List<Integer>> output = new ArrayList<>();

      if (root == null) return output;

      Queue<TreeNode> queue = new LinkedList<>();
      queue.offer(root);

      boolean leftToRight = true;

      while (!queue.isEmpty()) {
        int levelSize = queue.size();
        Integer[] temp = new Integer[levelSize];

        for (int i = 0; i < levelSize; i++) {
          TreeNode node = queue.poll();

          if (node == null) continue;

          if (leftToRight) {
            temp[i] = node.val;
          } else {
            temp[temp.length - 1 - i] = node.val;
          }

          if (node.left != null) queue.offer(node.left);
          if (node.right != null) queue.offer(node.right);
        }

        output.add(Arrays.asList(temp));
        leftToRight = !leftToRight;
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
